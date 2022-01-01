CREATE SEQUENCE sq_usertypes_admin_id START WITH 1;
CREATE SEQUENCE sq_usertypes_customer_id START WITH 1;
CREATE SEQUENCE sq_usertypes_brand_id START WITH 1;

create or replace trigger tg_add_user_id BEFORE INSERT ON loginUser
    FOR EACH ROW
    BEGIN
        IF :NEW.uTypeID = 1 THEN
            SELECT 'A' || lpad(sq_usertypes_admin_id.NEXTVAL, 4, '0') INTO :NEW.userID FROM dual;
        ELSIF :NEW.uTypeID = 2 THEN
            SELECT 'B' || lpad(sq_usertypes_brand_id.NEXTVAL, 4, '0') INTO :NEW.userID FROM dual;
        ELSE 
            SELECT 'C' || lpad(sq_usertypes_customer_id.NEXTVAL, 4, '0') INTO :NEW.userID FROM dual;
        END IF;
    END;
/

CREATE OR REPLACE TRIGGER InitializeCustomerStatus BEFORE INSERT ON CustomerTierStatus FOR EACH ROW
DECLARE
    tier_name VARCHAR2(10) default null;
    is_tiered NUMBER(1,0);
    is_valid NUMBER(1,0) default 0;
BEGIN
    SELECT L.pstate INTO is_valid FROM loyaltyprogram L WHERE L.brandID = :new.brandID;
    IF(is_valid = 0) THEN
        RAISE_APPLICATION_ERROR(-20021,'Can not enroll to this loyalty program as it is not validated',False);
    END IF;
    IF (:new.TierStatus IS NULL) THEN
        SELECT L.IsTier INTO is_tiered FROM loyaltyprogram L WHERE L.brandID = :new.brandID;
        IF(is_tiered = 1) THEN
            SELECT T.lname INTO tier_name FROM tierprogram T WHERE T.brandID = :new.brandID and T.pointsReq = 0;
        END IF;
    END IF;
    SELECT tier_name INTO :new.TierStatus FROM dual;
END;
/

CREATE OR REPLACE TRIGGER UpdateCustomerStatusInLoyaltyProgram AFTER INSERT ON wallets FOR EACH ROW
DECLARE
    current_level VARCHAR(45) default null;
    totalPoints integer;
BEGIN
    IF(:new.activityType='RE') THEN
        SELECT CTS.TierStatus, CTS.totalPoints INTO current_level, totalPoints FROM CustomerTierStatus CTS WHERE CTS.customerID = :new.customerID and CTS.brandID = :new.brandID;
        totalPoints := totalPoints + :new.activityPoints;
        IF(current_level IS NOT NULL) THEN
            select g.lname into current_level from (select * from tierprogram t where t.brandID = :new.brandID and t.lname is not null and t.pointsReq <= totalPoints ORDER BY t.pointsReq DESC) g where rownum = 1;
        END IF;
        update CustomerTierStatus CTS set CTS.TIERSTATUS = current_level,CTS.balancePoints = CTS.balancePoints+ :new.activityPoints,CTS.TOTALPOINTS = CTS.totalPoints+ :new.activityPoints where CTS.customerID = :new.customerID and CTS.brandID = :new.brandID;
    ELSIF(:new.activityType='RR') THEN
        update CustomerTierStatus CTS set CTS.balancePoints = CTS.balancePoints-:new.activityPoints where CTS.customerID = :new.customerID and CTS.brandID = :new.brandID;
    END IF;
END;
/


CREATE OR REPLACE TRIGGER AddPointsForWalletActivity BEFORE INSERT ON wallets FOR EACH ROW
DECLARE
    balance_points NUMBER(10) default 0;
    qty NUMBER(10) default 0;
    point_req NUMBER(10) default 0;
    multiplier INT default 1;
    is_tiered NUMBER(1,0);
    tier_name VARCHAR2(10) default null;
    expiry_date date;
BEGIN
    SELECT current_timestamp INTO :new.activityDate FROM dual;
    IF (:new.activityType='RE') THEN
        select r.points into point_req from RErules r INNER JOIN (select brandID,rule_code,max(versionno) as vv from RErules group by brandID,rule_code) b ON r.brandID = b.brandID AND r.rule_code = b.rule_code AND r.versionno = b.vv 
        where r.BrandID =:new.BrandID and r.activityID = :new.activityCode;
        SELECT L.IsTier INTO is_tiered FROM loyaltyprogram L WHERE L.brandID = :new.brandID;
        IF(is_tiered = 1) THEN
            SELECT CTS.TierStatus INTO tier_name FROM CustomerTierStatus CTS WHERE CTS.customerID = :new.customerID and CTS.brandID = :new.brandID;
            SELECT T.MULTIPLIER INTO multiplier FROM tierprogram T WHERE T.lname = tier_name;
        END IF;
        dbms_output.Put_line(point_req);
        dbms_output.Put_line(multiplier);
        dbms_output.Put_line(is_tiered);
        dbms_output.Put_line(tier_name); --display
        :new.activityPoints := point_req * multiplier;
    ELSIF (:new.activityType='RR') THEN
        select r.points into point_req from RRrules r INNER JOIN (select brandID,rule_code,max(versionno) as vv from RRrules group by brandID,rule_code) b ON r.brandID = b.brandID AND r.rule_code = b.rule_code AND r.versionno = b.vv 
        where r.BrandID =:new.BrandID and r.rewardID = :new.activityCode;
        select CTS.TierStatus, CTS.balancePoints INTO tier_name, balance_points FROM CustomerTierStatus CTS WHERE CTS.customerID = :new.customerID and CTS.brandID = :new.brandID;
        select rwd.quantity into qty from rewards rwd where rwd.brandID = :new.brandID and rwd.rewardID = :new.activityCode;
        IF(qty <1) THEN
            RAISE_APPLICATION_ERROR(-20020,'Reward can not be redeemed, no more reward instances available.',False);
            return;
        ELSIF(balance_points < point_req) THEN
           RAISE_APPLICATION_ERROR(-20020,'Reward can not be redeemed, insufficient points to redeem reward.',False);
            return;
        ELSE
            SELECT point_req INTO :new.activityPoints FROM dual;
            update rewards rwd set rwd.quantity = rwd.quantity-1 where rwd.brandID = :new.brandID and rwd.rewardID = :new.activityCode;
            insert into claims values (DEFAULT,:new.brandID,:new.activityCode,:new.customerID,0,(SYSDATE)+90);
        END IF;
    END IF;
END;
/

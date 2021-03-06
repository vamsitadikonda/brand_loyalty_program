create table userTypes
(
 uTypeID  integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
 userType varchar(20) NOT NULL,
 constraint pk_userTypes primary key (uTypeID) 
);
    
insert into userTypes 
values(DEFAULT,'ADMIN');

insert into userTypes 
values(DEFAULT,'BRANDS');

insert into userTypes 
values(DEFAULT,'CUSTOMERS');


create table loginUser
(
 username varchar(45) NOT NULL,
 passwd varchar(45) NOT NULL,
 uTypeID integer NOT NULL,
 userID varchar(45) NOT NULL,
 constraint unique_loginUser unique(username),
 constraint pk_loginUser primary key (userID),
 constraint fk_loginUser foreign key(uTypeID) references userTypes(uTypeID)
);

create table brands
(
 bname     varchar(45) NOT NULL ,
 address  varchar(90),
 joinDate date NOT NULL ,
 brandID  varchar(45) NOT NULL ,
 constraint pk_brands primary key (brandID),
 constraint fk_brands foreign key(brandID) references loginUser(userID)
);

create table customers
(
 address  varchar(90),
 cname     varchar(45) NOT NULL ,
 phoneno  number(15),
 walletID integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
 customerID varchar(45) NOT NULL,
 constraint unique_customers unique (walletID),
 constraint pk_customers primary key (customerID),
 constraint fk_customers foreign key(customerID) references loginUser(userID)
);

create table loyaltyprogram(
 pstate number(1,0) DEFAULT 0,
 lcode varchar(45) NOT NULL,
 brandID varchar(45) NOT NULL,
 lname varchar(45) NOT NULL,
 IsTier number(1,0) DEFAULT 0,
 constraint unique_lprogram unique (lcode), 
 constraint pk_lprogram primary key(brandID),
 constraint fk_lprogram foreign key(brandID) references brands(brandID) ON DELETE CASCADE
);

create table tierprogram(
 brandID varchar(45) NOT NULL,
 levelno integer NOT NULL,
 multiplier integer NOT NULL,
 pointsReq integer NOT NULL,
 lname varchar(45) NOT NULL,
 constraint unique_tierprogram unique(brandID,levelno),
 constraint pk_tierprogram primary key(brandID,lname),
 constraint fk_tierprogram foreign key(brandID) references loyaltyprogram(brandID) ON DELETE CASCADE
);

create table rewardTypes
(
 rTypeID integer NOT NULL,
 rTypeName varchar(45) NOT NULL,
 constraint pk_rewardTypes primary key (rTypeID) 
);

create table rewards
(
 brandID  varchar(45) NOT NULL,
 rewardID varchar(45) NOT NULL,
 rTypeID  integer NOT NULL,
 quantity integer NOT NULL,
 amount   integer, 
 constraint pf_rewards primary key(brandID, rewardID),
 constraint fk_rewards_rtype foreign key(rTypeID) references rewardTypes(rTypeID), 
 constraint fk_rewards_brand foreign key(brandID) references loyaltyprogram(brandID) ON DELETE CASCADE
);

create table activityTypes
(
 aTypeID integer NOT NULL,
 aTypeName varchar(20) NOT NULL,
 constraint pk_activityTypes primary key (aTypeID) 
);

create table activities
(
 brandID  varchar(45) NOT NULL ,
 activityID varchar(45) NOT NULL,
 aTypeID integer NOT NULL,
 constraint pf_activities primary key(brandID, activityID),
 constraint fk_activities foreign key(aTypeID) references activityTypes(aTypeID), 
 constraint fk_activities_brands foreign key(brandID) references loyaltyprogram(brandID) ON DELETE CASCADE
);

/*Add ActivityType*/ 
insert into activityTypes
values(1,'purchase');

insert into activityTypes
values(2,'leave a review');

insert into activityTypes
values(3,'refer a friend');

/*Add Reward Type*/

insert into rewardTypes
values(1,'gift card');

insert into rewardTypes
values(2,'free product');


CREATE TABLE RERules
(
 rule_code integer NOT NULL ,
 versionno integer NOT NULL ,
 activityID varchar(45) NOT NULL ,
 brandID   varchar(45) NOT NULL ,
 points    integer NOT NULL ,
 constraint pk_RERules primary key(rule_code, versionno, brandID),
 constraint fk_RERules foreign key(activityID,brandID) references activities(activityID,brandID) ON DELETE CASCADE
);

CREATE TABLE RRRules
(
 rule_code integer NOT NULL ,
 versionno   integer NOT NULL ,
 rewardID  varchar(45) NOT NULL ,
 brandID   varchar(45) NOT NULL ,
 points    integer NOT NULL ,
 constraint pk_RRRules primary key(rule_code, versionno, brandID),
 constraint fk_RRRules_rewards foreign key(rewardID,brandID) references rewards(rewardID,brandID) ON DELETE CASCADE
);

CREATE TABLE wallets
(
 transID integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
 brandID varchar(45) NOT NULL,
 customerID varchar(45) NOT NULL,
 activityCode varchar(45) NOT NULL,
 activityDate TIMESTAMP NOT NULL,
 activityType varchar(45) NOT NULL,
 activityPoints integer NOT NULL,
 /*   ACTIVITY_NAME VARCHAR2(20) NOT NULL,*/
 constraint check_performActivity_activity_code CHECK (activityType in ('RE','RR')),
 constraint fk_performActivity_customer foreign key(customerID) references customers(customerID) ON DELETE CASCADE,
 constraint fk_performActivity_lprogram foreign key(brandID) references loyaltyprogram(brandID) ON DELETE SET NULL
);

CREATE TABLE CustomerTierStatus 
(
 brandID varchar(45) NOT NULL,
 customerID varchar(45) NOT NULL,    
 totalPoints integer DEFAULT 0,
 balancePoints integer DEFAULT 0,
 TierStatus varchar(45) NOT NULL,
 constraint pk_CustomerTierStatus primary key(brandID,customerID),
 constraint fk_CustomerTierStatus_customer foreign key(customerID) references customers(customerID) ON DELETE CASCADE,
 constraint fk_CustomerTierStatus_tierprogram foreign key(brandID,TierStatus) references tierprogram(brandID,lname) ON DELETE CASCADE
);


CREATE TABLE Claims
(
 claimID integer GENERATED BY DEFAULT ON NULL AS IDENTITY,
 brandID varchar(45) NOT NULL,
 rewardID varchar(45) NOT NULL,
 customerID varchar(45) NOT NULL,    
 claimed number(1,0) DEFAULT 0,
 expiry_date date,
 constraint fk_Claims_customer foreign key(customerID) references customers(customerID) ON DELETE SET NULL,
 constraint fk_Claims_rewards foreign key(brandID,rewardID) references rewards(brandID,rewardID) ON DELETE CASCADE
);



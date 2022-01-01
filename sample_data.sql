/*Admin*/
insert into loginUser
values ('admin','passwd',1,DEFAULT);

/*brand Signup &  AddBrand*/ 
insert into loginUser
values ('brand1','passwd1',2,DEFAULT);

insert into brands
values('Brand X','503 Rolling Creek Dr, Austin, AR',TO_DATE('01/04/2021', 'DD/MM/YYYY'),(select userID from loginUser where username='brand1'));

insert into loginUser
values ('brand2','passwd2',2,DEFAULT);

insert into brands
values('Brand Y','"939 Orange Ave, Coronado, CA"',TO_DATE('25/03/2021', 'DD/MM/YYYY'),(select userID from loginUser where username='brand2'));


insert into loginUser
values ('brand3','passwd3',2,DEFAULT);

insert into brands
values('Brand Z','20 Roszel Rd, Princeton, NJ',TO_DATE('05/08/2021', 'DD/MM/YYYY'),(select userID from loginUser where username='brand3'));


/*User Signup & Add Customer*/
insert into loginUser
values ('user1','passwd1',3,DEFAULT);

insert into customers
values ('20 Ingram Street, NY','Peter Parker',8636368778,DEFAULT,(select userID from loginUser where username='user1'));

insert into loginUser
values ('user2','passwd2',3,DEFAULT);

insert into customers
values ('569 Leaman Place, NY','Steve Rogers',8972468552,DEFAULT,(select userID from loginUser where username='user2'));

insert into loginUser
values ('user3','passwd3',3,DEFAULT);

insert into customers
values ('1700 Broadway St, NY','Diana Prince',8547963210,DEFAULT,(select userID from loginUser where username='user3'));


/*Show Brand info*/
--select * from brands where bname like 'Brand X';

/*Show Customer info*/
--select * from customers where customerId IN (select userID from loginUser where username='user1');

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

/*Add Loyalty Program */
/*REGULAR*/
insert into LoyaltyProgram
values (0,'RLP01','B0003','TechSups',0);

/*Showing All Activity Types*/
select * from ActivityTypes;
/*Selecting from Activity Types*/
insert into Activities
values('B0003','A03',3);
/*Showing All Activity Types*/
select * from rewardTypes;
/*Selecting from Reward Types*/
insert into Rewards
values ('B0003','R01',1,25,25);
/*Adding RE Rules*/
insert into RERules
values (1,1,'A03','B0003',10);

/*Adding RR Rules*/
insert into RRRules
values (1,1,'R01','B0003',100);

/*TIERED*/
insert into LoyaltyProgram
values (0,'TLP01','B0001','SportGoods',1);
/*Adding Tier info*/
insert into TierProgram
values ('B0001',1,1,0,'Bronze');

insert into TierProgram
values ('B0001',2,2,170,'Silver');

insert into TierProgram
values ('B0001',3,3,270,'Gold');

/*Showing All Activity Types*/
select * from ActivityTypes;
/*Selecting from Activity Types*/
insert into Activities
values('B0001','A01',1);
insert into Activities
values('B0001','A02',2);
/*Showing All Activity Types*/
select * from rewardTypes;
/*Selecting from Reward Types*/
insert into Rewards
values ('B0001','R01',1,5,5);
insert into Rewards
values ('B0001','R02',2,10,20);
/*Adding RE Rules*/
insert into RERules
values (1,1,'A01','B0001',15);

insert into RERules
values (2,1,'A02','B0001',10);

/*Adding RR Rules*/
insert into RRRules
values (1,1,'R01','B0001',80);

insert into RRRules
values (2,1,'R02','B0001',70);

/*???????? VALIDATE ?????*/
update LoyaltyProgram
set pstate=1
where brandID = 'B0001';


/*Adding Brnad2*/
insert into LoyaltyProgram
values (0,'TLP02','B0002','MegaCenter',1);
/*Adding Tier info*/
insert into TierProgram
values ('B0002',1,1,0,'Special');

insert into TierProgram
values ('B0002',2,2,120,'Premium');

/*Showing All Activity Types*/
select * from ActivityTypes;
/*Selecting from Activity Types*/
insert into Activities
values('B0002','A01',1);
insert into Activities
values('B0002','A03',3);
/*Showing All Activity Types*/
select * from rewardTypes;
/*Selecting from Reward Types*/
insert into Rewards
values ('B0002','R01',1,3,13);
insert into Rewards
values ('B0002','R02',2,7,25);
/*Adding RE Rules*/
insert into RERules
values (1,1,'A01','B0002',40);

insert into RERules
values (2,1,'A03','B0002',30);

/*Adding RR Rules*/
insert into RRRules
values (1,1,'R01','B0002',120);

insert into RRRules
values (2,1,'R02','B0002',90);

/*???????? VALIDATE ?????*/
update LoyaltyProgram
set pstate=1
where brandID = 'B0002';

insert into CustomerTierStatus 
values ('B0001','C0001',DEFAULT,DEFAULT,DEFAULT);

insert into CustomerTierStatus 
values ('B0002','C0001',DEFAULT,DEFAULT,DEFAULT);

insert into CustomerTierStatus 
values ('B0003','C0001',DEFAULT,DEFAULT,DEFAULT);

insert into CustomerTierStatus 
values ('B0001','C0002',DEFAULT,DEFAULT,DEFAULT);

insert into CustomerTierStatus 
values ('B0002','C0002',DEFAULT,DEFAULT,DEFAULT);

insert into wallets
values(DEFAULT,'B0001','C0001','A01',DEFAULT,'RE',DEFAULT);

/*Refer a Friend*/
insert into wallets
values(DEFAULT,'B0002','C0001','A03',TO_DATE('3/10/2021', 'DD/MM/YYYY'),'RE',DEFAULT);

insert into wallets
values(DEFAULT,'B0002','C0001','A03',TO_DATE('18/10/2021', 'DD/MM/YYYY'),'RE',DEFAULT);

insert into wallets
values(DEFAULT,'B0002','C0001','A03',TO_DATE('18/10/2021', 'DD/MM/YYYY'),'RE',DEFAULT);

/*Write a Review*/
insert into wallets
values(DEFAULT,'B0002','C0001','A03',TO_DATE('3/10/2021', 'DD/MM/YYYY'),'RE',DEFAULT);

select * from RErules r INNER JOIN (select brandID,rule_code,max(versionno) as vv from RErules group by brandID,rule_code) b ON r.brandID = b.brandID AND r.rule_code = b.rule_code AND r.versionno = b.vv 
where r.BrandID = 'B0002' and r.activityID = 'A02';


insert into wallets
values(DEFAULT,'B0001','C0001','A03',TO_DATE('18/6/2021', 'DD/MM/YYYY'),'RE',DEFAULT);

select * from wallets;
select * from CustomerTierStatus;
select * from claims;
select * from rewards;
/*REWARD CLAIMING*/
update rewards  set quantity= 3 where brandID = 'B0002' and rewardID='R01';
insert into wallets
values(DEFAULT,'B0002','C0001','R01',TO_DATE('3/7/2021', 'DD/MM/YYYY'),'RR',DEFAULT);


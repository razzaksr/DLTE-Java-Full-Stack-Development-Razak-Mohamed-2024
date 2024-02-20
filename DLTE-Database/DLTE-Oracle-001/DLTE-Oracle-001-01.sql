sqlplus

system

-- DDL: create a table
create table transaction_second(transaction_id number not null, transaction_date date not null, transaction_to varchar(255) not null, transaction_amount number(10) not null, transaction_remarks varchar(255) not null);

-- structure check
describe transaction_second;

-- Alter: Adding primary key without sequence
alter table transaction_second add primary key(transaction_id);

-- DDL: Drop column
alter table transaction_second drop column transaction_id;

-- DDL: add column
alter table transaction_second add transaction_id number not null;

-- DDL: creating sequence
create sequence transaction_seq start with 2024001 increment by 1;

-- DDL: declare primary key with sequence
alter table transaction_second add constraint transaction_seq primary key(transaction_id);

-- DDL: drop sequence
drop sequence transaction_seq;

-- DML
insert into transaction_second(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_seq.nextval,20000,'21Feb2024','Richard R','Rent');

-- TCL
commit;

-- DML
insert into transaction_second(transaction_id,transaction_amount,transaction_date,transaction_to,transaction_remarks) values(transaction_seq.nextval,21000,'23Feb2024','Sabarinathan S','Bills');

-- TCL
rollback;

-- DQL:
select * from transaction_second;

-- DDL: view
create view emergency_name as select transaction_to from transaction_second where transaction_remarks='Emergency';

-- DDL: replace view
create or replace view emergency_name as select transaction_to,transaction_date from transaction_second where transaction_remarks='Emergency';

-- DML: update
update transaction_second set transaction_remarks='Medical Need' where transaction_remarks='Emergency';

-- DML: truncate
truncate table transaction_second;

-- DDL:
drop table transaction_second;
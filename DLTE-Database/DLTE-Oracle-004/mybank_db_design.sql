create table mybank_creditcard(creditcard_number number primary key, creditcard_cvv number, creditcard_expiry date,creditcard_pin number,creditcard_limit number, creditcard_usage number, creditcard_available number, creditcard_status int,creditcard_holder varchar(255));
create table mybank_merchant(merchant_id number primary key,merchant_name varchar(255));
create table mybank_transaction(transaction_id number,transaction_date date,transaction_amount number, creditcard number,merchant number);
create sequence mybank_seq start with 240301 INCREMENT by 1;
alter table mybank_transaction add constraint mybank_seq primary key(transaction_id);
alter table mybank_transaction add FOREIGN key(creditcard) references mybank_creditcard(creditcard_number);
alter table mybank_transaction add FOREIGN key(merchant) references mybank_merchant(merchant_id);
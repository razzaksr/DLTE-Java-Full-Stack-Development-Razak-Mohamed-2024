-- before normalization
--create table mybank_creditcard_before_norm(creditcard_number number, creditcard_cvv number, creditcard_expiry date,creditcard_pin number,creditcard_limit number, creditcard_usage number, creditcard_available number, creditcard_status int,merchant_name varchar(255),transaction_date date,transaction_amount number,creditcard_holder varchar(255));

-- 1st normal form
--create table mybank_creditcard_first_norm(creditcard_number number primary key, creditcard_cvv number, creditcard_expiry date,creditcard_pin number,creditcard_limit number, creditcard_usage number, creditcard_available number, creditcard_status int,creditcard_holder varchar(255));
--create table mybank_transaction_first_norm(transaction_id number primary key,merchant_name varchar(255),transaction_date date,transaction_amount number);

-- 2nd normal form
--create table mybank_transaction_second_norm(transaction_id number primary key,transaction_date date,transaction_amount number);
--create table mybank_merchant_second_norm(merchant_id number primary key,merchant_name varchar(255));

create table mybank_transaction_third_norm(transaction_id number primary key,transaction_date date,transaction_amount number, creditcard number,merchant number);
alter table mybank_transaction_third_norm add FOREIGN key(creditcard) references mybank_creditcard_first_norm(creditcard_number);
alter table mybank_transaction_third_norm add FOREIGN key(merchant) references mybank_merchant_second_norm(merchant_id);
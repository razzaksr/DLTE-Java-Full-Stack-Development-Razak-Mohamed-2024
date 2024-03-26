--create index expriry_index on mybank_creditcard(creditcard_expiry);
--DROP index expriry_index;

--select * from mybank_creditcard where creditcard_expiry between '01-JAN-2028' and '31-DEC-2036';

--explain plan for
----select * from mybank_creditcard where creditcard_available>=100000;
--    select * from mybank_creditcard where creditcard_expiry between '01-JAN-2028' and '31-DEC-2036';


--create index comb_index on mybank_creditcard(creditcard_limit,creditcard_available);

--select creditcard_holder from mybank_creditcard where creditcard_limit>=25000 and creditcard_available>=10000;

--explain plan for
--    select creditcard_holder from mybank_creditcard where creditcard_limit>=25000 and creditcard_available>=10000;
--    


explain plan for
--select * from mybank_creditcard where creditcard_expiry between '01-JAN-2028' and '31-DEC-2036';
select /*+ INDEX(mybank_creditcard expriry_index) */ * from mybank_creditcard where creditcard_expiry between '01-JAN-2028' and '31-DEC-2036';
select * from table(DBMS_XPLAN.DISPLAY);
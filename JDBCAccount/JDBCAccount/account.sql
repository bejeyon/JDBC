--hr계정으로 실행
drop table accounts purge;

create table hr.accounts
  (ano     varchar2(10),
   owner   varchar2(10),
   balance number);

  alter table hr.accounts
  add constraint accounts_ano_pk primary key(ano);

  
  select * from hr.accounts;

  insert into hr.accounts(ano,owner,balance) values ('111-111', '나자바', 100);
  insert into hr.accounts(ano,owner,balance)  values('222-222', '토레타', 20000);
  insert into hr.accounts(ano,owner,balance)  values('333-333', '제임스', 10000);
  commit;
  select * from hr.accounts;  

  UPDATE hr.accounts set balance = (balance+10000) where ano  ='111-111';
  select * from hr.accounts;  

  UPDATE hr.accounts set balance = (balance -5000) where ano  ='111-111';

  select * from hr.accounts;  

  delete from hr.accounts where ano='111-111';
  commit;
  select * from hr.accounts;
  
  select count(*) from hr.accounts where ano='222-222';




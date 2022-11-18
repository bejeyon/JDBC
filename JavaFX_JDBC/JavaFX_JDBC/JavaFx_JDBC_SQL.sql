--sqlplus system/oracle@localhost:1521/xepdb1

  drop user yb cascade;
 
  create user yb
  identified by yb
  default tablespace apps
  temporary tablespace temp
  quota 10m on users
  quota 10m on apps;

  grant connect, resource, dba 
  to yb;  

  drop table yb.employees   purge;
  drop table yb.departments purge;

  create table yb.departments as select * from hr.departments;
  create table yb.employees   as select * from hr.employees;

  drop sequence yb.sequence_employee;
  create sequence yb.sequence_employee start with 300;
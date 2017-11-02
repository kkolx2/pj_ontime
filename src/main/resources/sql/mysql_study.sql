
select * from dept;
select * from emp;

update emp
   set gender = 'F'
 where gender = 'f';
commit; 


select * from tbl_dept;
select * from tbl_emp;

insert into tbl_dept
select * from dept;

insert into tbl_emp
(comm, deptno, empno, ename, gender, hiredate, job, mgr, sal)
select comm, deptno, empno, ename, gender, hiredate, job, mgr, sal from emp;

insert into tbl_profile 
(fname, curr)
values
("user01_profile", 1);

select * from tbl_profile;

select e from Emp e inner join e.dept d where d.deptno = :deptno

SELECT emp0_.empno AS empno1_2_,
       emp0_.comm AS comm2_2_,
       emp0_.deptno AS deptno9_2_,
       emp0_.ename AS ename3_2_,
       emp0_.gender AS gender4_2_,
       emp0_.hiredate AS hiredate5_2_,
       emp0_.job AS job6_2_,
       emp0_.mgr AS mgr7_2_,
       emp0_.sal AS sal8_2_
  FROM emp emp0_ INNER JOIN dept dept1_ ON emp0_.deptno = dept1_.deptno
 WHERE dept1_.deptno = 10;
 
  create table tbl_profile (
       fno bigint not null auto_increment,
        curr bit not null,
        fname varchar(255),
        primary key (fno)
    ) engine=InnoDB;
 
    select * from tbl_webboard limit 0,10;
    
    select * from id_gen;
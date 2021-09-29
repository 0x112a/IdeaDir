# MySql 的CURD

TaskDay3

- 建表

```sql
create table if not exists t_dept(
    id int primary key,
    name varchar(30) unique not null   
);

create table if not exists t_emp(
    id int primary key,
    name varchar(30) not null,
    age int,
    sex char,
    phone varchar(11),
    salary double,
    email varchar(50),
    did int,
    foreign  key (did) references t_dept(id)
);
```

- 增加

  ```sql
  insert into t_dept(id,name) values('1','刘备');
  
  insert into t_emp(id,name,age,sex,phone,salary,email,did)values('1','关二爷','66','男','12345678901','3300','guanere@gmail.com','1');
  ```

  

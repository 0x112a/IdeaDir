# Clould Note Sql

```sql
create table tb_user(
    user_id int AUTO_INCREMENT,
    user_name varchar(50) NOT NULL,
    user_pwd varchar(500) NOT NULL,
    nick varchar(50) NOT NULL,
    head varchar(100) NOT NULL,
    mood varchar(500) NOT NULL,
    PRIMARY KEY(user_id)
);

insert into tb_user(user_name,user_pwd,nick,head,mood) value("monica","1q2w3e","alice","emjoy","nice");

create table tb_note_type(
    type_id int AUTO_INCREMENT,
    type_name varchar(50) NOT NULL,
    user_id int NOT NULL,
    PRIMARY KEY(type_id)
);
insert into tb_note_type(type_name,user_id) value("Study",1);

create table tb_note(
	note_id int AUTO_INCREMENT,
    title varchar(50) NOT NULL,
    content text NOT NULL,
    type_id int NOT NULL,
    public_time timestamp NOT NULL,
    lon float NOT NULL,
    lat float NOT NULL,
    PRIMARY KEY(note_id)
);


```


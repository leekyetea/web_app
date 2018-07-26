
drop table hd_user;
create table hd_user (
    id varchar2(10) not null,
    name varchar2(20) not null,
    pw varchar2(10) not null,
    dob date not null,
    email varchar2(30),
    country varchar2(10) not null, 
    PRIMARY KEY (id)
);

alter table hd_user modify pw varchar(128);
desc hd_user;
drop table hd_application;

create table hd_application (
    id varchar2(10) not null,
    major varchar2(30) not null,
    dob date not null,
    email varchar2(50),
    country varchar2(10),
    constraint cons_id foreign key (id) references hd_user(id)
);

insert into hd_application (id, major, dob)
values ('jitaek', '국문', '2018-1-15');

delete from hd_application where id='jitaek';

insert into hd_user (id, pw, name, dob, email, country)
values ('jitaek', '1234', '임지택', '1999-11-11', 'jitaek@gmail.com', 'Korea');

select * from hd_user;
select * from hd_application;
select * from hd_user where id='aaa';

insert into hd_user (id, pw, name,dob)
values ('jitaek', '1234', '임지택', '1999-1-1');
delete from hd_user where id='jitaek';
delete from hd_user;
commit;
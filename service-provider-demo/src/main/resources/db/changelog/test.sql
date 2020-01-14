--liquibase formatted sql

--changeset xw:1
create table test1 (
    id int primary key,
    name varchar(255),
    name2 varchar(255)
);

--changeset xw:2
insert into test1 (id, name) values (1, 'name 1');
insert into test1 (id, name) values (2, 'name 2');

--changeset xw:3
ALTER TABLE test1 ADD COLUMN name3 varchar(255)

--changeset xw:test-3
create table test4 (
    id int primary key,
    name varchar(255)
);
--rollback drop table test4;

--changeset xw:test-4
create table test5 (
    id int primary key,
    name varchar(255)
);
--rollback drop table test5;


--changeset xw:test-5
create table test6 (
    id int primary key,
    name varchar(255)
);
--rollback drop table test6;
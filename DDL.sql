create table member (
	id varchar2(30) not null,
	name varchar2(30) not null,
	password varchar2(256) not null,
	email varchar2(50) not null,
	create_date date default sysdate,
	modify_date date
);

alter table member add constraint pk_member primary key (id);

drop table board;

create table board (
	no number generated always as IDENTITY primary key,
	writer varchar2(30) not null,
	title varchar2(1000),
	content varchar2(4000),
	create_date date default sysdate,
	modify_date date,
	hits number default 0
);





create table category(
	id bigint  primary key not null auto_increment ,
    name nvarchar(50)  not null,
    code nvarchar(50)  not null,
	createdby nvarchar(100),
	modifiedby nvarchar(100),
    creaddate timestamp ,
    modifieddate timestamp 
);

create table item(
	id bigint  primary key not null auto_increment ,
    name nvarchar(50)  not null,
    title nvarchar(50) not null,
    shortdescription text,
    content text,
	categoryid bigint,
	createdby nvarchar(100),
	modifiedby nvarchar(100),
    creaddate timestamp,
	modifieddate timestamp,
	foreign key (categoryid) references category(id)
)

create table role(
	id bigint  primary key not null auto_increment ,
    name nvarchar(50)  not null,
    code nvarchar(50)  not null
)
create table user(
	id bigint  primary key not null auto_increment,
    username nvarchar(50) not null,
    password nvarchar(50) not null,
    fullname nvarchar(100) not null,
    roleid bigint ,
    createdby nvarchar(100),
	modifiedby nvarchar(100),
    createddate timestamp,
	modifieddate timestamp,
    foreign key (roleid) references role(id)
)

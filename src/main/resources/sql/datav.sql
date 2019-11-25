use luo;

create table User(
id int primary key,
name varchar not null,
password varchar not null,
createTimestamp varchar not null
);
create table Com(
id int primary key,
name varchar not null,
screenId int not null,
dataSourceId int not null,
config varchar not null,
createTimestamp varchar not null,
updateTimestamp varchar not null
)
create table Screen(
id int primary key ,
name varchar not null,
userId int not null,
config varchar not null,
createTimestamp varchar not null,
updateTimestamp varchar not null
)
create table DataSource(
id int primary key ,
name varchar not null,
userId int not null,
data varchar not null,
createTimestamp varchar not null,
updateTimestamp varchar not null
)
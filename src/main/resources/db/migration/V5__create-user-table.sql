create table user(
    id bigint not null auto_increment,
    login varchar(50) not null unique,
    password varchar(255) not null,
    primary key(id)
);
create table user_accounts
(
    id            serial primary key,
    name          varchar(300) not null,
    login         varchar(50)  not null,
    password      varchar(50)  not null,
    secret_word   varchar(50)  not null,
    birth_date    date         not null,
    passport_info varchar(200) not null
);

create table cards
(
    id                 serial primary key,
    number             varchar(200) not null unique,
    valid_thru         varchar(5)   not null,
    card_security_code integer      not null,
    card_type          varchar(100) not null
);

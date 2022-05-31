create table operations
(
    id              serial primary key,
    date            date         not null,
    operation_type  varchar(200) not null,
    operation_info  varchar(200) not null,
    card_id         integer,
    constraint fk_card_id foreign key (card_id) references cards (id),
    user_account_id integer,
    constraint fk_user_account_id foreign key (user_account_id) references user_accounts (id)
);


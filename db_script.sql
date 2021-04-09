create table authorities
(
    authorityId int auto_increment
        primary key,
    AUTHORITY   varchar(255) null
);

create table blogs
(
    id           bigint auto_increment
        primary key,
    AUTHOR       varchar(255) not null,
    BLOGCONTENTS longblob     not null,
    CONTENTS     varchar(255) null,
    DATECREATED  datetime     not null,
    TITLE        varchar(255) not null
);

create table comment
(
    id              bigint auto_increment
        primary key,
    AUTHOR          varchar(255) not null,
    COMMENTCONTENTS tinyblob     not null,
    CONTENTS        varchar(255) null,
    blog_id         bigint       null,
    constraint FKr2i27rhmf7u6pb3vgksgjp98c
        foreign key (blog_id) references blogs (id)
            on delete cascade
);

create table users
(
    USERNAME varchar(255) not null
        primary key,
    EMAIL    varchar(255) not null,
    ENABLED  bit          null,
    PASSWORD varchar(255) not null
);

create table user_roles
(
    username    varchar(255) not null,
    authorityId int          not null,
    primary key (username, authorityId),
    constraint FKi8la7mj8xkryi96gxc1hc5nhh
        foreign key (username) references users (USERNAME),
    constraint FKoq0ourkl718qj9kckwejabg8
        foreign key (authorityId) references authorities (authorityId)
);



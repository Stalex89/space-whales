# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table place (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  country                       varchar(255),
  location                      varchar(255),
  description                   varchar(255),
  picture                       varbinary(255),
  rating                        integer not null,
  constraint pk_place primary key (id)
);


# --- !Downs

drop table if exists place;


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

create table tshirt (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  size                          integer,
  gender                        integer,
  rarity                        integer,
  picture                       varbinary(255),
  description                   varchar(255),
  constraint ck_tshirt_size check ( size in (0,1,2,3,4,5)),
  constraint ck_tshirt_gender check ( gender in (0,1)),
  constraint ck_tshirt_rarity check ( rarity in (0,1,2,3,4)),
  constraint pk_tshirt primary key (id)
);


# --- !Downs

drop table if exists place;

drop table if exists tshirt;


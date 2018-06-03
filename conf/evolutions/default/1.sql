# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table chest (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  price                         decimal(38),
  picture_url                   varchar(255),
  description                   varchar(255),
  constraint pk_chest primary key (id)
);

create table chest_tshirt (
  chest_id                      bigint not null,
  tshirt_id                     bigint not null,
  constraint pk_chest_tshirt primary key (chest_id,tshirt_id)
);

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
  picture_url                   varchar(255),
  description                   varchar(255),
  constraint ck_tshirt_size check ( size in (0,1,2,3,4,5)),
  constraint ck_tshirt_gender check ( gender in (0,1)),
  constraint ck_tshirt_rarity check ( rarity in (0,1,2,3,4)),
  constraint pk_tshirt primary key (id)
);

alter table chest_tshirt add constraint fk_chest_tshirt_chest foreign key (chest_id) references chest (id) on delete restrict on update restrict;
create index ix_chest_tshirt_chest on chest_tshirt (chest_id);

alter table chest_tshirt add constraint fk_chest_tshirt_tshirt foreign key (tshirt_id) references tshirt (id) on delete restrict on update restrict;
create index ix_chest_tshirt_tshirt on chest_tshirt (tshirt_id);


# --- !Downs

alter table chest_tshirt drop constraint if exists fk_chest_tshirt_chest;
drop index if exists ix_chest_tshirt_chest;

alter table chest_tshirt drop constraint if exists fk_chest_tshirt_tshirt;
drop index if exists ix_chest_tshirt_tshirt;

drop table if exists chest;

drop table if exists chest_tshirt;

drop table if exists place;

drop table if exists tshirt;


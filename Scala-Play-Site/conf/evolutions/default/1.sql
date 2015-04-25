# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table developer (
  id                        varchar(255) not null,
  developer                 varchar(255),
  constraint pk_developer primary key (id))
;

create table game (
  id                        varchar(255) not null,
  title                     varchar(255),
  developer                 varchar(255),
  year                      integer,
  newsupdate                varchar(255),
  constraint pk_game primary key (id))
;

create table title (
  id                        varchar(255) not null,
  title                     varchar(255),
  constraint pk_title primary key (id))
;

create sequence developer_seq;

create sequence game_seq;

create sequence title_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists developer;

drop table if exists game;

drop table if exists title;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists developer_seq;

drop sequence if exists game_seq;

drop sequence if exists title_seq;


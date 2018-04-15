# --- !Ups

SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO place (id,name, country, location, rating) VALUES (10,'Surowiec','Poland','Wroclaw, ul. Ruska',4);
INSERT INTO place (id,name, country, location, rating) VALUES (11,'Trolltunga','Norway','Natural park somethingsomething',7);
INSERT INTO place (id,name, country, location, rating) VALUES (12,'Park Szczytnicki','Poland','Wroclaw, near Teki',9999);

DROP SEQUENCE IF EXISTS place_seq;
CREATE SEQUENCE place_seq START WITH 10;

SET REFERENTIAL_INTEGRITY TRUE;
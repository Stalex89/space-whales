# --- !Ups

SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO place (id,name, country, location, rating) VALUES (10,'Surowiec','Poland','Wroclaw, ul. Ruska',4);
INSERT INTO place (id,name, country, location, rating) VALUES (11,'Trolltunga','Norway','Natural park somethingsomething',7);
INSERT INTO place (id,name, country, location, rating) VALUES (12,'Park Szczytnicki','Poland','Wroclaw, near Teki',9999);

INSERT INTO chest (id, name, price, picture_url, description) VALUES (1, 'Chest of Awesomness', 25.00, null, 'This is the most awesome chest ever!');

INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (1, 'Tshirt of Wisdom Whale', Rare, null, 'Gives a wearer an incredible wisdom of a whale');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (2, 'Tshirt of Epic Archwhale', Epic, null, 'Legends told this shirt was given as a gift by a great Archwhale...');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (2, 'Standard whale shirt', Common, null, 'Just a standard T-shirt with a whale, nothing special...');

INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,1);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,2);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,3);


DROP SEQUENCE IF EXISTS place_seq;
CREATE SEQUENCE place_seq START WITH 10;

SET REFERENTIAL_INTEGRITY TRUE;
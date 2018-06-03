# --- !Ups

SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO chest (id, name, price, picture_url, description) VALUES (1, 'Chest of Awesomness', 25.00, null, 'This is the most awesome chest ever!');

INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (1, 'Tshirt of Wisdom Whale', 2, null, 'Gives a wearer an incredible wisdom of a whale');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (2, 'Tshirt of Epic Archwhale', 3, null, 'Legends told this shirt was given as a gift by a great Archwhale...');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (3, 'Standard whale shirt', 0, null, 'Just a standard T-shirt with a whale, nothing special...');

INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,1);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,2);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,3);


DROP SEQUENCE IF EXISTS place_seq;
CREATE SEQUENCE place_seq START WITH 10;

SET REFERENTIAL_INTEGRITY TRUE;
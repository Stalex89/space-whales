# --- !Ups

SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO chest (id, name, price, product_id, picture_url, description) VALUES (1, 'Chest of Awesomeness', 25.00, 'QPDBR3J43XTPU', null, 'This is the most awesome chest ever!');

INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (1, 'Tshirt of Wisdom Whale', 2, 'https://i.imgur.com/iHxJQq2.jpg', 'Gives a wearer an incredible wisdom of a whale');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (2, 'Tshirt of Epic Archwhale', 3, 'https://i.imgur.com/QTXGJbS.png', 'Legends told this shirt was given as a gift by a great Archwhale...');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (3, 'Standard whale shirt', 0, 'https://i.imgur.com/MmKKpdC.jpg', 'Just a standard T-shirt with a whale, nothing special...');

INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,1);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,2);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,3);


DROP SEQUENCE IF EXISTS place_seq;
CREATE SEQUENCE place_seq START WITH 10;

SET REFERENTIAL_INTEGRITY TRUE;
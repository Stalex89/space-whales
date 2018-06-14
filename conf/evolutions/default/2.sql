# --- !Ups

SET REFERENTIAL_INTEGRITY FALSE;

INSERT INTO chest (id, name, price, product_id, picture_url, description) VALUES (1, 'Chest of Whalesomeness', 25.00, 'QPDBR3J43XTPU', 'https://thumbs.gfycat.com/FortunateThoseJumpingbean-max-1mb.gif', 'This is the most awesome chest ever!');
INSERT INTO chest (id, name, price, product_id, picture_url, description) VALUES (2, 'The KillaWhale Chest', 55.00, 'QPDBR3J43XTPU', 'https://media.giphy.com/media/qTYW0EfwoAbrG/giphy.gif', 'For those who do not want to be fooled around.');
INSERT INTO chest (id, name, price, product_id, picture_url, description) VALUES (3, 'Eat Whale Love', 70.00, 'QPDBR3J43XTPU', 'https://thumbs.gfycat.com/GorgeousVariableAffenpinscher-max-1mb.gif', 'Do it!');


INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (1, 'Whalesome tshirt (Red)', 1, 'https://i.imgur.com/MmKKpdC.jpg', 'Just be whalesome!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (2, 'Whalesome tshirt (White)', 1, 'https://i.imgur.com/Eod90Gj.jpg', 'Just be whalesome!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (3, 'Whalesome tshirt (Dark blue)', 1, 'https://i.imgur.com/rkmgARa.jpg', 'Just be whalesome!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (4, 'Whalesome tshirt (Black)', 1, 'https://i.imgur.com/GqksoqU.jpg', 'Just be whalesome!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (5, 'Whaler tshirt (White)', 0, 'https://i.imgur.com/ePtmmDT.jpg', 'From SW, for our loyal fans ^_^');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (6, 'Whaler tshirt (Red)', 0, 'https://i.imgur.com/RRvYpwK.jpg', 'From SW, for our loyal fans ^_^');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (7, 'Whaler tshirt (Dark blue)', 0, 'https://i.imgur.com/zx8d17X.jpg', 'From SW, for our loyal fans ^_^');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (8, 'Whaler tshirt (Black)', 0, 'https://i.imgur.com/3gk1zZ3.jpg', 'From SW, for our loyal fans ^_^');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (9, 'I Love SW tshirt (White)', 0, 'https://i.imgur.com/NwZ6VGn.jpg', 'We love you too!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (10, 'I Love SW tshirt (Red)', 0, 'https://i.imgur.com/23m4z0V.png', 'We love you too!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (11, 'I Love SW tshirt (Dark blue)', 0, 'https://i.imgur.com/LoF3sxS.jpg', 'We love you too!');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (12, 'I Love SW tshirt (Black)', 0, 'https://i.imgur.com/Ehbzeht.jpg', 'We love you too!');

INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (13, 'Killa Love (Grey)', 2, 'https://i.imgur.com/gkEhMeE.jpg', 'A bit of gentle feelings from our killer whale brothers <3');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (14, 'Psychowhaleic! (Purple)', 2, 'https://i.imgur.com/iHxJQq2.jpg', '~ For those crazy trips to space ~');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (15, 'Whalecop uniform (Grey)', 2, 'https://i.imgur.com/e1oJFMo.jpg', 'Alwhales stay true to yourself, even on duty.');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (16, 'Tshirt of the Enernal Wanderers (Black)', 2, 'https://i.imgur.com/VL24EwT.jpg', 'Born to be free, free as in whale');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (17, 'Tshirt of Wisdom Whale ', 3, 'https://i.imgur.com/MCLLxy0.jpg', 'Gives a wearer an incredible wisdom of a whale');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (18, 'At peace with whaleself', 3, 'https://i.imgur.com/F9sHW5M.jpg', 'Cause everyone should strive for it.');
INSERT INTO tshirt (id, name, rarity, picture_url, description) VALUES (19, '[OMG!!] Tshirt of Epic Archwhale', 4, 'https://i.imgur.com/QTXGJbS.png', 'Legends told this shirt was given as a gift by the great Archwhale...');


INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,1);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,4);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,6);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,5);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,11);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,10);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (1,14);

INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,3);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,8);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,12);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,13);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,15);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (2,16);

INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,2);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,7);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,9);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,17);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,18);
INSERT INTO chest_tshirt (chest_id, tshirt_id) VALUES (3,19);

SET REFERENTIAL_INTEGRITY TRUE;
INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CLIENT(id, name) VALUES (1, 'Felipe');
INSERT INTO CLIENT(id, name) VALUES (2, 'Luis');
INSERT INTO CLIENT(id, name) VALUES (3, 'Lucas');

INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (1, '2023-01-19', '2023-01-29', 1, 1);
INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (2, '2023-01-19', '2023-01-30', 2, 2);
INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (3, '2023-01-19', '2023-01-24', 3, 3);
INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (4, '2023-01-19', '2023-01-25', 4, 1);
INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (5, '2023-01-19', '2023-01-27', 5, 2);
INSERT INTO LOAN(id, initial_date, final_date, game_id, client_id) VALUES (6, '2023-01-19', '2023-01-28', 6, 3);
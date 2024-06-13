INSERT INTO "Category" ("category_name") VALUES ('Живопись');
INSERT INTO "Category" ("category_name") VALUES ('Скульптура');
INSERT INTO "Category" ("category_name") VALUES ('Фотография');

INSERT INTO "Owner" ("owner_name") VALUES ('Эрмитаж');
INSERT INTO "Owner" ("owner_name") VALUES ('Русский музей');
INSERT INTO "Owner" ("owner_name") VALUES ('Третьяковская галерея');

INSERT INTO "PieceOfArt" ("name", "category_id", "owner_id", "year", "price") VALUES ('Сон', 1, 1, 1932, 100000);
INSERT INTO "PieceOfArt" ("name", "category_id", "owner_id", "year", "price") VALUES ('Давид', 2, 2, 1504, 50000);
INSERT INTO "PieceOfArt" ("name", "category_id", "owner_id", "year", "price") VALUES ('Пассаж', 3, 3, 1903, 30000);
INSERT INTO "PieceOfArt" ("name", "category_id", "owner_id", "year", "price") VALUES ('Звездная ночь', 1, 3, 1889, 70000);
INSERT INTO "PieceOfArt" ("name", "category_id", "owner_id", "year", "price") VALUES ('Юпитер', 2, 1, 1001, 80000);

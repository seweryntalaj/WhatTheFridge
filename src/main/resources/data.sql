DROP TABLE IF EXISTS ingredient CASCADE;

CREATE TABLE ingredient (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS dish CASCADE;

CREATE TABLE dish (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sweetDish BOOLEAN NOT NULL,
    pictureLink TEXT,
    recipeLink TEXT
);

DROP TABLE IF EXISTS dish_ingredient CASCADE;

CREATE TABLE dish_ingredient (
    id INT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    fk_dish_id INT NOT NULL,
    fk_ingredient_id INT NOT NULL,
    CONSTRAINT dish_id_fk FOREIGN KEY (fk_dish_id) REFERENCES dish (id),
    CONSTRAINT ingredient_id_fk FOREIGN KEY (fk_ingredient_id) REFERENCES ingredient (id));

INSERT INTO ingredient (name) VALUES
    ('Apple'),
    ('Bacon'),
    ('Beef'),
    ('Berries'),
    ('Beetroot'),
    ('Butter'),
    ('Cabbage'),
    ('Carrot'),
    ('Celeriac'),
    ('Celery'),
    ('Cheese'),
    ('Chicken'),
    ('Chili'),
    ('Chocolate'),
    ('Cocoa'),
    ('Cream'),
    ('Cucumber'),
    ('Eggplant'),
    ('Eggs'),
    ('Fish'),
    ('Flour'),
    ('Garlic'),
    ('Ginger'),
    ('Lemon'),
    ('Lime'),
    ('Milk'),
    ('Oats'),
    ('Onion'),
    ('Orange'),
    ('Pasta'),
    ('Pear'),
    ('Pepper'),
    ('Pineapple'),
    ('Pork'),
    ('Potato'),
    ('Rice'),
    ('Shrimp'),
    ('Spinach'),
    ('Sugar'),
    ('Tomato'),
    ('Turkey'),
    ('Wine'),
    ('Zucchini');

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Scrambled eggs with bacon', false, 'https://brooklynfarmgirl.com/wp-content/uploads/2014/09/Scrambled-Eggs-With-Bacon-Featured-Image.jpg', 'https://brooklynfarmgirl.com/scrambled-eggs-with-bacon/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (1, 2), (1, 19), (1, 6), (1, 26);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pancakes', false, null, null);
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (2, 19), (2, 21), (2, 26);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pasta Napoli', false, null, null);
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (3, 22), (3, 28), (3, 30), (3, 40);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Apple', true, null, null);
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (4, 1);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pasta ragu', false, 'https://www.recipetineats.com/wp-content/uploads/2017/07/Beef-Ragu-11a.jpg', 'https://www.recipetineats.com/slow-cooked-shredded-beef-ragu-pasta/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (5, 3), (5, 8), (5, 9), (5, 22), (5, 28),
(5, 30), (5, 40), (5, 42);

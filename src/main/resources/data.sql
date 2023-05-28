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
    ('Apple'), ('Avocado'), ('Bacon'), ('Beans'), ('Beef'), ('Beer'), ('Beetroot'), ('Berries'), ('Broccoli'),
    ('Broth / Stock'), ('Brussels sprout'), ('Butter'), ('Cabbage'), ('Carrot'), ('Cauliflower'), ('Celeriac'),
    ('Celery'), ('Cheese'), ('Chicken'), ('Chili'), ('Chocolate'), ('Cocoa'), ('Corn'), ('Cream'), ('Cucumber'),
    ('Eggplant'), ('Eggs'), ('Fish'), ('Flour'), ('Garlic'), ('Ginger'), ('Green onions / Scallions'), ('Lemon'),
    ('Leek'), ('Lime'), ('Milk'), ('Mushrooms'), ('Oats'), ('Onion'), ('Orange'), ('Parmesan'), ('Parsley'),
    ('Parsnip'), ('Pasta'), ('Peanut butter'), ('Pear'), ('Peas'), ('Pepper'), ('Pickles'), ('Pineapple'), ('Pork'),
    ('Potato'), ('Puff pastry'), ('Rice'), ('Sausage'), ('Shrimp'), ('Spinach'), ('Sugar'), ('Tomato'), ('Tortilla'),
    ('Turkey'), ('Wine'), ('Yogurt'), ('Zucchini');

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Scrambled eggs with bacon', false,
    'https://brooklynfarmgirl.com/wp-content/uploads/2014/09/Scrambled-Eggs-With-Bacon-Featured-Image.jpg',
    'https://brooklynfarmgirl.com/scrambled-eggs-with-bacon/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (1, 3), (1, 12), (1, 26), (1, 36);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pancakes', true,
    'https://www.allrecipes.com/thmb/tOfkDV1xc28JMmITPQlQwy3FNWs=/1500x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/21014-Good-old-Fashioned-Pancakes-mfs_001-1fa26bcdedc345f182537d95b6cf92d8.jpg',
    'https://www.allrecipes.com/recipe/21014/good-old-fashioned-pancakes/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (2, 12), (2, 27), (2, 29), (2, 36), (2, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pasta Napoli', false,
    'https://sanremo.imgix.net/2019/05/Easy-tomato-pasta-4-1498x1000.jpg',
    'https://sanremo.com.au/recipes/quick-napoli-spaghetti/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (3, 30), (3, 39), (3, 41), (3, 44), (3, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Apple crumble', true,
    'https://northeasteatshome.files.wordpress.com/2021/01/img_1805.jpg',
    'https://northeasteats.home.blog/2021/02/07/old-school-apple-crumble-recipe/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (4, 1), (4, 12), (4, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pasta ragu', false,
    'https://www.recipetineats.com/wp-content/uploads/2017/07/Beef-Ragu-11a.jpg',
    'https://www.recipetineats.com/slow-cooked-shredded-beef-ragu-pasta/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (5, 4), (5, 10), (5, 14), (5, 16), (5, 30), (5, 39),
    (5, 41), (5, 42), (5, 59), (5, 62);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Mushroom risotto', false,
    'https://cdn.loveandlemons.com/wp-content/uploads/2023/01/mushroom-risotto-recipe-580x782.jpg',
    'https://www.loveandlemons.com/mushroom-risotto/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (6, 10), (6, 30), (6, 36), (6, 38), (6, 40), (6, 41),
    (6, 54), (6, 62);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Guacamole', false,
    'https://www.budgetbytes.com/wp-content/uploads/2022/04/Guacamole-close-500x500.jpg',
    'https://www.budgetbytes.com/guacamole/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (7, 2), (7, 20), (7, 35), (7, 39), (7, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Beer batter fish', false,
    'https://iwashyoudry.com/wp-content/uploads/2020/04/Beer-Battered-Fried-Fish-3.jpg',
    'https://iwashyoudry.com/crispy-beer-batter-fish-recipe/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (8, 6), (8, 27), (8, 28), (8, 29);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Ukrainian borscht', false,
    'https://ifoodreal.com/wp-content/uploads/2020/02/ukrainian-borscht-recipe-16.jpg',
    'https://ifoodreal.com/ukrainian-borscht/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (9, 7), (9, 10), (9, 13), (9, 14), (9, 30), (9, 39),
    (9, 52);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Lemon berry yogurt cake', true,
    'https://sallysbakingaddiction.com/wp-content/uploads/2020/01/lemon-yogurt-cake.jpg',
    'https://sallysbakingaddiction.com/lemon-berry-yogurt-cake/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (10, 8), (10, 12), (10, 27), (10, 29), (10, 33),
    (10, 63);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Caramelized broccoli with garlic', false,
    'https://www.foodandwine.com/thmb/u28FmCq0YOdOgO85VPtpeaz-4kY=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Caramelized-Broccoli-with-Garlic-FT-RECIPE0822-2000-926848df43b3456ba0d4aa6dfb6766e9.jpg',
    'https://www.foodandwine.com/recipes/caramelized-broccoli-garlic');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (11, 9), (11, 30), (11, 33);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Roasted brussels sprouts', false,
    'https://www.simplyrecipes.com/thmb/S2lROu5Wk1jstQ1RjRXn3JOk0aE=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/Simply-Recipes-Roasted-Brussels-Sprouts-LEAD-07-a720b7a0225343519597cdcc9c2c5bf4.jpg',
    'https://www.simplyrecipes.com/recipes/roasted_brussels_sprouts/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (12, 11), (12, 30), (12, 33), (12, 41);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Golabki polish stuffed cabbage rolls', false,
    'https://www.polonist.com/wp-content/uploads/2020/10/golabki-stuffed-cabbage-rolls-tomato-600x800-1.jpg',
    'https://www.polonist.com/golabki-polish-stuffed-cabbage-rolls/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (13, 10), (13, 13), (13, 30), (13, 39), (13, 51),
    (13, 54), (13, 58), (13, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Aloo gobi Indian cauliflower with potatoes', false,
    'https://www.teaforturmeric.com/wp-content/uploads/2022/01/Aloo-Gobi-Cauliflower-Potato-Curry-08-728x1092.jpg',
    'https://www.teaforturmeric.com/aloo-gobi/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (14, 15), (14, 20), (14, 30), (14, 31), (14, 39),
    (14, 51), (14, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Simple celery soup', false,
    'https://www.feastingathome.com/wp-content/uploads/2018/10/simple-celery-soup-103.jpg',
        'https://www.feastingathome.com/celery-soup/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (15, 10), (15, 17), (15, 24), (15, 30), (15, 39),
    (15, 42), (15, 52);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Celeriac steak', false,
    'https://www.thevegspace.co.uk/wp-content/uploads/2022/05/celeriac-steak-3-1161x1536.jpg',
    'https://www.thevegspace.co.uk/celeriac-steak/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (16, 16), (16, 30);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Mac and cheese', false,
    'https://i2.wp.com/bakingmischief.com/wp-content/uploads/2016/08/mac-and-cheese-for-one-image.jpg',
    'https://bakingmischief.com/quick-mac-and-cheese-for-one/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (17, 12), (17, 18), (17, 29), (17, 36), (17, 44);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Orange chicken', false,
    'https://insanelygoodrecipes.com/wp-content/uploads/2022/12/Panda_Express_Orange_Chicken_With_Sliced_Leeks-1024x1024.webp',
    'https://insanelygoodrecipes.com/panda-express-orange-chicken/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (18, 19), (18, 27), (18, 29), (18, 30), (18, 31),
    (18, 32), (18, 39), (18, 40), (18, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Chocolate mousse', true,
    'https://www.recipetineats.com/wp-content/uploads/2018/09/Chocolate-Mousse_9.jpg',
    'https://www.recipetineats.com/chocolate-mousse/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (19, 12), (19, 21), (19, 24), (19, 27), (19, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Buttered corn', false,
    'https://www.knowyourproduce.com/wp-content/uploads/2018/11/buttered-corn-4.jpg',
    'https://www.knowyourproduce.com/buttered-corn/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (20, 12), (20, 23), (20, 36);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Asian cucumber salad', false,
    'https://www.feastingathome.com/wp-content/uploads/2021/06/Asian-Cucumber-Salad-16.jpg',
    'https://www.feastingathome.com/asian-cucumber-salad/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (21, 25), (21, 30), (21, 31), (21, 32);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Moussaka', false,
    'https://www.mygreekdish.com/wp-content/uploads/2013/05/Moussaka-recipe-Traditional-Greek-Moussaka-with-Eggplants-750x497.jpg',
    'https://www.mygreekdish.com/recipe/mousakas/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (22, 5), (22, 12), (22, 26), (22, 27), (22, 29),
    (22, 30), (22, 36), (22, 39), (22, 41), (22, 52), (22, 58), (22, 59), (22, 62);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Lemon bars', true,
    'https://www.gimmesomeoven.com/wp-content/uploads/2019/03/Easy-Lemon-Bars-Recipe-7-1.jpg',
    'https://www.gimmesomeoven.com/lemon-bars/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (23, 12), (23, 27), (23, 29), (23, 33), (23, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Sauteed leeks with parmesan', false,
    'https://www.thecookierookie.com/wp-content/uploads/2019/10/sauteed-leeks-parmesan-recipe-1-of-5-735x1103.jpg',
    'https://www.thecookierookie.com/sauteed-leeks-with-parmesan/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (24, 10), (24, 12), (24, 34), (24, 41), (24, 62);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Oatmeal with milk', true,
    'https://www.teaforturmeric.com/wp-content/uploads/2022/04/Oatmeal-with-milk-05-728x1092.jpg',
    'https://www.teaforturmeric.com/oatmeal-with-milk/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (25, 35), (25, 38);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Roasted parsnips', false,
    'https://www.cubesnjuliennes.com/wp-content/uploads/2021/02/Roasted-Parsnips-1.jpg',
    'https://www.cubesnjuliennes.com/roasted-parsnips-recipe/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (26, 42), (26, 43);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Peanut butter cookies', true,
    'https://sallysbakingaddiction.com/wp-content/uploads/2022/04/soft-and-thick-peanut-butter-cookies-2.jpg',
    'https://sallysbakingaddiction.com/soft-peanut-butter-cookie-recipe/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (27, 12), (27, 27), (27, 29), (27, 45), (27, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Polish beans and sausage', false,
    'https://i0.wp.com/www.polishyourkitchen.com/wp-content/uploads/2017/05/DSC_9184websm-3.jpg',
    'https://www.polishyourkitchen.com/polish-beans-and-sausage-fasolka-po-bretonsku/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (28, 3), (28, 4), (28, 39), (28, 55), (28, 58),
    (28, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pear custard', true,
    'https://www.dinneratthezoo.com/wp-content/uploads/2015/04/pear-custard-pie-new-680x1020.jpg',
    'https://www.dinneratthezoo.com/pear-custard/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (29, 12), (29, 27), (29, 29), (29, 36), (29, 46),
    (29, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Stuffed peppers', false,
    'https://www.cookingclassy.com/wp-content/uploads/2019/05/stuffed-peppers-9-768x1152.jpg',
    'https://www.cookingclassy.com/stuffed-peppers/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (30, 5), (30, 18), (30, 30), (30, 39), (30, 42),
    (30, 48), (30, 54), (30, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pickle salsa', false,
    'https://cadryskitchen.com/wp-content/uploads/2021/07/pickle-salsa-polkadot-bowl.jpg',
    'https://cadryskitchen.com/pickle-salsa/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (31, 20), (31, 30), (31, 35), (31, 39), (31, 47),
    (31, 49);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pineapple chicken', false,
    'https://www.dinneratthezoo.com/wp-content/uploads/2018/04/pineapple-chicken-2.jpg',
    'https://www.dinneratthezoo.com/pineapple-chicken/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (32, 10), (32, 19), (32, 30), (32, 31), (32, 32),
    (32, 48), (32, 50), (32, 58);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Leftover turkey mashed potato pie', false,
    'https://thetortillachannel.com/wp-content/uploads/2020/05/Breakfast-wrap-3.jpg',
    'https://thetortillachannel.com/breakfast-wrap/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (33, 2), (33, 3), (33, 27), (33, 37), (33, 47),
    (33, 59);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Garlic pork chops in creamy mushroom sauce', false,
    'https://www.eatwell101.com/wp-content/uploads/2019/02/Mushroom-pork-chops-recipe.jpg',
    'https://www.eatwell101.com/garlic-pork-chops-in-creamy-mushroom-sauce');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (34, 10), (34, 12), (34, 24), (34, 37), (34, 42),
    (34, 51);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Puff pastry quiche', false,
    'https://www.mommafitlyndsey.com/wp-content/uploads/2020/10/Puff-Pastry-Quiche-3.jpg',
    'https://www.mommafitlyndsey.com/puff-pastry-quiche/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (35, 3), (35, 18), (35, 27), (35, 36), (35, 39),
(35, 53), (35, 57);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Mediterranean-style garlic shrimp recipe with bell peppers',
    false,
    'https://www.themediterraneandish.com/wp-content/uploads/2017/04/Easy-Shrimp-Recipe-The-Mediterranean-Dish-4.jpg',
    'https://www.themediterraneandish.com/easy-shrimp-recipe/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (36, 10), (36, 12), (36, 29), (36, 30), (36, 33),
    (36, 39), (36, 42), (36, 56), (36, 58), (36, 59), (36, 62);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Pasta with spinach', false,
    'https://whereismyspoon.co/wp-content/uploads/2017/04/spaghetti-spinach-cheese.jpg',
    'https://whereismyspoon.co/spaghetti-with-spinach/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (37, 24), (37, 30), (37, 33), (37, 36), (37, 41),
    (37, 44), (37, 57);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Homemade flour tortillas', false,
    'https://thecafesucrefarine.com/wp-content/uploads/Homemade-Flour-Tortillas-1.jpg',
    'https://thecafesucrefarine.com/best-ever-homemade-flour-tortillas/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (38, 29);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Breakfast wrap', false,
    'https://thetortillachannel.com/wp-content/uploads/2020/05/Breakfast-wrap-3.jpg', 'https://thetortillachannel.com/breakfast-wrap/');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (39, 2), (39, 3), (39, 27), (39, 37), (39, 48),
    (39, 60);

INSERT INTO dish (name, sweetdish, picturelink, recipelink) VALUES ('Baked stuffed zucchini', false,
    'https://www.thespruceeats.com/thmb/TdZtEh56Jj1uegQxfglbOXvW4fk=/750x0/filters:no_upscale():max_bytes(150000):strip_icc():format(webp)/baked-stuffed-zucchini-3062392-hero-7e7408e0b07745f68403cb848028e0f7.jpg',
    'https://www.thespruceeats.com/baked-stuffed-zucchini-3062392');
INSERT INTO dish_ingredient (fk_dish_id, fk_ingredient_id) VALUES (40, 18), (40, 27), (40, 30), (40, 39), (40, 41),
    (40, 48), (40, 55), (40, 59), (40, 64);

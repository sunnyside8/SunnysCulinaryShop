#roles
INSERT INTO roles (id, role)
VALUES (1, 'ADMIN');
INSERT INTO roles (id, role)
VALUES (2, 'MODERATOR');
INSERT INTO roles (id, role)
VALUES (3, 'USER');


#addresses
INSERT INTO addresses (id, address ,area_city, town)
VALUES (1,'yl.Graf Ignatiev bl.58 et.4 ap.84' , 'Yambol',  'Yambol');
INSERT INTO addresses (id, address ,area_city, town)
VALUES (2,'yl.Sini Kamuni bl.57 et.1 ap.4' , 'Sliven',  'Sliven');
INSERT INTO addresses (id, address,area_city, town)
VALUES (3,'yl.Studenski bl.1 et.1 ap.4' , 'Sofia',  'Sofia');

#users
INSERT INTO users (id, email, full_name, gender, password, username, address_id)
VALUES (1, 'stanislava@gmail.com', 'Stanislava Oncheva','Female', '5c81772c076638d0427b78498a47ec160fd411806ac9ea6927233e534a74b68a3d0008a2a4012b0f', 'sunny', 1);

INSERT INTO users (id, email, full_name,gender, password, username, address_id)
VALUES (2,  'svetlin@gmail.com','Svetlin Kolev','Male' ,'5c81772c076638d0427b78498a47ec160fd411806ac9ea6927233e534a74b68a3d0008a2a4012b0f', 'perro',2);

INSERT INTO users (id, email, full_name, gender, password, username,address_id)
VALUES (3, 'kristina@gmail.com','Kristina Oncheva','Female', '5c81772c076638d0427b78498a47ec160fd411806ac9ea6927233e534a74b68a3d0008a2a4012b0f', 'kristinka',3);

INSERT INTO users_roles(user_id,roles_id)
VALUES (1,1);

INSERT INTO users_roles(user_id,roles_id)
VALUES (1,3);

INSERT INTO users_roles(user_id,roles_id)
VALUES (2,3);

INSERT INTO users_roles(user_id,roles_id)
VALUES (3,3);

#ingredients
INSERT INTO ingredients (id, is_organic, name)
VALUES (1, true, 'Rice');

INSERT INTO ingredients (id, is_organic, name)
VALUES (2, true, 'Tofu');

INSERT INTO ingredients (id, is_organic, name)
VALUES (3, false, 'TVP');

INSERT INTO ingredients (id, is_organic, name)
VALUES (4, true, 'Cashew');

INSERT INTO ingredients (id, is_organic, name)
VALUES (5, false, 'Coconut Milk');

INSERT INTO ingredients (id, is_organic, name)
VALUES (6, false, 'Curry');

INSERT INTO ingredients (id, is_organic, name)
VALUES (7, false, 'Chickpeace');

INSERT INTO ingredients (id, is_organic, name)
VALUES (8, false, 'Beyond meat');

INSERT INTO ingredients (id, is_organic, name)
VALUES (9, false, 'Fresh Veggies');

INSERT INTO ingredients (id, is_organic, name)
VALUES (10, false, 'Fruit');

INSERT INTO ingredients (id, is_organic, name)
VALUES (11, false, 'Dough');

INSERT INTO ingredients (id, is_organic, name)
VALUES (12, true, 'Tomato Souse');

#allergens
INSERT INTO allergens (id, allergen, picture)
VALUES (1, 'Gluten', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Gluten_wyjqcb.jpg');

INSERT INTO allergens (id, allergen, picture)
VALUES (2, 'Peanuts', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Peanuts_gnxajv.jpg');

INSERT INTO allergens (id, allergen, picture)
VALUES (3, 'Soybeans', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Soya_fwu8qu.jpg');

INSERT INTO allergens (id, allergen, picture)
VALUES (4, 'Nuts', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Nuts_lotj5e.jpg');

INSERT INTO allergens (id, allergen, picture)
VALUES (5, 'Mustard', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Mustard_mmebaa.jpg');

INSERT INTO allergens (id, allergen, picture)
VALUES (6, 'Sesame', 'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658575330/Sesame_hcvhzb.jpg');

#meals
INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (1, 'Main', 'Curry with TVP', 8.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658343586/Beef-TVP_hqmmc2.jpg',
        'Ditch the meat and pack lots of veggies into a range of vibrant, plant-based curry dishes from fragrant and chunky chickpea dhals to spicy potato one-pots.');

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (2, 'Starter', 'Hummus', 5.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658343586/Hummus_03_jy1qdl.jpg',
        '
Hummus is one of our favorite dips - not only does it taste great, but it''s one of a select few nutrient-dense dips that''s good for you, too. ');

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (3, 'Main', 'Burger', 9.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1658343586/download_2_irf5no.jpg',
'This flavourful vegan sweet potato burger recipe is packed with delicious spices and is ready to eat in just 30 minutes! Topped with avocado, vegan mayo, red onion, and spicy Kimchi, they are the perfect combination of savoury and spicy.');

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (4, 'Dessert', 'Cake', 5.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1659553482/134705_iipxid.jpg',
'This indulgent, fudgy vegan cake is topped with a rich frosting – you''d never guess that it''s gluten-free and made without dairy, eggs, wheat or nuts');

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (5, 'Starter', 'Colorful Salad', 6.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1660370886/Vegan-Salad-Meal-Prep-Idea-1-1_aakxjs.jpg',
        'Meal prepping this vegan salad is super easy and perfect to grab and go for a busy day at school or work.All you need to do to make this vegan salad is cook the soy curls, and layer the salad in, mix the pico de gallo and serve with dressing on the side. ')

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (6, 'Main', 'Pizza', 9.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1660371132/vegan_pizza_26503_16x9_gipwuf.jpg',
    'Homemade pizza is a great way to get the kids involved with dinner. These two vegan toppings are a good starting point, but feel free to experiment with your own.')

INSERT INTO meals (id, meal_type,name,price,photo,description)
VALUES (7, 'Dessert', 'Coconut Milk Panna Cotta', 5.99,'https://res.cloudinary.com/dksxrlrq3/image/upload/v1660371402/Coconut-milk-Panna-cotta-with-blueberries-and-thyme-vegan-desserts-scaled_cr3upk.jpg',
    'We know vegan desserts can have a reputation for being less than stellar. But, after perfecting dishes like our Vegan Chocolate Silk Pie, Apple Pear Galette, and Dairy-Free Pumpkin Cheesecake, we have changed our tune to appreciate the goodness of plant-based desserts. Our latest creation is a creamy vegan coconut milk panna cotta. It features a special flavor combination that elevates a dessert that is already delicious on its own.')

#meals_allergens
INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (1, 5);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (2, 4);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (2, 5);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (3, 1);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (3, 3);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (3, 5);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (4, 4);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (5, 5);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (5, 6);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (6, 1);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (6, 5);

INSERT INTO meals_allergens (meal_id,allergens_id)
VALUES (7, 4);

#meals_ingredients
INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (1, 3);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (1, 5);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (1, 6);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (2, 7);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (3, 8);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (3, 9);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (4, 4);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (4, 5);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (4, 10);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (5, 3);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (5, 9);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (6, 10);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (6, 11);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (6, 8);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (7, 4);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (7, 5);

INSERT INTO meals_ingredients (meal_id,ingredients_id)
VALUES (7, 1);
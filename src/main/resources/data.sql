insert into restaurant ( name , location) values
('Chyllingly', 'New Jersey'),
('Chyllingly', 'New York'),
('Chyllingly', 'Philadelphia');

insert into menu (title, description , restaurant_id) values
('Breakfast Menu', 'Good Morning, Take a chill pill',1),
('Dinner Menu', 'Look at our refreshing items',1),
('Breakfast Menu', 'Happy Breakfast',2),
('Dinner Menu', 'Time for an awesome dinner',2);

insert into menusection (title, description , menu_id) values
('Cakes', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit',1),
('Sandwiches', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit',1),
('Ice Cream', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit',1),
('Sundaes', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit',1);



insert into menuitem (title, description , price , isAvailable , menu_section_id) values
('Berry Vanilla Chiffon', '3 layers of vanilla chiffon cake, filled with vanilla soft cream and sliced strawberries', 3999 , true , 1),
('Chocoholic Chiffon', '3 Layers of Chocolate Chiffon Filled with Chocolate soft cream, Chocolate Ganache, and Crisp Chocolate', 3799 , true , 1),
('Rainbow Cake', '6 Layer Cake with 6 Different Colored Sponge, Filled with Cream Cheese and Soft Cream', 3899 , true , 1),
('Tiramisu', '2 Layer Coffee Cake, Mascarpone Cheese Filling', 4299 , true , 1),
('Egg Salad Sandwich', 'Milk bread, egg salad(boiled egg, mayonnaise, Dijon mustard, pepper, cucumber, basil), cucumber', 599 , true , 2),
('Turkey Avocado Sandwich', 'Multigrain loaf, avocado, Swiss cheese, arugula, pine nuts, balsamic Dijon mayonnaise (mayonnaise, Dijon mustard, balsamic glaze)', 659 , true , 2),
('Provence Chicken Pesto', 'Grilled Chicken, Parmesan, Mozzarella, Roasted Bell Pepper, Pesto, Basil,', 799 , true , 2),
('Chicken Caesar ', 'Grilled Chicken, Mixed Green, Tomato, Grain Mustard Mayonnaise, Black Pepper', 725 , true , 2),
('OREO Cold Brew', 'Made from real cold brew concentrate, this cold brew flavored ice cream is irresistibly smooth and rich. ', 599 , true , 3),
('Chocolate Chip', 'Chill out. A cool hit of mint flavored ice cream with the joy of chocolate chips throughout.', 599 , true , 3),
('Cherries Jubilee', 'You are invited to a jubilee! Other guests include cherry flavored ice cream, cherry halves, and a hint of rum flavor.', 699 , true , 3),
('Peanut Butter n Chocolate ', 'There is no better gift to your taste buds than chocolate ice cream tied with a chunky peanut butter ribbon.', 625 , true , 3),
('Iced Pumpkin Spice Latte', 'Spicy and chilled , nothing better than this ', 599 , true , 4),
('Chocolate Chip Milkshake', 'we combine our Chocolate Chip ice cream, made from our Vanilla ice cream loaded with bittersweet chocolate chips.', 659 , true , 4),
('Vanilla Milkshake', 'You will delight in this delicious shake made with our famous Vanilla ice cream made from fresh cream and real vanilla.', 719 , true , 4),
('Very Berry Strawberry Milkshake', 'A shake with Strawberry ice cream that’s chockfull of strawberries? This dessert is exponentially exquisite.', 725 , true , 4);






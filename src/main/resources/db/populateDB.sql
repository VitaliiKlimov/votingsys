DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM menus;
DELETE FROM restaurants;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', 'password'),
       ('Admin', 'admin@gmail.com', 'admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);
INSERT INTO restaurants (id, name)
VALUES (100000, 'Лесная заимка'),
       (100001, 'Океан');

INSERT INTO VOTES (date_time, restaurant_id, user_id)
VALUES ('2020-01-30 10:00:00', 100000, 100000),
       ('2020-01-31 0:00:00', 100001, 100000);

INSERT INTO menus (id, rest_id, date)
VALUES (100000, 100000, NOW()),
       (100001, 100001, NOW());

INSERT INTO dishes (menu_id, name, price)
VALUES (100000, 'Борщ', 1500),
       (100000, 'Картофельное пюре', 1000),
       (100000, 'Компот', 500),
       (100001, 'Лагман', 1000),
       (100001, 'Плов', 700),
       (100001, 'Чай', 400);
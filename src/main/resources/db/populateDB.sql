DELETE FROM user_roles;
DELETE FROM votes;
DELETE FROM users;
DELETE FROM dishes;
DELETE FROM restaurants;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO user_roles (role, user_id)
VALUES ('USER', 100000),
       ('ADMIN', 100001),
       ('USER', 100001);
INSERT INTO restaurants (name)
VALUES ('Лесная заимка'),
       ('Океан');

INSERT INTO VOTES (date_time, restaurant_id, user_id)
VALUES ('2020-01-30 10:00:00', 100002, 100000),
       ('2020-11-30 23:00:00', 100003, 100000);

INSERT INTO dishes (restaurant_id, date, description, price)
VALUES (100002, NOW(), 'Борщ', 1500),
       (100002, NOW(), 'Картофельное пюре', 1000),
       (100002, NOW(), 'Компот', 500),
       (100003, NOW(), 'Лагман', 1000),
       (100003, '2020-10-28', 'Плов', 700),
       (100003, '2020-10-28', 'Чай', 400);
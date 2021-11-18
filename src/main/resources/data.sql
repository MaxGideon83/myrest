INSERT INTO user (first_name, last_name, middle_name) VALUES ('Пётр', 'Петров', 'Петрович');

INSERT INTO user (first_name, last_name, middle_name) VALUES ('Иван', 'Иванов', 'Иванович');

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active)
VALUES ('РиК', 'Рога и копыта', '100032652', '236547','Москва, Красная Площадь, мавзолей','8-999-999-99-99','true');

INSERT INTO office (name, address, phone, is_active, org_id)
VALUES ('Центральный','Мавзолей, кабинет 666','8-999-999-99-98','true','1');
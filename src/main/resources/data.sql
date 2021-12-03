INSERT INTO countries (CITIZENSHIP_CODE, CITIZENSHIP_NAME, version)
VALUES ('643','Российская Федерация','0');

INSERT INTO countries (CITIZENSHIP_CODE, CITIZENSHIP_NAME, version)
VALUES ('398','Казахстан','0');

INSERT INTO documents_type (DOC_CODE, DOC_NAME,version)
VALUES ('21', 'Паспорт РФ','0');

INSERT INTO documents_type (DOC_CODE, DOC_NAME,version)
VALUES ('91', 'Водительское удостоверение РФ','0');

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active, version)
VALUES ('РиК', 'Рога и копыта', '100032652', '236547','Москва, Красная Площадь, мавзолей','8-999-999-99-99','true','0');

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active,version)
VALUES ('РиК', 'Рис и Кукуруза', '103437658', '335541','Питер, Арка, дом','8-899-899-89-89','true','0');

INSERT INTO office (name, address, phone, is_active, org_id, version)
VALUES ('Центральный','Мавзолей, кабинет 666','8-999-999-99-98','true','1','0');

INSERT INTO office (name, address, phone, is_active, org_id, version)
VALUES ('Крайний','Дом, кабинет 7','8-999-999-99-97','true','1','0');

INSERT INTO office (name, address, phone, is_active, org_id, version)
VALUES ('Большой','Вокзал, кабинет 2','8-999-999-99-96','true','2','0');

INSERT INTO office (name, address, phone, is_active, org_id,version)
VALUES ('Левый','Остановка, кабинет 1','8-999-999-99-95','true','2','0');

INSERT INTO user (first_name, second_name, middle_name, phone, position, countries_id, office_id, is_identified, version)
VALUES ('Пётр', 'Петров', 'Петрович','8-456-345-67-89','manager','1','1', 'true', '0');

INSERT INTO user (first_name, second_name, middle_name, phone, position, countries_id, office_id, is_identified, version)
VALUES ('Иван', 'Иванов', 'Иванович','8-333-375-61-59','manager','2','1', 'true', '0');

INSERT INTO documents ( DOC_DATE, DOC_NUMBER, DOC_TYPE, USER_ID, version)
VALUES ('12.12.86', '1212123456', '1','1','0');

INSERT INTO documents ( DOC_DATE, DOC_NUMBER, DOC_TYPE, USER_ID, version)
VALUES ('21.10.83', '3245765314', '2','2','0');

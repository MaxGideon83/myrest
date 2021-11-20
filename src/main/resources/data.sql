INSERT INTO countries (CITIZENSHIP_CODE, CITIZENSHIP_NAME)
VALUES ('643','Российская Федерация');

INSERT INTO documents_type (DOC_CODE, DOC_NAME)
VALUES ('21', 'Паспорт РФ');

INSERT INTO organization (name, full_name, inn, kpp, address, phone, is_active)
VALUES ('РиК', 'Рога и копыта', '100032652', '236547','Москва, Красная Площадь, мавзолей','8-999-999-99-99','true');

INSERT INTO office (name, address, phone, is_active, org_id)
VALUES ('Центральный','Мавзолей, кабинет 666','8-999-999-99-98','true','1');

INSERT INTO user (first_name, last_name, middle_name, phone, position, countries_id, office_id, is_identified)
VALUES ('Пётр', 'Петров', 'Петрович','8-456-345-67-89','manager','1','1', 'true');

INSERT INTO user (first_name, last_name, middle_name, phone, position, countries_id, office_id, is_identified)
VALUES ('Иван', 'Иванов', 'Иванович','8-333-375-61-59','manager','1','1', 'true');

INSERT INTO documents ( DOC_DATE, DOC_NUMBER, DOC_TYPE, USER_ID)
VALUES ('12.12.86', '1212123456', '1','1');

INSERT INTO documents ( DOC_DATE, DOC_NUMBER, DOC_TYPE, USER_ID)
VALUES ('21.10.83', '3245765314', '1','2');

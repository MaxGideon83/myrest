CREATE TABLE IF NOT EXISTS documents_type (
  id int NOT NULL AUTO_INCREMENT,
  doc_name varchar(30) NOT NULL,
  doc_code varchar(15) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS countries (
  id int NOT NULL AUTO_INCREMENT,
  citizenship_name varchar(30),
  citizenship_code varchar(15),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS organization (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(30) NOT NULL,
  full_name varchar(30) NOT NULL,
  inn varchar(30) NOT NULL,
  kpp varchar(30) NOT NULL,
  address varchar(60) NOT NULL,
  phone varchar(30),
  is_active varchar(6),
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS office (
  id int NOT NULL AUTO_INCREMENT,
  name varchar(30),
  address varchar(60),
  phone varchar(30),
  is_active varchar(6),
  org_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (org_id) REFERENCES organization(id)
);

CREATE TABLE IF NOT EXISTS user (
  id int NOT NULL AUTO_INCREMENT,
  first_name varchar(30),
  second_name varchar(30),
  middle_name varchar(30),
  position varchar(30),
  phone varchar(30),
  is_identified varchar(6),
  countries_id int,
  office_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (countries_id) REFERENCES countries(id),
  FOREIGN KEY (office_id) REFERENCES office(id)
);

CREATE TABLE IF NOT EXISTS documents (
  id int NOT NULL AUTO_INCREMENT,
  doc_number varchar(30),
  doc_date varchar(15),
  doc_type int,
  user_id int,
  PRIMARY KEY (id),
  FOREIGN KEY (doc_type) REFERENCES documents_type(id),
  FOREIGN KEY (user_id) REFERENCES user(id)
);
CREATE INDEX IX_OFFICE_ORGANIZATION_Id ON Office (org_id);
CREATE INDEX IX_USER_COUNTRIES_Id ON User (countries_id);
CREATE INDEX IX_USER_OFFICE_Id ON User (office_id);
CREATE INDEX IX_DOCUMENTS_DOCUMENTS_TYPE_Id ON Documents (doc_type);
CREATE INDEX IX_DOCUMENTS_USER ON Documents (user_id);




CREATE TABLE Artists
(
    a_num INTEGER CHECK (a_num > 0) NOT NULL,
    a_surname VARCHAR(100) NOT NULL,
    a_name VARCHAR(100) NOT NULL,
    a_patronymic VARCHAR(100) NOT NULL,
    a_date_of_birth DATE CHECK (a_date_of_birth > '1900-01-01') NOT NULL,
    speciality VARCHAR(100) NOT NULL,
    a_contact_info VARCHAR(40),
    PRIMARY KEY (a_num),
    UNIQUE (a_contact_info)
);
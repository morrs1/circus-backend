DROP TABLE IF EXISTS animals_trainings;
DROP TABLE IF EXISTS artists_performances;
DROP TABLE IF EXISTS trainings;
DROP TABLE IF EXISTS tickets;
DROP TABLE IF EXISTS tickets_sale;
DROP TABLE IF EXISTS intervals;
DROP TABLE IF EXISTS animals;
DROP TABLE IF EXISTS performances;
DROP TABLE IF EXISTS artists;
DROP TABLE IF EXISTS viewers;

CREATE TABLE artists
(
    artist_num     INTEGER CHECK (artist_num > 0),
    a_surname      VARCHAR(100)                             NOT NULL,
    a_name         VARCHAR(100)                             NOT NULL,
    a_patronymic   VARCHAR(100)                             NOT NULL,
    a_birth_date   DATE CHECK (a_birth_date > '1900-01-01') NOT NULL,
    speciality     VARCHAR(100)                             NOT NULL,
    a_contact_info VARCHAR(40),
    PRIMARY KEY (artist_num),
    UNIQUE (a_contact_info)
);

CREATE TABLE animals
(
    animal_num    INTEGER CHECK (animal_num > 0),
    species       VARCHAR(100)                              NOT NULL,
    nickname      VARCHAR(100)                              NOT NULL,
    date_of_birth DATE CHECK (date_of_birth > '1900-01-01') NOT NULL,
    gender        VARCHAR(10)                               NOT NULL,
    artist_num    INTEGER,
    PRIMARY KEY (animal_num),
    FOREIGN KEY (artist_num) REFERENCES artists (artist_num)
);

CREATE TABLE performances
(
    per_code INTEGER CHECK ( per_code > 0 ),
    name     VARCHAR(255)                       NOT NULL,
    date     DATE CHECK ( date > '2000-01-01' ) NOT NULL,
    time     TIME                               NOT NULL,
    PRIMARY KEY (per_code)
);

CREATE TABLE artists_performances
(
    num_record SERIAL,
    artist_num INTEGER,
    per_code   INTEGER,
    PRIMARY KEY (num_record),
    FOREIGN KEY (artist_num) REFERENCES artists (artist_num),
    FOREIGN KEY (per_code) REFERENCES performances (per_code),
    UNIQUE (artist_num, per_code)
);

CREATE TABLE viewers
(
    num_viewer     INTEGER CHECK ( num_viewer > 0 ),
    v_contact_info VARCHAR(40)                              NOT NULL,
    v_surname      VARCHAR(100)                             NOT NULL,
    v_name         VARCHAR(100)                             NOT NULL,
    v_patronymic   VARCHAR(100)                             NOT NULL,
    v_birth_date   DATE CHECK (v_birth_date > '1900-01-01') NOT NULL,
    PRIMARY KEY (num_viewer),
    UNIQUE (v_contact_info)
);


CREATE TABLE tickets_sale
(
    num_sale      INTEGER CHECK ( num_sale > 0 ),
    purchase_date DATE CHECK ( purchase_date > '2000-01-01' ) NOT NULL,
    payment_type  VARCHAR(100)                                NOT NULL,
    viewer_num    INTEGER,
    PRIMARY KEY (num_sale),
    FOREIGN KEY (viewer_num) REFERENCES viewers (num_viewer)

);

CREATE TABLE tickets
(
    ticket_code      INTEGER CHECK ( ticket_code > 0 ),
    performance_code INTEGER                        NOT NULL,
    num_seat         INTEGER CHECK ( num_seat > 0 ) NOT NULL,
    price            DECIMAL CHECK ( price > 0.0 )  NOT NULL,
    num_sale         INTEGER,
    PRIMARY KEY (ticket_code),
    UNIQUE (num_seat, performance_code),
    FOREIGN KEY (performance_code) REFERENCES performances (per_code),
    FOREIGN KEY (num_sale) REFERENCES tickets (ticket_code)
);

CREATE TABLE intervals
(
    start_time TIMESTAMP,
    end_time   TIMESTAMP CHECK ( end_time > start_time ) NOT NULL,
    PRIMARY KEY (start_time)
);

CREATE TABLE trainings
(
    training_code INTEGER CHECK ( training_code > 0 ),
    start_time    TIMESTAMP NOT NULL,
    PRIMARY KEY (training_code),
    FOREIGN KEY (start_time) REFERENCES intervals (start_time)

);

CREATE TABLE animals_trainings
(
    animal_num           INTEGER CHECK ( animal_num > 0 )    NOT NULL,
    training_code        INTEGER CHECK ( training_code > 0 ) NOT NULL,
    special_instructions TEXT,
    PRIMARY KEY (animal_num, training_code)
);
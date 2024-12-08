INSERT INTO artists (artist_num, a_surname, a_name, a_patronymic, a_birth_date, speciality, a_contact_info)
VALUES ('3f3b1c2e-5c3e-4b8b-9c1e-1b2c3d4e5f6a', 'Иванов', 'Иван', 'Иванович', '1980-05-15', 'Клоун',
        'ivanov@example.com'),
       ('6f7e8d9c-0b1a-2c3d-4e5f-6a7b8c9d0e1f', 'Петров', 'Петр', 'Петрович', '1985-07-20', 'Акробат',
        'petrov@example.com'),
       ('1e2f3a4b-5c6d-7e8f-9a0b-1c2d3e4f5a6b', 'Сидоров', 'Сергей', 'Сергеевич', '1990-03-10', 'Жонглер',
        'sidorov@example.com'),
       ('9b8c7d6e-5f4a-3b2c-1d0e-9f8e7d6c5b4a', 'Кузнецов', 'Алексей', 'Алексеевич', '1975-11-30', 'Фокусник',
        'kuznetsov@example.com'),
       ('4d3c2b1a-0e9f-8a7b-6c5d-4e3f2a1b0c9a', 'Смирнов', 'Дмитрий', 'Дмитриевич', '1982-09-05', 'Гимнаст',
        'smirnov@example.com');




INSERT INTO animals (animal_num, species, nickname, date_of_birth, gender, artist_num)
VALUES (1, 'Собака', 'Рекс', '2015-03-20', 'Мужской', '3f3b1c2e-5c3e-4b8b-9c1e-1b2c3d4e5f6a'),
       (2, 'Кошка', 'Мурка', '2016-05-12', 'Женский', '6f7e8d9c-0b1a-2c3d-4e5f-6a7b8c9d0e1f'),
       (3, 'Лошадь', 'Буцефал', '2010-08-25', 'Мужской', '1e2f3a4b-5c6d-7e8f-9a0b-1c2d3e4f5a6b'),
       (4, 'Слон', 'Думбо', '2005-12-01', 'Мужской', '9b8c7d6e-5f4a-3b2c-1d0e-9f8e7d6c5b4a'),
       (5, 'Тигр', 'Шерхан', '2012-07-15', 'Мужской', '4d3c2b1a-0e9f-8a7b-6c5d-4e3f2a1b0c9a');


INSERT INTO performances (per_code, name, date, time)
VALUES (1, 'Вечерний спектакль', '2023-10-01', '19:00:00'),
       (2, 'Дневное представление', '2023-10-02', '14:00:00'),
       (3, 'Утренний спектакль', '2023-10-03', '10:00:00'),
       (4, 'Ночное шоу', '2023-10-04', '22:00:00'),
       (5, 'Полдень спектакль', '2023-10-05', '12:00:00');


INSERT INTO artists_performances (artist_num, per_code)
VALUES ('3f3b1c2e-5c3e-4b8b-9c1e-1b2c3d4e5f6a', 1),
       ('6f7e8d9c-0b1a-2c3d-4e5f-6a7b8c9d0e1f', 2),
       ('1e2f3a4b-5c6d-7e8f-9a0b-1c2d3e4f5a6b', 3),
       ('9b8c7d6e-5f4a-3b2c-1d0e-9f8e7d6c5b4a', 4),
       ('4d3c2b1a-0e9f-8a7b-6c5d-4e3f2a1b0c9a', 5);


INSERT INTO viewers (num_viewer, v_contact_info, v_surname, v_name, v_patronymic, v_birth_date)
VALUES (1, 'petrov@example.com', 'Петров', 'Петр', 'Петрович', '1990-07-25'),
       (2, 'sidorov@example.com', 'Сидоров', 'Сергей', 'Сергеевич', '1988-04-15'),
       (3, 'kuznetsov@example.com', 'Кузнецов', 'Алексей', 'Алексеевич', '1977-12-05'),
       (4, 'smirnov@example.com', 'Смирнов', 'Дмитрий', 'Дмитриевич', '1985-09-20'),
       (5, 'ivanov@example.com', 'Иванов', 'Иван', 'Иванович', '1982-03-10');


INSERT INTO tickets_sale (num_sale, purchase_date, payment_type, viewer_num)
VALUES (1, '2023-09-25', 'Кредитная карта', 1),
       (2, '2023-09-26', 'Наличные', 2),
       (3, '2023-09-27', 'Электронный кошелек', 3),
       (4, '2023-09-28', 'Кредитная карта', 4),
       (5, '2023-09-29', 'Наличные', 5);

-- Вставка данных в таблицу tickets
INSERT INTO tickets (ticket_code, performance_code, num_seat, price, num_sale)
VALUES (1, 1, 10, 50.00, 1),
       (2, 2, 15, 60.00, 2),
       (3, 3, 20, 70.00, 3),
       (4, 4, 25, 80.00, 4),
       (5, 5, 30, 90.00, 5);


INSERT INTO intervals (start_time, end_time)
VALUES ('2023-10-01 09:00:00', '2023-10-01 10:00:00'),
       ('2023-10-02 10:00:00', '2023-10-02 11:00:00'),
       ('2023-10-03 11:00:00', '2023-10-03 12:00:00'),
       ('2023-10-04 12:00:00', '2023-10-04 13:00:00'),
       ('2023-10-05 13:00:00', '2023-10-05 14:00:00');


INSERT INTO trainings (training_code, start_time)
VALUES (1, '2023-10-01 09:00:00'),
       (2, '2023-10-02 10:00:00'),
       (3, '2023-10-03 11:00:00'),
       (4, '2023-10-04 12:00:00'),
       (5, '2023-10-05 13:00:00');


INSERT INTO animals_trainings (animal_num, training_code, special_instructions)
VALUES (1, 1, 'Особые инструкции для тренировки Рекса'),
       (2, 2, 'Особые инструкции для тренировки Мурки'),
       (3, 3, 'Особые инструкции для тренировки Буцефала'),
       (4, 4, 'Особые инструкции для тренировки Думбо'),
       (5, 5, 'Особые инструкции для тренировки Шерхана');

INSERT INTO worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES
                                                       ('John Doe', '1980-03-15', 'Senior', 6000),
                                                       ('Jane Smith', '1985-07-20', 'Middle', 4500),
                                                       ('Bob Johnson', '1990-12-10', 'Junior', 2800),
                                                       ('Alice Brown', '1995-05-05', 'Trainee', 1200),
                                                       ('Eve Davis', '1982-09-30', 'Senior', 7000),
                                                       ('Charlie Wilson', '1989-11-25', 'Middle', 4800),
                                                       ('Grace Taylor', '1997-04-18', 'Junior', 2600),
                                                       ('Daniel Harris', '1984-01-03', 'Trainee', 1100),
                                                       ('Olivia Jones', '1983-06-11', 'Senior', 6200),
                                                       ('William Miller', '1992-08-22', 'Middle', 4200);

INSERT INTO client (NAME) VALUES
                              ('Client A'),
                              ('Client B'),
                              ('Client C'),
                              ('Client D'),
                              ('Client E');

INSERT INTO project (CLIENT_ID, START_DATE, FINISH_DATE) VALUES
                                                             (1, '2023-02-01', '2023-05-30'),
                                                             (2, '2023-04-15', '2023-09-20'),
                                                             (3, '2023-06-10', '2024-01-15'),
                                                             (4, '2023-03-10', '2023-07-15'),
                                                             (5, '2023-05-01', '2024-02-28'),
                                                             (1, '2023-07-15', '2023-12-20'),
                                                             (2, '2023-08-20', '2024-04-30'),
                                                             (3, '2023-10-01', '2024-07-31'),
                                                             (4, '2023-12-05', '2024-03-31'),
                                                             (5, '2023-09-10', '2024-01-10');

INSERT INTO project_worker (PROJECT_ID, WORKER_ID) VALUES
                                                       (1, 1),
                                                       (1, 2),
                                                       (2, 2),
                                                       (2, 3),
                                                       (3, 3),
                                                       (3, 4),
                                                       (4, 4),
                                                       (4, 5),
                                                       (5, 5),
                                                       (5, 1),
                                                       (1, 6),
                                                       (2, 7),
                                                       (3, 8),
                                                       (4, 9),
                                                       (5, 10);
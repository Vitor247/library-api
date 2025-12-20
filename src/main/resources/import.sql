INSERT INTO tb_author (name, nationality, birth_date) VALUES ('Machado de Assis', 'Brazilian', '1839-06-21');
INSERT INTO tb_author (name, nationality, birth_date) VALUES ('George Orwell', 'British', '1903-06-25');
INSERT INTO tb_author (name, nationality, birth_date) VALUES ('J.K. Rowling', 'British', '1965-07-31');
INSERT INTO tb_author (name, nationality, birth_date) VALUES ('Stephen King', 'American', '1947-09-21');

INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('Dom Casmurro', '9788525404648', 1899, 1);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('Memórias Póstumas de Brás Cubas', '9788520923713', 1881, 1);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('1984', '9780451524935', 1949, 2);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('Animal Farm', '9788535909555', 1945, 2);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('Harry Potter and the Philosophers Stone', '9788532511010', 1997, 3);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('Harry Potter and the Chamber of Secrets', '9788532511669', 1998, 3);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('It', '9788573029806', 1986, 4);
INSERT INTO tb_book (title, isbn, publication_year, author_id) VALUES ('The Shining', '9788560280947', 1977, 4);

INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (1, 'João Silva', '2025-11-20T09:30:00Z', NULL, 'ACTIVE');
INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (4, 'Maria Santos', '2025-12-1T16:00:00Z', NULL, 'ACTIVE');
INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (2, 'Pedro Costa', '2025-12-05T12:00:00Z', '2025-12-10T13:00:00Z', 'RETURNED');
INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (5, 'Julia Mendes', '2025-12-07T14:00:00Z', '2025-12-15T13:00:00Z', 'RETURNED');
INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (3, 'Rafael Souza', '2025-07-25T10:40:00Z', NULL, 'OVERDUE');
INSERT INTO tb_loan (book_id, user_name, loan_date, return_date, status) VALUES (6, 'Camila Rocha', '2025-05-12T08:00:00Z', NULL, 'OVERDUE');

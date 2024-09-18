INSERT INTO department (name) VALUES
('Human Resources'),
('Engineering'),
('Sales'),
('Marketing'),
('Finance');

INSERT INTO employee (first_name, last_name, email, department_id) VALUES
('Frodo', 'Baggins', 'the.ring.guy@lordoftherings.com', 1),
('Gollum', 'Precious', 'precious@lordoftherings.com', 5),
('Gandalf', 'White', 'whiter.than.white@lordoftherings.com', 2),
('Legolas', 'Greenleaf', 'master.of.the.bow@lordoftherings.com', 3),
('Aragorn', 'Elessar', 'king.of.gondor@lordoftherings.com', 4);


INSERT INTO members
VALUES
('john','{bcrypt}$2a$10$rJTufJJRCXNe2B662798aejrBa39EgilwR5GfXgPhP55jA0bmt48C',1), --fun123
('gabby','{bcrypt}$2a$10$lXvFLVLGgOI28A5VoRD5MutwqqApM8K4TdOZNVx1XDF6YfG72kBHC',1), --Tolk!en1892
('susan','{bcrypt}$2a$10$qeS0HEh7urweMojsnwNAR.vcXJeXR1UcMRZ2WcGQl9YeuspUdgF.q',1); --fun123

INSERT INTO roles
VALUES
('john','ROLE_EMPLOYEE'),
('susan','ROLE_EMPLOYEE'),
('susan','ROLE_MANAGER'),
('susan','ROLE_ADMIN'),
('gabby','ROLE_ADMIN');

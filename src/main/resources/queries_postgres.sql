CREATE SCHEMA employee_db;

CREATE TABLE employees (
                           id SERIAL PRIMARY KEY,
                           name VARCHAR(100),
                           age INT,
                           position VARCHAR(100)
);


INSERT INTO employees (name, age, position) VALUES ('John Doe', 35, 'developer');
-- перед началом создания таблиц и внесения данных необходимо
-- 1. подключиться к запущенному контейнеру с правами root
-- docker exec -it mysql-container mysql -u root -p
-- 2. ввести пароль: root_pass
-- 3. предоставить привилегии созданному в процессе запуска контейнера пользователю user
-- GRANT ALL PRIVILEGES ON employee_db.* TO 'user'@'%';
-- 4. записать изменения FLUSH PRIVILEGES;
-- выйти QUIT

CREATE TABLE employees
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(100),
    age      INT,
    position VARCHAR(100)
);

INSERT INTO employee_db.employees (name, age, position)
VALUES ('John Doe', 35, 'developer');




-- перед началом создания таблиц и внесения данных необходимо
-- 1. подключиться к запущенному контейнеру с правами root
-- docker exec -it mysql-container mysql -u root -p
# docker exec: Эта команда позволяет выполнять команды в работающем контейнере Docker.
#
# -it: Эти флаги используются для интерактивной работы:
#
# -i (interactive) позволяет запускать контейнер в интерактивном режиме, что означает, что он будет продолжать принимать ввод.
# -t (tty) создает терминал для взаимодействия.
# mysql-container: Это имя или ID контейнера, в котором выполняется команда. В данном случае это контейнер с MySQL, запущенный под именем mysql-container.
#
# mysql -u root -p: Это команда, которая будет выполнена внутри контейнера:
#
# mysql: Запускает клиент MySQL.
# -u root: Указывает, что вы входите в MySQL под пользователем root.
# -p: Запрашивает ввод пароля для пользователя root.
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




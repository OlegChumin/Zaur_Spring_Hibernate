package com.zaurtregulov.spring.hibernate.test;

import com.zaurtregulov.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * CRUD - это акроним, обозначающий базовые операции с данными в базе данных. CRUD означает:
 *
 * C (create) - создание записей
 * R (read) - чтение записей
 * U (update) - обновление записей
 * D (delete) - удаление записей
 * */
public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создание сессии
            session.beginTransaction(); // начало транзакции
            Employee employee = session.get(Employee.class, 3);
            session.delete(employee); // удаление работника с id 3 Alexander Smirnov

            session.getTransaction().commit(); // коммит транзакции (сохраняем изменения объекта уже в таблице БД

            System.out.println("Done!"); // вывод сообщения об успешном выполнении операции

        } finally {
            factory.close(); // закрытие фабрики сессий
        }
    }
}

/**
 * Employee employee = session.get(Employee.class, 'serializable:'3);
 * Serializable - это маркерный интерфейс в Java, который указывает на то, что объект, реализующий этот интерфейс,
 * может быть сериализован.
 *
 * В данном случае, если id=3 является типом Serializable, это означает, что id может быть сохранен в поток и
 * восстановлен позже в его исходное состояние. В контексте запроса session.get(Employee.class, 3), это означает, что
 * идентификатор типа Serializable передается в метод get(), который используется для получения объекта типа Employee
 * из базы данных с заданным идентификатором.
 *
 *
 Да, сериализация - это процесс преобразования объекта в бинарное представление, которое можно сохранить или передать
 по сети. При сериализации объекта его состояние сохраняется в последовательности байтов, которые могут быть
 восстановлены в исходный объект в процессе десериализации. Serializable в данном контексте означает, что класс
 Employee поддерживает сериализацию, т.е. объекты этого класса могут быть преобразованы в бинарный код и сохранены в
 файл или переданы по сети.
 * */

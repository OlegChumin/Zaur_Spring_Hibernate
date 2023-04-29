package com.zaurtregulov.spring.hibernate.test;

import com.zaurtregulov.spring.hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * CRUD - это акроним, обозначающий базовые операции с данными в базе данных. CRUD означает:
 *
 * C (create) - создание записей
 * R (read) - чтение записей
 * U (update) - обновление записей
 * D (delete) - удаление записей
 * */
public class Test3_3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создание сессии
            session.beginTransaction(); // начало транзакции
            List<Employee> emps = session.createQuery("from Employee") // выполнение запроса на получение всех записей из таблицы
                    .getResultList(); // получение списка объектов Employee, удовлетворяющих запросу
            session.getTransaction().commit(); // коммит транзакции

            System.out.println("Done!"); // вывод сообщения об успешном выполнении операции

        } finally {
            factory.close(); // закрытие фабрики сессий
        }
    }
}

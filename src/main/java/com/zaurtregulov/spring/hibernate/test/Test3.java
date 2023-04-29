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
public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Oleg", "Sidorov", "HR", 600);
            session.beginTransaction();
            session.save(emp); //CRUD -> CREATE == session.save ==INSERT
//            session.getTransaction().commit(); // здесь транзакция уже закрыта

            int myId = emp.getId();
//            session = factory.getCurrentSession(); // открываем новую сессию
//            session.beginTransaction(); // запускаем транзакцию
            Employee employee = session.get(Employee.class, myId); // READ == SELECT преобразование строки таблицы в объект
            session.getTransaction().commit(); // закрываем транзакцию
            System.out.println(employee);

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}

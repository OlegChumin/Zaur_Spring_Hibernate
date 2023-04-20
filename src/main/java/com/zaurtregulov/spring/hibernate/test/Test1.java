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
public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee emp = new Employee("Zaur", "Tregulov", "IT", 500);
            session.beginTransaction();
            session.save(emp); //CRUD -> CREATE == INSERT
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

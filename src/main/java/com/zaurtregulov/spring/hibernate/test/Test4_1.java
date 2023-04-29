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
public class Test4_1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession(); // создание сессии
            session.beginTransaction(); // начало транзакции
//            Employee employee = session.get(Employee.class, 3); // получаем первого Alexander
//            employee.setSalary(1500); //на полученном объекте вносим изменения
            session.createQuery("update Employee set salary = 1000 " +
                    "where name = 'Alexander'").executeUpdate();
            session.getTransaction().commit(); // коммит транзакции (сохраняем изменения объекта уже в таблице БД

            System.out.println("Done!"); // вывод сообщения об успешном выполнении операции

        } finally {
            factory.close(); // закрытие фабрики сессий
        }
    }
}

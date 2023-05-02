package com.zaurtregulov.spring.hibernate_one_to_many_uni;

import com.zaurtregulov.spring.hibernate_one_to_many_uni.entity.Department;
import com.zaurtregulov.spring.hibernate_one_to_many_uni.entity.Employee_3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5_2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_3.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Employee_3 employee_3 = session.get(Employee_3.class, 2); //Olga Vasilieva
            System.out.println(employee_3);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

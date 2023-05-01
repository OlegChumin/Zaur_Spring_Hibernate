package com.zaurtregulov.spring.hibernate_test_2;

import com.zaurtregulov.spring.hibernate_test_2.entity.Details;
import com.zaurtregulov.spring.hibernate_test_2.entity.Employee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2_2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_2.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            Details details = session.get(Details.class, 4);
            session.delete(details);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

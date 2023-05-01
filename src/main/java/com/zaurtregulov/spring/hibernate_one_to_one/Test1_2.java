package com.zaurtregulov.spring.hibernate_one_to_one;

import com.zaurtregulov.spring.hibernate_one_to_one.entity.Details;
import com.zaurtregulov.spring.hibernate_one_to_one.entity.Employee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_2.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            Employee_2 employee_2 = session.get(Employee_2.class, 1);
            System.out.println(employee_2);
            System.out.println(employee_2.getEmployee_2_details()); // работает cascade
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}

package com.zaurtregulov.spring.hibernate_test_2;

import com.zaurtregulov.spring.hibernate_test_2.entity.Details;
import com.zaurtregulov.spring.hibernate_test_2.entity.Employee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_2.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            Employee_2 employee_2 = new Employee_2("Zaur", "Tregulov", "IT", 500);
            Details details = new Details("Baku", "12345678", "zaurtregulov@gmail.com");
            employee_2.setEmployee_2_details(details);

            session.beginTransaction();
            session.save(employee_2);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            factory.close();
        }
    }
}

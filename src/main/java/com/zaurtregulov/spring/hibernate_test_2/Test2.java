package com.zaurtregulov.spring.hibernate_test_2;

import com.zaurtregulov.spring.hibernate_test_2.entity.Details;
import com.zaurtregulov.spring.hibernate_test_2.entity.Employee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_2.class)
                .addAnnotatedClass(Details.class)
                .buildSessionFactory();
        Session session = null;
        try {
            session = factory.getCurrentSession();
            Employee_2 employee_2 = new Employee_2("Nikolay", "Ivanov", "HR", 850);
            Details details = new Details("New-York", "654123789", "nikolay@gmail.com");
            employee_2.setEmployee_2_details(details);
            details.setEmployee_2(employee_2);

            session.beginTransaction();
            session.save(details);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

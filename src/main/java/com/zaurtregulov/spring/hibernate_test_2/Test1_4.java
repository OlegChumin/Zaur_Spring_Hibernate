package com.zaurtregulov.spring.hibernate_test_2;

import com.zaurtregulov.spring.hibernate_test_2.entity.Details;
import com.zaurtregulov.spring.hibernate_test_2.entity.Employee_2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_4 {
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
            Employee_2 employee_2 = session.get(Employee_2.class, 2); //READ==GET==Oleg
            System.out.println(employee_2);
            System.out.println(employee_2.getEmployee_2_details());
            session.delete(employee_2); // работает cascade, поэтому удалится и информация в details
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

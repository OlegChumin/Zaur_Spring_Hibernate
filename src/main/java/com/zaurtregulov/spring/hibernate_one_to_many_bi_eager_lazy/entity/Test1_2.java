package com.zaurtregulov.spring.hibernate_one_to_many_bi_eager_lazy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1_2 {
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
            System.out.println("Get department:");
            Department department = session.get(Department.class, 5);

            System.out.println("Show department:");
            System.out.println(department);

            department.getEmployee_3List().get(0);

            session.getTransaction().commit();

            System.out.println("Show employees of the department:");
            System.out.println(department.getEmployee_3List());
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

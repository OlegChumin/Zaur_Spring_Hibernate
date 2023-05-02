package com.zaurtregulov.spring.hibernate_one_to_many_uni;

import com.zaurtregulov.spring.hibernate_one_to_many_uni.entity.Department;
import com.zaurtregulov.spring.hibernate_one_to_many_uni.entity.Employee_3;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5_1 {
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
            Department department = session.get(Department.class, 4);
            System.out.println(department);
            System.out.println(department.getEmployee_3List());
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

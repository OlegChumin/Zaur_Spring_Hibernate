package com.zaurtregulov.spring.hibernate_one_to_many_bi_eager_lazy.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee_3.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();

        Session session = null;

        try {
            session = factory.getCurrentSession();
            Department department = new Department("HR", 800, 1200);
            Employee_3 employee_3_1 = new Employee_3("Maxim", "Volkov", 800);
            Employee_3 employee_3_2 = new Employee_3("Marina", "Petrova", 1200);
            department.addEmployeeToDepartment(employee_3_1);
            department.addEmployeeToDepartment(employee_3_2);

            session.beginTransaction();
            session.save(department);
            session.getTransaction().commit();
            System.out.println("Done!");
        }
        finally {
            session.close();
            factory.close();
        }
    }
}

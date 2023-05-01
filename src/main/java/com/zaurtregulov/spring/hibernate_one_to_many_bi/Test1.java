package com.zaurtregulov.spring.hibernate_one_to_many_bi;

import com.zaurtregulov.spring.hibernate_one_to_many_bi.entity.Department;
import com.zaurtregulov.spring.hibernate_one_to_many_bi.entity.Employee_3;
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
            Department department = new Department("SALES", 500, 1500);
            Employee_3 employee_3_1 = new Employee_3("Oleg", "Sidorov", 900);
            Employee_3 employee_3_2 = new Employee_3("Olga", "Vasilieva", 1100);
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

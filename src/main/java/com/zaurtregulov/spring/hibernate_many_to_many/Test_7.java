package com.zaurtregulov.spring.hibernate_many_to_many;

import com.zaurtregulov.spring.hibernate_many_to_many.entity.Child;
import com.zaurtregulov.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_7 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Section section_1 = new Section("Dance");
            Child child1 =  new Child("Ira", 10);
            Child child2 = new Child("Olja", 7);
            Child child3 = new Child("Masha", 9);

            section_1.addChildToSection(child1);
            section_1.addChildToSection(child2);
            section_1.addChildToSection(child3);

            session.beginTransaction();
            session.persist(section_1);
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}

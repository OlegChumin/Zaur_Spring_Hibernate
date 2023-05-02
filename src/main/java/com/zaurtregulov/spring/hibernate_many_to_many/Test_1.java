package com.zaurtregulov.spring.hibernate_many_to_many;

import com.zaurtregulov.spring.hibernate_many_to_many.entity.Child;
import com.zaurtregulov.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_1 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();

            Section section_1 = new Section("VolleyBall");
            Section section_2 = new Section("Chess");
            Section section_3 = new Section("Math");
            Child child1 =  new Child("Igor", 10);

            child1.addSectionToChild(section_1);
            child1.addSectionToChild(section_2);
            child1.addSectionToChild(section_3);

            session.beginTransaction();
            session.save(child1);
            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}

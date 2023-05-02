package com.zaurtregulov.spring.hibernate_many_to_many;

import com.zaurtregulov.spring.hibernate_many_to_many.entity.Child;
import com.zaurtregulov.spring.hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test_6 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
            session = factory.getCurrentSession();
            Section section_1 = new Section("FootBall");


            session.beginTransaction();
            session.save(section_1);

            //так как нет каскадного сохранения, надо добавить детей в новую секцию вручную это минус,
            //плюс в том, что при удалении секции, данные по детям остаются
            section_1.addChildToSection(session.get(Child.class, 1));
            section_1.addChildToSection(session.get(Child.class, 2));
            section_1.addChildToSection(session.get(Child.class, 3));

            session.getTransaction().commit();
            System.out.println("Done");

        } finally {
            session.close();
            factory.close();
        }
    }
}

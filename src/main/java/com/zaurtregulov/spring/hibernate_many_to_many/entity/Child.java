package com.zaurtregulov.spring.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "children")
public class Child {

    /**
     * В MySQL нет GenerationType.SEQUENCE, GenerationType.TABLE.
     * MySQL поддерживает только GenerationType.AUTO и GenerationType.IDENTITY по умолчанию.
     *
     * GenerationType.AUTO - режим выбора алгоритма автоматически, это означает, что провайдер JPA выберет наиболее
     * подходящий тип генерации идентификаторов сущностей в зависимости от конкретной базы данных.
     *
     * GenerationType.IDENTITY - определяет, что значения идентификаторов будут генерироваться базой данных при вставке
     * новых записей. В MySQL для этого можно использовать тип столбца AUTO_INCREMENT.
     *
     * GenerationType.SEQUENCE и GenerationType.TABLE не поддерживаются напрямую в MySQL, но вы можете реализовать их,
     * используя стратегию таблицы или последовательности MySQL. Однако, это потребует дополнительной настройки и может
     * снизить производительность, поэтому рекомендуется использовать GenerationType.IDENTITY для MySQL.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String firstName;

    @Column(name = "age")
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "child_id"), // указываем, с помощью какого столбца child_section связывается с child
            inverseJoinColumns = @JoinColumn(name = "section_id")) // указываем с помощью какого столбца child_section связывается с section
    private List<Section> sectionList;

    public Child() {
    }

    public Child(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public void addSectionToChild(Section section) {
        if(sectionList == null) {
            sectionList = new ArrayList<>();
        }

        sectionList.add(section); // добавляем секцию (кружок) в список секций ребенка
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Section> getSectionList() {
        return sectionList;
    }

    public void setSectionList(List<Section> sectionList) {
        this.sectionList = sectionList;
    }

    @Override
    public String toString() {
        return "Child{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", age=" + age +
                '}';
    }
}

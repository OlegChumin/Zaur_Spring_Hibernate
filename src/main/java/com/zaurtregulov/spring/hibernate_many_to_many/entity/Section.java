package com.zaurtregulov.spring.hibernate_many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "section")
public class Section {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    /**
     * Указание cascade = CascadeType.ALL в аннотации @ManyToMany позволяет распространять операции сохранения,
     * обновления и удаления на связанные сущности. В данном случае, благодаря этому указанию, при сохранении объекта
     * Section будут автоматически сохранены также все связанные с ним объекты Child, которые были добавлены в список
     * children.
     *
     * Без указания cascade = CascadeType.ALL, при попытке сохранения объекта Section без предварительного сохранения
     * связанных с ним объектов Child будет выброшено исключение org.hibernate.TransientPropertyValueException.
     *
     * */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(name = "child_section",
            joinColumns = @JoinColumn(name = "section_id"),
            // указываем, с помощью какого столбца child_section связывается с section
            inverseJoinColumns = @JoinColumn(name = "child_id"))
            // указываем с помощью какого столбца child_section связывается с child
    private List<Child> children;

    public Section() {
    }

    public Section(String name) {
        this.name = name;
    }

    public void addChildToSection(Child child) {
        if (children == null) {
            children = new ArrayList<>();
        }

        children.add(child);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Section{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

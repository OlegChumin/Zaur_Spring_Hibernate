package com.zaurtregulov.spring.hibernate_one_to_one.entity;

import javax.persistence.*;

@Entity
@Table(name="details")
public class Details {

    /**
     * Аннотация @GeneratedValue в Java используется для определения стратегии генерации значений для первичного ключа
     * (id) сущности.
     *
     * Существует несколько вариантов для определения стратегии генерации:
     *
     * GenerationType.IDENTITY: используется для баз данных, поддерживающих автоинкрементное свойство для первичного
     * ключа. В этом случае id будет автоматически увеличиваться с каждой новой записью в таблице.
     *
     * GenerationType.AUTO: определяет, что JPA-провайдер должен выбрать наиболее подходящую стратегию для генерации
     * первичного ключа. Это может быть либо IDENTITY, либо SEQUENCE, либо TABLE.
     *
     * GenerationType.SEQUENCE: используется для баз данных, поддерживающих последовательности, которые могут быть
     * использованы для генерации первичных ключей.
     *
     * GenerationType.TABLE: использует таблицу в базе данных для генерации первичных ключей.
     *
     * Каждый из этих вариантов имеет свои преимущества и недостатки в зависимости от сценария использования и
     * особенностей базы данных.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "city")
    private String city;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    /**
     * использование аннотации @OneToOne с параметром mappedBy, который указывает на свойство в другом классе, которое
     * устанавливает связь OneToOne с текущим классом. В данном случае, связь OneToOne установлена с классом Employee_2,
     * и параметр mappedBy указывает на свойство employee_2_details в этом классе.
     *
     * Также в этой аннотации используется параметр cascade, который указывает на тип каскадной операции, которая будет
     * применена к связанному объекту Employee_2 при выполнении операций на текущем объекте Details. В данном случае,
     * указаны типы PERSIST и REFRESH, что означает, что при сохранении нового объекта Details, новый объект Employee_2
     * также будет сохранен, а при обновлении объекта Details, объект Employee_2 также будет обновлен.
     *
     * */
    @OneToOne(mappedBy = "employee_2_details", cascade = {CascadeType.PERSIST, CascadeType.REFRESH}) //  @JoinColumn(name = "details_id") уже прописана
    private Employee_2 employee_2; //OneToOne for Bi-directional

    public Details() {
    }

    public Details(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Employee_2 getEmployee_2() {
        return employee_2;
    }

    public void setEmployee_2(Employee_2 employee_2) {
        this.employee_2 = employee_2;
    }

    @Override
    public String toString() {
        return "Details{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

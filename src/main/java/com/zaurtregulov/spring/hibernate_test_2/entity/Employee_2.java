package com.zaurtregulov.spring.hibernate_test_2.entity;

import javax.persistence.*;

@Entity
@Table(name="employees_2")
public class Employee_2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="surname")
    private String surname;

    @Column(name="department")
    private String department;

    @Column(name="salary")
    private int salary;

    /**
     *
     Аннотация @OneToOne используется для установления отношения один к одному между двумя сущностями в JPA. Она
     указывает, что поле с этой аннотацией должно быть отображено на другую сущность, на которую ссылаются.

     @JoinColumn используется для указания столбца, который будет использоваться в качестве внешнего ключа для
     соединения двух таблиц. В данном случае, она указывает, что в таблице employees должен быть создан столбец
     details_id, который будет использоваться в качестве внешнего ключа для связи со столбцом id в таблице details.
     По умолчанию, OneToOne отношение не использует каскадирование (CascadeType), то есть при удалении одной из
     сущностей в отношении, связь между ними просто обнуляется. Однако, в зависимости от ситуации, можно задать нужный
     тип каскадирования явно при помощи аннотации @OneToOne(cascade = ...). Например, если нужно удалить связанную
     сущность при удалении основной, можно использовать CascadeType.REMOVE.
     * */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "details_id")
    private Details employee_2_details;

    public Employee_2() {
    }

    public Employee_2(String name, String surname, String department, int salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", department='" + department + '\'' +
                ", salary=" + salary +
                '}';
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Details getEmployee_2_details() {
        return employee_2_details;
    }

    public void setEmployee_2_details(Details employee_2_details) {
        this.employee_2_details = employee_2_details;
    }
}

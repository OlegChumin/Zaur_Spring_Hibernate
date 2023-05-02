package com.zaurtregulov.spring.hibernate_many_to_many.entity;

import javax.persistence.*;

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
}

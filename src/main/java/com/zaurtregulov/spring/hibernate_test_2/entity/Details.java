package com.zaurtregulov.spring.hibernate_test_2.entity;

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
    private int id;

    private String city;

    private String phoneNumber;

    private String email;

}

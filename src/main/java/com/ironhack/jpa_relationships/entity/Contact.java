package com.ironhack.jpa_relationships.entity;

import jakarta.persistence.*;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 50)
    private String company;
    @Column(nullable = false, length = 50)
    private String title;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name="salutation", column = @Column(name = "contact_salutation", nullable = false)),
            @AttributeOverride(name="firstName", column = @Column(name = "contact_first_name", nullable = false)),
            @AttributeOverride(name="middleName", column = @Column(name = "contact_middle_name")),
            @AttributeOverride(name="lastName", column = @Column(name = "contact_last_name", nullable = false))
    })
    private Name name;

    public Contact() {
    }

    public Contact(String company, String title, Name name) {
        this.company = company;
        this.title = title;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }
}

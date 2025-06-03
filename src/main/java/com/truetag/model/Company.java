package com.truetag.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "empresas")
@NoArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private List<Contact> contacts;

    public Company(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

}
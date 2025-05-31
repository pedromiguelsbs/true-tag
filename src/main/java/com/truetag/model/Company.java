package com.truetag.model;

import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private List<Contact> contacts;

    public Company(String name) {
        this.name = name;
        this.contacts = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Contact> getContacts() {
        return contacts;
    }
    public List<Contact> getAuthenticContacts() {
        List<Contact> auth = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.isAuthentic()) {
                auth.add(c);
            }
        }
        return auth;
    }
    public List<Contact> getNotAuthenticContacts() {
        List<Contact> notAuth = new ArrayList<>();
        for (Contact c : contacts) {
            if (!c.isAuthentic()) {
                notAuth.add(c);
            }
        }
        return notAuth;
    }

    public void addContact(Contact contact) {
        if (!contacts.contains(contact)) {
            contacts.add(contact);
        }
    }

    @Override
    public String toString() {
        return getName();
    }

}

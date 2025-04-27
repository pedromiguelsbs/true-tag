package com.truetag.app;

import com.truetag.model.Company;
import com.truetag.model.Contact;
import com.truetag.model.Phone;

public class Main {
    public static void main(String[] args) {

        Company company = new Company("Banco XPTO");

        company.addContact(new Phone("1130031000", true));
        company.addContact(new Phone("1140040022", true));
        company.addContact(new Phone("0800570022", false));
        company.addContact(new Phone("1140020022", false));
        company.addContact(new Phone("1133350237", true));

        for (Contact c : company.getContacts()) {
            System.out.println(c);
        }

    }
}

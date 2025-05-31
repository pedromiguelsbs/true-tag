package com.truetag.app;

import com.truetag.config.DatabaseCreator;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.truetag.model.Company;
import com.truetag.model.Contact;
import com.truetag.model.Phone;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {

        //1) Esconde dados sensíveis do código (URL/Usuário/Senha do MySQL)
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        //2) Cria o banco de dados caso não exista.
        DatabaseCreator.createDatabaseIfNotExists();

        //3) Inicia a aplicação
        SpringApplication.run(Main.class, args);


        /*
        Company company = new Company("Banco XPTO");


        company.addContact(new Phone("1130031000", true));
        company.addContact(new Phone("1140040022", true));
        company.addContact(new Phone("0800570022", false));
        company.addContact(new Phone("1140020022", false));
        company.addContact(new Phone("1133350237", true));

        for (Contact c : company.getContacts()) {
            System.out.println(c);
        }
        */

    }
}

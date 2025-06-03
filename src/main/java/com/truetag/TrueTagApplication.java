package com.truetag;

import com.truetag.config.DatabaseCreator;
import com.truetag.model.Boolean;
import com.truetag.model.Company;
import com.truetag.model.Phone;
import com.truetag.repository.CompanyRepository;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TrueTagApplication {
    public static void main(String[] args) {

        //1) Define variáveis sensíveis no 'application.properties':
        Dotenv dotenv = Dotenv.load();
        System.setProperty("DB_URL", dotenv.get("DB_URL"));
        System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME"));
        System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD"));

        //2) Cria o banco de dados truetagdb caso não exista:
        DatabaseCreator.createDatabaseIfNotExists();

        //3) Inicia a aplicação Spring
        SpringApplication.run(TrueTagApplication.class, args);
    }

    @Bean
    CommandLineRunner run(CompanyRepository companyRepo) {
        return args -> {
            //4) Cria uma Empresa
            Company bradesco = new Company("Bradesco S.A.");

            //5) Adiciona contatos à empresa:
            bradesco.addContact(new Phone("1130031000", Boolean.TRUE));
            bradesco.addContact(new Phone("1140040022", Boolean.TRUE));
            bradesco.addContact(new Phone("0800570022", Boolean.FALSE));
            bradesco.addContact(new Phone("1140020022", Boolean.FALSE));
            bradesco.addContact(new Phone("1133350237", Boolean.TRUE));
            bradesco.addContact(new Phone("11953369158", Boolean.TRUE));

            //6) Popula as tabelas com as informações anteriores:
            companyRepo.save(bradesco);
        };
    }

}

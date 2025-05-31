package com.truetag.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseCreator {

    public static void createDatabaseIfNotExists() {

        Dotenv dotenv = Dotenv.load();
        String host = dotenv.get("DB_HOST");
        String port = dotenv.get("DB_PORT");
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");

        String url = String.format("jdbc:mysql://%s:%s/?user=%s&password=%s", host, port, username, password);

        try (Connection conn = DriverManager.getConnection(url); Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS truetagdb");
            System.out.println("Banco de dados 'truetagdb' criado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Erro ao criar o banco de dados.", e);
        }
    }

}

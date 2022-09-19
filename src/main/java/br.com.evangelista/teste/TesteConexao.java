package br.com.evangelista.teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) throws SQLException {

        final String url = "jdbc:mysql://localhost?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "12345678";

        Connection connection = DriverManager
                .getConnection(url, user, password);

        System.out.println("Conexão efetuada com sucesso!");
        connection.close();
    }
}

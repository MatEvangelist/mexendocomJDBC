package br.com.evangelista.ConnectionFactory;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaConexao {


    public static Connection getConexao() {
        try {
            Properties properties = getProperties();
            final String url = properties.getProperty("banco.url");
            final String user = properties.getProperty("banco.usuario");
            final String password = properties.getProperty("bvanco.senha");

            return DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private static Properties getProperties() throws IOException {
        Properties properties = new Properties();
        String caminho = "resources/conexao.properties";
        properties.load(FabricaConexao.class.getResourceAsStream(caminho));
        return properties;
    }
}
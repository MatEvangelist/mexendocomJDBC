package teste;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {


    public static Connection getConexao() {
        final String url = "jdbc:mysql://localhost/curso_jdbc?verifyServerCertificate=false&useSSL=true";
        final String user = "root";
        final String password = "12345678";

        try {
            return DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}
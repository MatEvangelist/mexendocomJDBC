package teste;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarBanco {

    public static void main(String[] args) throws SQLException {
        Connection connection = FabricaConexao.getConexao();
        Statement stmt = connection.createStatement();
        stmt.execute("CREATE DATABASE IF NOT EXISTS curso_jdbc");

        connection.close();
    }
}

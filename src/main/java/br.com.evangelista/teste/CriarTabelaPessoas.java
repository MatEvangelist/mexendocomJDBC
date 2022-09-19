package br.com.evangelista.teste;

import br.com.evangelista.ConnectionFactory.FabricaConexao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CriarTabelaPessoas {
    public static void main(String[] args) throws SQLException {
        Connection connection = FabricaConexao.getConexao();

        String sql = "CREATE TABLE IF NOT EXISTS pessoas ("
                + "codigo INT AUTO_INCREMENT PRIMARY KEY,"
                + "nome VARCHAR(80) NOT NULL"
                + ")";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        connection.close();
    }
}

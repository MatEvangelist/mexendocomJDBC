package teste;

import ConnectionFactory.FabricaConexao;
import domain.Pessoa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConsultarPessoas1 {

    public static void main(String[] args) throws SQLException {
        Connection connection = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas;";

        Statement stmt = connection.createStatement();
        ResultSet result = stmt.executeQuery(sql); // retorna valor booleano

        List<Pessoa> pessoas = new ArrayList<>();

        while (result.next()) {
            int codigo = result.getInt("codigo");
            String nome = result.getString("nome");
            pessoas.add(new Pessoa(codigo, nome));
        }

        for (Pessoa p : pessoas) {
            System.out.println(p.getCodigo() + " ==> " + p.getNome());
        }

        stmt.close();
        connection.close();
    }
}

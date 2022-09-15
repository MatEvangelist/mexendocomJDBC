package teste;

import domain.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsultarPessoas2 {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Connection connection = FabricaConexao.getConexao();
        String sql = "SELECT * FROM pessoas WHERE nome like ?";

        System.out.println("Informe o valor de pesquisa: ");
        String valor = entrada.nextLine();

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, "%" + valor + "%");
        ResultSet result = stmt.executeQuery(); // retorna valor booleano

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
        entrada.close();
    }
}

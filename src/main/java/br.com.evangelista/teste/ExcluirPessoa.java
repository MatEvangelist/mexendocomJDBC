package br.com.evangelista.teste;

import br.com.evangelista.ConnectionFactory.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ExcluirPessoa {

    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o código: ");
        int codigo = entrada.nextInt();

        Connection connection = FabricaConexao.getConexao();
        String sql = "DELETE FROM pessoas WHERE codigo = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setInt(1, codigo);

        int contador = stmt.executeUpdate();
        if (contador > 0) {
            System.out.println("Pessoa excluída com sucesso!");
        } else {
            System.out.println("Não funcionou...");
        }

        System.out.println("Linhas afetadas: " + contador);

        connection.close();
        entrada.close();
    }
}

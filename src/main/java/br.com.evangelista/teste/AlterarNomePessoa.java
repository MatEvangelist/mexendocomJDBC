package br.com.evangelista.teste;

import br.com.evangelista.ConnectionFactory.FabricaConexao;
import br.com.evangelista.domain.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AlterarNomePessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Informe o código da pessoa: ");
        int codigo = entrada.nextInt();

        Connection connection = FabricaConexao.getConexao();
        String select = "SELECT codigo, nome FROM pessoas WHERE codigo = ?";
        PreparedStatement stmt = connection.prepareStatement(select);
        stmt.setInt(1, codigo);
        ResultSet r = stmt.executeQuery();

        if(r.next()) {
            Pessoa pessoa = new Pessoa(r.getInt(1), r.getString(2));
            System.out.println("O nome atual é " + pessoa.getNome());
            entrada.nextLine();

            System.out.println("Informe o novo nome: ");
            String novoNome = entrada.nextLine();

            String update = "UPDATE pessoas SET nome = ? WHERE codigo = ?";
            stmt.close();
            stmt = connection.prepareStatement(update);
            stmt.setString(1, novoNome);
            stmt.setInt(2, codigo);
            stmt.execute();

            System.out.println("Pessoa alterada com sucesso!");
        } else {
            System.out.println("Pessoa não encontrada!");
        }

        connection.close();
        entrada.close();
    }
}

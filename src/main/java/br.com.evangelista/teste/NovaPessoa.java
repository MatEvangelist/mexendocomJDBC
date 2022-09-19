package br.com.evangelista.teste;

import br.com.evangelista.ConnectionFactory.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class NovaPessoa {
    public static void main(String[] args) throws SQLException {
        Scanner entry = new Scanner(System.in);

        System.out.println("Informe o nome: ");
        String nome = entry.nextLine();

        Connection connection = FabricaConexao.getConexao();

        String sql = "INSERT INTO pessoas (nome, codigo) VALUES (?, ?);";
        // a interrogação aqui se torna uma variável

        PreparedStatement stmt = connection.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setInt(2, 100);
        // aqui é setada a primeira variável (no. 1) a String nome que passo

        stmt.execute();
        System.out.println(sql);
        System.out.println("Pessoa incluída com sucesso!!! :D");

        entry.close();
    }
}

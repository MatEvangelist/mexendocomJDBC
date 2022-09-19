package br.com.evangelista.teste;

import br.com.evangelista.ConnectionFactory.DAO;

public class DAOTeste {

    public static void main(String[] args) {
        DAO dao = new DAO();

        String sql = "INSERT INTO pessoas (nome) VALUES (?)";
        System.out.println(dao.incluir(sql, "João dos Santos"));
        System.out.println(dao.incluir(sql, "Sergio Fagundes"));
        System.out.println(dao.incluir(sql, "Maria Antonieta"));

        dao.close();
    }
}

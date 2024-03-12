package ifmt.cba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao1 {
    public static void main(String[] args) {
        Connection conexao;

        String url = "jdbc:postgresql://localhost:5432/produtos";
        String usr = "postgres";
        String pass = "postgres";

        try {
            Class.forName("org.postgresql.Driver");
            conexao = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexao 1 estabelecida");
            conexao.close();
            System.out.println("Conexao 1 encerrada");
        } catch (ClassNotFoundException cnf) {
            System.out.println("Classe do driver nao encontrada -" + cnf.getMessage());
        } catch (SQLException sql) {
            System.out.println("Conexao nao estabelecida -" + sql.getMessage());
        }
    }
}
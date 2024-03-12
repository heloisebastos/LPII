package ifmt.cba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

public class Conexao2 {
    public static void main (String args []) {
        Connection conexao;

        String url = "jdbc:postgresql://localhost:5432/produtos";
        String usr = "postgres";
        String pass = "postgres";

        try {
            DriverManager.registerDriver(new Driver ());
            conexao = DriverManager.getConnection(url, usr, pass);
            System.out.println("Conexão 2 estabelecida");
            conexao.close();
            System.out.println("Conexão 2 encerrada");
        } catch (SQLException sqle) {
            System.out.println("Conexão não estabelecida -"+sqle.getMessage());
        }
        
    }
}

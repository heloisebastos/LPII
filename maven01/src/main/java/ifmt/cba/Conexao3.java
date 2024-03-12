package ifmt.cba;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao3 {
    public static void main (String args []){

        Properties proBD = new Properties();
        FileInputStream leitorArquivo;
        try{
            leitorArquivo = new FileInputStream("conexao.properties");
            proBD.load(leitorArquivo);
            leitorArquivo.close();
        } catch (FileNotFoundException ex){
            System.out.println("Arquivo de configuração não encontrado -" + ex.getMessage());
        }catch (IOException ex){
            System.out.println("Erro ao ler o arquivo de configurações -" +ex.getMessage());
        }

        if (!proBD.isEmpty()){

            Connection conexao;
            String url = proBD.getProperty("url");
            String driver = proBD.getProperty("driver");
            String usr = proBD.getProperty("usuario");
            String pass = proBD.getProperty("senha");

        try {
            Class.forName(driver);
            conexao= DriverManager.getConnection(url,usr,pass);
            System.out.println("Conexão 3 estabelecida");
            conexao.close();
            System.out.println("Conexao 3 encerrado");
        }catch (ClassNotFoundException cnf){
            System.out.println("Driver não encontrado -"+ cnf.getMessage());
        }catch (SQLException sqle){
            System.out.println("Banco não conectado -"+sqle.getMessage());
        }
    } else {
        System.out.println("Propriedades não carregada");
     }
   }
}

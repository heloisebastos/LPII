package ifmt.cba.execucao;

import java.sql.Connection;
import javax.swing.JOptionPane;


import ifmt.cba.util.FabricaConexao;

public class TesteFabrica {
    public static void main (String args []){
            Connection conexao;
            try {
              conexao = FabricaConexao.obterConexao();
              JOptionPane.showMessageDialog(null,"Conexao teste fabrica estabelecida");
              conexao.close();
              JOptionPane.showMessageDialog(null,"Conexao teste fabrica encerrada");
            } catch (Exception sql){
              JOptionPane.showMessageDialog(null,"Conexão não estabelecida "+sql.getMessage());
         }
    }   
}
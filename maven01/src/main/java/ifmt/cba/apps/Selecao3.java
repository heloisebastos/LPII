package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Selecao3 {
    public static void main (String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog("Forneça parte do nome a ser pesquisado ");
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("SELECT * FROM grupoprodutos WHERE upper (nome) LIKE ?");
            comando.setString(1,"%" + nome.toUpperCase()+ "%");
            ResultSet resultado = comando.executeQuery();
            
            if (resultado.next()) {
                do {
                    System.out.println("Codigo: "+ resultado.getInt("codigo"));
                System.out.println("Nome: "+resultado.getString("nome"));
                System.out.println("Promocao: "+ resultado.getFloat("promocao")+" %");
                System.out.println("Margem lucro: "+ resultado.getFloat("margemlucro")+" %");
                System.out.println("-----------------------------------------------------------");
                } while (resultado.next());   
            } else {
                System.out.println("Não encontrado");
            }    
        } catch (Exception ex) {
            System.out.println("Erro ao recuperar um grupo: "+ex.toString());
            
        } finally {
            try {
                comando.close();
                conexao.close();
            } catch (Exception ex) {
                System.out.println("Erro ao desconectar: "+ex.toString());
            }
        }
    }
    
}

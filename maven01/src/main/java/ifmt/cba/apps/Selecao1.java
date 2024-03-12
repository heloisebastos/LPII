package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Selecao1 {
    public static void main (String [] main){
        Connection conexao = null;
        PreparedStatement comando = null;
        try {
            conexao = FabricaConexao.obterConexao ();
            comando= conexao.prepareStatement("SELECT*FROM grupoprodutoS ORDER BY nome");
            ResultSet resultado = comando.executeQuery();
            while (resultado.next()) {
                System.out.println("Codigo: "+ resultado.getInt("codigo"));
                System.out.println("Nome: "+resultado.getString("nome"));
                System.out.println("Promocao: "+ resultado.getFloat("promocao")+" %");
                System.out.println("Margem lucro: "+ resultado.getFloat("margemlucro")+" %");
                System.out.println("-----------------------------------------------------------");
            }
            JOptionPane.showMessageDialog(null,"Seleção realizada com sucesso");
            resultado.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao recuperar os grupos de produtos"+ ex.toString());
        }finally {
            try {
                comando.close();
                conexao.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao desconectar"+ ex.toString());
            }
        }
    }
    
}

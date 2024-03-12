package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Selecao2 {
    public static void main (String args[]){
        Connection conexao = null;
        PreparedStatement comando =null;
        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o código a ser pesquisado"));
        try {
            conexao = FabricaConexao.obterConexao ();
            comando = conexao.prepareStatement("SELECT*FROM grupoprodutos WHERE codigo=?");
            comando.setInt(1,codigo);
            ResultSet resultado = comando.executeQuery();
            if (resultado.next()){
                System.out.println("Encontrado: "+resultado.getString("nome"));
            } else {
                System.out.println("Não encontrado");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Erro ao recuperar um grupo : "+ex.toString());
        } finally {
            try {
                comando.close();
                conexao.close();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null,"Erro ao desconectar : "+ex.toString());
            }
        }
    }
    
}

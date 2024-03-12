package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Excluir1 {

    public static void main (String args[]) {

        Connection conexao = null;
        PreparedStatement comando = null;

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o código do grupo a ser excluido "));
        
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("DELETE FROM grupoprodutos WHERE codigo=?");
            comando.setInt(1, codigo);
            
            int contRec = comando.executeUpdate();
            System.out.println("Exclusão realizada com sucesso [" +contRec+ " excluido]");
        } catch (Exception ex) {
            System.out.println("Erro ao excluir o grupo de produto" +ex.toString());
        } finally {
            try {
                comando.close();
                conexao.close();
            } catch (SQLException ex){
                System.out.println("Erro ao desconectar : "+ ex.toString());
            }

        }
    }
    
}

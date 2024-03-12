package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class Alterar1 {
    public static void main (String args []){
        Connection conexao = null;
        PreparedStatement comando = null;

        int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o código do grupo de produto a ser alterado "));
        float promocao = Integer.parseInt(JOptionPane.showInputDialog("Forneça o valor da promoção"));
        float margem = Integer.parseInt(JOptionPane.showInputDialog("Forneça o valor da margem de lucro"));
        
        try {
            conexao = FabricaConexao.obterConexao();
            comando = conexao.prepareStatement("UPDATE grupoprodutos SET promocao =?,margemlucro=? WHERE codigo=?");
            comando.setFloat (1,promocao);
            comando.setFloat (2,margem);
            comando.setInt(3,codigo);

            int contRec = comando.executeUpdate();
            System.out.println ("Alteração realizada com sucesso");
            System.out.println ("Numero de registros alterados: "+contRec);
        } catch (Exception ex) {
                System.out.println ("Erro ao alterar o grupo: "+ex.toString());
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




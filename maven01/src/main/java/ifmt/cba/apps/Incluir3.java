package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


import ifmt.cba.util.FabricaConexao;

public class Incluir3 {
    public static void main (String args[]){
        Connection conexao = null;
        PreparedStatement comando = null;
        String nome = JOptionPane.showInputDialog("Forneça o nome do grupo de produto");
        float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneça o percentual de promoção do grupo de produto "));
        float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneça o percentual da margem de lucro do grupo de produto "));

    try {
        conexao = FabricaConexao.obterConexao();
        String sql = "INSER INTO grupoproduto (nome,promocao,margemlucro) VALUES (?,?,?,)";
        comando = conexao.prepareStatement (sql,Statement.RETURN_GENERATED_KEYS);
        comando.setString (1, nome);
        comando.setFloat (2, promocao);
        comando.setFloat (3, margem);
        comando.executeUpdate();
        ResultSet rs = comando.getGeneratedKeys();
        long chave = 0;

        if (rs.next()) {
            chave = rs.getLong("codigo");            
        }
        System.out.println("inclusão realizada com sucesso [chave : " +chave + "]");
        
    } catch (Exception exp) {
     System.out.println("Erro ao incluir grupo d eproduto "+ exp.toString());
    } finally {
        try {
            comando.close();
            conexao.close();
        } catch (SQLException sql) {
           System.out.println("Erro ao desconectar " + sql.toString());
        }
        }

    }

}
    
package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;
import ifmt.cba.util.FabricaConexao;

public class Incluir1 {

	public static void main (String args[]){
		Connection conexao = null; 
		Statement comando = null ;
		//entrada de informações -- showInputDialog entrada de dados
	    String nome = JOptionPane.showInputDialog ("Forneca o nome do grupo de produto") ;
        float promocao = Float.parseFloat ( JOptionPane.showInputDialog ( " Forneca o percentual de promocao do grupo de produto " ) );
		float margem = Float.parseFloat (JOptionPane.showInputDialog ( " Forneca o percentual da margem de lucro do grupo de produto " ) ) ;
         //sintaxe de comando
		String sql = "INSERT INTO grupoprodutos( nome, promocao , margemlucro ) VALUES " ;
		sql += " ( ' " + nome + "  ', " + promocao + " , " + margem + " ) " ; //cocatenando uma string

		try {   //estabele uma conexao com banco de dados 
		conexao = FabricaConexao.obterConexao ();
		comando = conexao.createStatement();
		comando.executeUpdate(sql);
		//showMessageDialog emitir uma mesagem
		JOptionPane.showMessageDialog(null,"Inclusão realizada com sucesso");

		} catch (Exception ex) {
			
			JOptionPane.showMessageDialog(null,"Erro ao incluir grupo de produto : " + ex.toString());
		}finally {    //para garantir que a conexao seja encerrada 
			 try{  
						comando.close();
                        conexao.close();
				}catch ( Exception ex ) {
					JOptionPane.showMessageDialog( null," Erro ao desconectar :  " + ex.toString () ) ;
			}
		}
	}
}
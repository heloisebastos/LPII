package ifmt.cba.visao;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import ifmt.cba.negocio.CursoNegocio;


public class AppExclusao {

    public static void main (String []args){
        try {
            CursoNegocio cursoNegocio = new CursoNegocio();

            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneça o codigo do curso a ser excluido"));
            ResultSet resultado = cursoNegocio.buscaPorCodigo(codigo);

            if (resultado.next()){

                cursoNegocio.excluir(resultado.getInt("codigo"));

            }else {
                JOptionPane.showMessageDialog(null,"Não localizado");    
            } 

            cursoNegocio.desconectar();
            
        } catch (Exception exp) {
           System.out.println(exp.getMessage());
        }
    }
}

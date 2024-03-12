package ifmt.cba.visao;

import javax.swing.JOptionPane;
import ifmt.cba.negocio.CursoNegocio;

public class AppInclusao {
    public static void main(String [] args){
        try {
            CursoNegocio cursoNegocio = new CursoNegocio();
            
            String nome = JOptionPane.showInputDialog("Forneça o nome do curso");
            int cargahoraria = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneça a carga horaria do curso "));
            int numsemestre = Integer.parseInt(JOptionPane.showInputDialog(null, " Forneça o numero de semestres do curso"));
        
            cursoNegocio.incluir(nome, cargahoraria, numsemestre);
            cursoNegocio.desconectar();
        } 
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }


}

package ifmt.cba.visao;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import ifmt.cba.negocio.CursoNegocio;

public class AppAlteracao {
    public static void main(String[] args){
        try{
            CursoNegocio cursoNegocio = new CursoNegocio();
            int codigo = Integer.parseInt(JOptionPane.showInputDialog("Forneca o codigo do curso a ser alterado"));
            ResultSet resultado = cursoNegocio.buscaPorCodigo(codigo);
            if(resultado.next()){
                String nome = resultado.getString("nome");
                nome = JOptionPane.showInputDialog("Forneca o novo nome do curso", nome);
                int cargahoraria = resultado.getInt("cargahoraria");
                cargahoraria = Integer.parseInt(JOptionPane.showInputDialog("Forneca a nova carga horaria do curso", cargahoraria));
                int numsemestre = resultado.getInt("numsemestre");
                numsemestre = Integer.parseInt(JOptionPane.showInputDialog("Forneca o novo numero do semestres do curso", numsemestre));
                cursoNegocio.alterar(resultado.getInt("codigo"), nome, cargahoraria, numsemestre);
            }else{
                JOptionPane.showMessageDialog(null,"Nao localizado");
            }
            JOptionPane.showMessageDialog(null,"Nome do curso alterado com sucesso");
            cursoNegocio.desconectar();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
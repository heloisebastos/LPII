package ifmt.cba.apps;


import java.util.List;

import javax.swing.JOptionPane;

import ifmt.cba.vo.GrupoProdutoVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Alterar1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        GrupoProdutoVO grupoVO = null;
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");
            em = emf.createEntityManager();
            //inicia bloco
            em.getTransaction().begin();
            //consulta no bd o que sera alterado
            String pNome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser localizado");
            //sql do tipo jpkl
            Query consulta = em.createQuery("SELECT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) = :pNome ");
            consulta.setParameter("pNome", pNome.toUpperCase());
            //recebe uma lista do bd
            List<GrupoProdutoVO> lista = consulta.getResultList();
            
            if(lista.size() > 0){
                grupoVO = lista.get(0);
                String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto", grupoVO.getNome());
                float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da marge de lucro do grupo de produto", grupoVO.getMargemLucro()));
                float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto", grupoVO.getPromocao()));
                //copula o obj e dipara a opc  merge
                grupoVO.setNome(nome);
                grupoVO.setMargemLucro(margem);
                grupoVO.setPromocao(promocao);
                //o merge manda o obj para o bd
                em.merge(grupoVO);
                em.getTransaction().commit();
                System.out.println("Alteracao realizada com sucesso");
            }else{
                System.out.println("Grupo de produto nao localizado");
            }
        }catch(Exception ex){
            System.out.println("Alteracao nao realizada - " + ex.getMessage());
        }finally{
            if(em != null){
                 em.close();
            }
            if(emf != null){
                emf.close();
            }
         }
    }    
}
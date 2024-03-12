package ifmt.cba.apps;

import javax.swing.JOptionPane;


import ifmt.cba.vo.GrupoProdutoVO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Incluir1 {
    public static void main(String args[]){
        EntityManager em = null;
        EntityManagerFactory emf = null;
        GrupoProdutoVO grupoVO = new GrupoProdutoVO();

        try{
            String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto");
            float margem = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual da margem de lucro do grupo de produto"));
            float promocao = Float.parseFloat(JOptionPane.showInputDialog("Forneca o percentual de promocao do grupo de produto"));
            grupoVO.setNome(nome);
            grupoVO.setMargemLucro(margem);
            grupoVO.setPromocao(promocao);
            //jpa
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");
            em = emf.createEntityManager();
            //inicia p bloco
            em.getTransaction().begin();
            //conexao com bd - inclusao objeto
            em.persist(grupoVO);
            em.getTransaction().commit();
            System.out.println("Inclusao realizada com sucesso");
        }catch(Exception ex){
            System.out.println("Inclusao nao realizada - " + ex.getMessage());
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
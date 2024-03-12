package ifmt.cba.apps;


import java.util.List;

import javax.swing.JOptionPane;

import ifmt.cba.vo.GrupoProdutoVO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class Consulta1 {
    public static void main(String args[]){
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try{
            emf = Persistence.createEntityManagerFactory("UnidadeProdutos");
            em = emf.createEntityManager();
            String nome = JOptionPane.showInputDialog("Forneca o nome do grupo de produto a ser localizado");
            //cria obj de consulta
            Query consulta = em.createQuery("SELECT gp FROM GrupoProdutoVO gp WHERE UPPER(gp.nome) LIKE :pNome ORDER BY gp.nome");
            consulta.setParameter("pNome","%" + nome.toUpperCase() + "%");
            List <GrupoProdutoVO> lista = consulta.getResultList();
            if(lista.size() > 0){
                for(GrupoProdutoVO grupo : lista){
                    System.out.println("------------------------------------------------------");
                    System.out.println("Codigo ......." + grupo.getCodigo());
                    System.out.println("Nome ......." + grupo.getNome());
                    System.out.println("Margem Lucro ......." + grupo.getMargemLucro());
                    System.out.println("Promocao ......." + grupo.getPromocao());
                }
            }else{
                System.out.println("Grupo de produto nao localizado");
            }
        }catch(Exception ex){
            System.out.println("Consulta nao realizada - " + ex.getMessage());
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
package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaJuridica;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class ConsultaPJ {
    /*Listar todas as pessoas jurídicas cadastradas (código, nome fantasia e cnpj), ordenados pelo
nome fantasia. */
      public static void main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createQuery("SELECT pj FROM PessoaJuridica pj ORDER BY pj.nome ");
            List <PessoaJuridica> listaPessoaJuridica = query.getResultList();
             
             System.out.println("\nDados de pessoa fisicas");
             for(PessoaJuridica pj : listaPessoaJuridica ){
                System.out.println("Codigo: " +pj.getCodigo());
                System.out.println("Nome fantasia: "+pj.getNomeFantasia());
                System.out.println("Razão Social: "+pj.getRazaoSocial());
                System.out.println("CNPJ: "+pj.getCnpj());
                System.out.println("-----------------------------------------");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    
}

package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class ConsultaPessoa {
    /*Listar todas as pessoas cadastradas (código e nome),ordenados pelo nome. */
    public static void main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
            
            Query query = em.createQuery("SELECT p FROM Pessoa p ORDER BY p.nome ");
            List <Pessoa> listaPessoa = query.getResultList();

            for (Pessoa p : listaPessoa){
                System.out.println("Codigo: "+p.getCodigo());
                System.out.println("Nome: "+p.getNome());
                System.out.println("-------------------------");
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    
}

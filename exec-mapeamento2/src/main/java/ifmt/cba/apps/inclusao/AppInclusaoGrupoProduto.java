package ifmt.cba.apps.inclusao;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import jakarta.persistence.EntityManager;

public class AppInclusaoGrupoProduto { 
        public static void main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            GrupoProduto grupoProduto = new GrupoProduto("frios");
            em.persist(grupoProduto);

            grupoProduto = new GrupoProduto("secos");
            em.persist(grupoProduto);

            grupoProduto = new GrupoProduto("bebidas");
            em.persist(grupoProduto);
            
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

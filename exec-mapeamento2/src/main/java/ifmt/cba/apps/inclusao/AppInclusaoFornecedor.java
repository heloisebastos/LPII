package ifmt.cba.apps.inclusao;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import jakarta.persistence.EntityManager;

public class AppInclusaoFornecedor { 
    
    public static void main (String[]args){
        try {
            
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Fornecedor fornecedor = new Fornecedor("MT carnes", "joao","456258");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("sampa secos","seu zé","987456");
            em.persist(fornecedor);

            fornecedor = new Fornecedor("bedidas RJ","mariana","753159");
            em.persist(fornecedor);
  
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

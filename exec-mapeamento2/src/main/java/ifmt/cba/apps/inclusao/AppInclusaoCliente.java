package ifmt.cba.apps.inclusao;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;

public class AppInclusaoCliente { 

    public static void main(String[] args) {
       
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
        
            Cliente cliente = new Cliente("Joicy","123","345",300);
             em.persist(cliente);
            
            cliente = new Cliente("Samuel","678","91011",225);
            em.persist(cliente);

            cliente = new Cliente("Julio","121314","151617",105.5f);
            em.persist(cliente); 

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

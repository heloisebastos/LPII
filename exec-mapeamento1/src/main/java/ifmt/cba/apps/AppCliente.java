package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;

public class AppCliente { // App_Cliente

     // Mapeamento (Venda) N <-> 1(Venda)
    public static void main(String[] args) {
       
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();
        
            Cliente cliente = new Cliente("Joicy");
             em.persist(cliente);
            
            cliente = new Cliente("Jose");
            em.persist(cliente);

            cliente = new Cliente("Flor");
            em.persist(cliente); 

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;

public class AppVendedorV {//AppVendedor_Venda
     //Mapeamento  venda N <-> 1 vendendedor

    public static void main (String[] args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

           Vendedor venda = new Vendedor("Ze", 12);
            em.persist(venda);

           venda = new Vendedor("Jojo", 4.5f);
            em.persist(venda);

           venda = new Vendedor("Simba", 2);
            em.persist(venda); 

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

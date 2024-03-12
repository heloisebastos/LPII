package ifmt.cba.apps.inclusao;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;

public class AppInclusaoVendedor {//AppVendedor_Venda
     //Mapeamento  venda N <-> 1 vendendedor

    public static void main (String[] args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

           Vendedor vendedor = new Vendedor("Ze","123","456", 12);
            em.persist(vendedor);

            vendedor = new Vendedor("Jojo","789","1011", 5.5f);
            em.persist(vendedor);

           vendedor = new Vendedor("Simba","1213","1415", 2);
            em.persist(vendedor); 

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

/*package ifmt.cba.apps;

import java.util.Calendar;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;


public class AppVendaCliente { //mapeamento Cliente 1->N Venda
    
    public static void main (String[]args ){
       try {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();

            Venda venda = new Venda(Calendar.getInstance());
            entityManager.persist(venda);

            venda = new Venda(Calendar.getInstance());
            entityManager.persist(venda);

            venda = new Venda(Calendar.getInstance());
            entityManager.persist(venda);

            entityManager.getTransaction().commit();

       } catch (Exception e) {
          System.out.println(e.toString());
       }

    }
}
*/
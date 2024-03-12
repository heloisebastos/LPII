/*package ifmt.cba.apps;

import java.util.Calendar;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

//Mapeamento  venda N <-> 1 vendedor
public class AppVendaV { //APP Venda_Vendedor

    public static void main(String[] args) {
        //Mapeamento (Venda) N <-> 1 (Cliente)  
        try {

            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Zemaria'");
            Vendedor venda = (Vendedor) query.getSingleResult();

            Venda v = new Venda(Calendar.getInstance());
            v.setVendedor(venda);
            em.persist(v);

            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Jojo'");
            venda = (Vendedor)query.getSingleResult();

            v = new Venda(Calendar.getInstance());
            v.setVendedor(venda);
            em.persist(v);

            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Simba'");
            venda = (Vendedor)query.getSingleResult();

            v = new Venda(Calendar.getInstance());
            v.setVendedor(venda);
            em.persist(v);

            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
   
    }
}
*/
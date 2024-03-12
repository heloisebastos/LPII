package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

//Mapeamento Vendedor 1-> N  Venda
@SuppressWarnings("unchecked")
public class AppVendedorVenda { // App Vendedor_Venda

    public static void main (String []args){
        
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT dataVenda FROM Venda dataVenda");
            List<Venda> listaVenda = query.getResultList();

            Vendedor venda = new Vendedor("Pedro", 12);
            venda.setListaVenda(listaVenda.subList(0, 1));
            em.persist(venda);

            venda = new Vendedor("Tom", 4.5f);
            venda.setListaVenda(listaVenda.subList(1, 2));
            em.persist(venda);

            venda = new Vendedor("Sol", 2);
            venda.setListaVenda(listaVenda.subList(2, 3));
            em.persist(venda);

            
            em.getTransaction().commit();
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

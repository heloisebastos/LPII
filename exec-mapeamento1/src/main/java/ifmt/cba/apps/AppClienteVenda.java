package ifmt.cba.apps;

import java.util.List;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppClienteVenda { //mapeamento Cliente 1->N Venda
    public static void main (String[]args){
        try {
             EntityManager em = EntityManagerUtil.getEntityManager();
             em.getTransaction().begin();
          
             Query query = em.createQuery("SELECT venda FROM Venda venda");
             List<Venda> listaVenda = query.getResultList();

             Cliente cliente = new Cliente("Heloíse");
             cliente.setListaVenda(listaVenda.subList(0, 1));
             em.persist(cliente);

             cliente = new Cliente("Jão");
             cliente.setListaVenda(listaVenda.subList(1, 2));
             em.persist(cliente);

             cliente = new Cliente("Lais");
             cliente.setListaVenda(listaVenda.subList(2, 3));
             em.persist(cliente);


             em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

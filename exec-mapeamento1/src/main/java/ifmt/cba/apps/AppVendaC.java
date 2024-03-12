package ifmt.cba.apps;

import java.util.Calendar;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppVendaC {// App_Cliente_Venda 

    public static void main(String[] args) {
        //Mapeamento (Venda) N <-> 1 (Cliente)  
        try {

            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Joicy'");
            Cliente cliente = (Cliente) query.getSingleResult();

            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Ze'");
            Vendedor vendedor = (Vendedor)query.getSingleResult();

            Venda v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            em.persist(v);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Jose'");
            cliente = (Cliente) query.getSingleResult();

            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Jojo'");
            vendedor = (Vendedor)query.getSingleResult();

            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            em.persist(v);
            
            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Flor'");
            cliente = (Cliente) query.getSingleResult();

            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Simba'");
            vendedor = (Vendedor)query.getSingleResult();

            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            em.persist(v);

            //venda = new Vendedor("Jojo", 4.5f);
            //venda.setListaVenda(listaVenda.subList(1, 2));
            //em.persist(venda);



            /*query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Jose'");
            cliente = (Cliente)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setCliente(cliente);
            em.persist(venda);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Flor'");
            cliente = (Cliente)query.getSingleResult();

            venda = new Venda(Calendar.getInstance());
            venda.setCliente(cliente);
            em.persist(venda);*/


            em.getTransaction().commit();
           

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

    
}

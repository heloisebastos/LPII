package ifmt.cba.apps.inclusao;

import java.util.Calendar;
import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;
import ifmt.cba.vo.Venda;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppRelVenda {// App_Relacionamento_Venda com cliente,vendedor e item venda

    public static void main(String[] args) {
        try {

            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Joicy'");
            Cliente cliente = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Ze'");
            Vendedor vendedor = (Vendedor)query.getSingleResult();
            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'arroz'");
            Produto produto = (Produto)query.getSingleResult();
            
            //instancia um novo itemvenda
            ItemVenda itemVenda = new ItemVenda(2, 15.9f, 20);
            itemVenda.setProduto(produto); //set produto no itemvenda - agrega o produto no item venda 

            Venda v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            v.getListaItemVenda().add(itemVenda);
            em.persist(v);

            //instancia um novo itemvenda
            itemVenda = new ItemVenda(1, 15.90f, 15);
            itemVenda.setProduto(produto); //set produto no itemvenda - agrega o produto no item venda 

            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            v.getListaItemVenda().add(itemVenda);
            em.persist(v);

            itemVenda = new ItemVenda(5, 15.90f, 15);
            itemVenda.setProduto(produto); //set produto no itemvenda - agrega o produto no item venda 

            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            v.getListaItemVenda().add(itemVenda);
            em.persist(v);
            
            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Samuel'");
            cliente = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Jojo'");
            vendedor = (Vendedor)query.getSingleResult();
            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'peixe'");
            produto = (Produto)query.getSingleResult();
            
            //instancia um novo itemvenda
            itemVenda = new ItemVenda(4, 10, 10);
            itemVenda.setProduto(produto); //set produto no itemvenda - agrega o produto no item venda 

            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            v.getListaItemVenda().add(itemVenda);
            em.persist(v);

            query = em.createQuery("SELECT cliente FROM Cliente cliente WHERE cliente.nome='Julio'");
            cliente = (Cliente) query.getSingleResult();
            query = em.createQuery("SELECT venda FROM Vendedor venda WHERE venda.nome='Simba'");
            vendedor = (Vendedor)query.getSingleResult();
            query = em.createQuery("SELECT produto FROM Produto produto WHERE produto.nome = 'suco de uva'");
            produto = (Produto)query.getSingleResult();
            
            //instancia um novo itemvenda
            itemVenda = new ItemVenda(3, 8.88f, 5);
            itemVenda.setProduto(produto); //set produto no itemvenda - agrega o produto no item venda 
            v = new Venda(Calendar.getInstance());
            v.setVendedor(vendedor);
            v.setCliente(cliente);
            v.getListaItemVenda().add(itemVenda);
            em.persist(v);

            em.getTransaction().commit();
           
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    } 
}

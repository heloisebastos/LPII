package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppItemVendaP { // AppItemVenda_Produto
//ItemVenda  N->1 Produto
//Venda 1->N ItemVenda
    public static void main (String []args){
        try {


            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();
            
            //seleciona produto 
            Query query = entityManager.createQuery("SELECT newProduto FROM Produto newProduto WHERE newProduto.nome = 'arroz'");
            Produto newProduto = (Produto)query.getSingleResult();
            
            //instancia um novo itemvenda
            ItemVenda newVenda = new ItemVenda(1, 14, 0.1f);
            newVenda.setProduto(newProduto); //set produto no itemvenda - agrega o produto no item venda 
            entityManager.persist(newVenda); //persiste a venda 
            
            //-------nova agregação---------
            query = entityManager.createQuery("SELECT newProduto FROM Produto newProduto WHERE newProduto.nome = 'refrigerante'");
            newProduto = (Produto)query.getSingleResult();

            newVenda = new ItemVenda(2, 13, 0.15f);
            newVenda.setProduto(newProduto); //set produto no itemvenda
            entityManager.persist(newVenda); //persiste a venda 

            //-------nova agregação---------
            query = entityManager.createQuery("SELECT newProduto FROM Produto newProduto WHERE newProduto.nome = 'frango'");
            newProduto = (Produto)query.getSingleResult();

            newVenda = new ItemVenda(3, 11, 10);
            newVenda.setProduto(newProduto); //set produto no itemvenda
            entityManager.persist(newVenda); //persiste a venda 

            entityManager.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

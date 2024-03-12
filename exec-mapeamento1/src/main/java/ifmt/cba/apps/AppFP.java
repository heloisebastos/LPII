package ifmt.cba.apps;

import java.util.List;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppFP { //AppFornecedor_Produto
      //Classe produto N <-> N fornecedor - Recupera produto e agrega em fornecedor 
    
     public static void main (String[]args){
       try {
             EntityManager em = EntityManagerUtil.getEntityManager();
             em.getTransaction().begin();
            
            //recupera produto 
             Query query = em.createQuery("SELECT newProduto FROM Produto newProduto");
             List <Produto> listaProdutos = query.getResultList();

             //recupera fornecedor 
             query = em.createQuery("SELECT nome FROM Fornecedor nome");
             List<Fornecedor> listaFornecedor = query.getResultList();

             // 
             Fornecedor fProdutos = listaFornecedor.get(0);//fP = fornecedor Produtos
             fProdutos.setListaProdutos(listaProdutos.subList(0, 1));
             em.persist(fProdutos);

             fProdutos = listaFornecedor.get(1);
             fProdutos.setListaProdutos(listaProdutos.subList(1,2));
             em.persist(fProdutos);


             fProdutos = listaFornecedor.get(2);
             fProdutos.setListaProdutos(listaProdutos.subList(2, 3));
             em.persist(fProdutos);

             em.getTransaction().commit();
       } catch (Exception e) {
            System.out.println(e.toString());
       }

    }  
}

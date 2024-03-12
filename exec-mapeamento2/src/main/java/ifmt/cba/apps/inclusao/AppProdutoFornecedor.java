package ifmt.cba.apps.inclusao;



import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


@SuppressWarnings("unchecked")
public class AppProdutoFornecedor { //Relacionamento produto <- fornecedor
    
     public static void main (String[]args){
       try {
             EntityManager em = EntityManagerUtil.getEntityManager();
             em.getTransaction().begin();

             Query query = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor");
             List<Fornecedor> listaFornecedor = query.getResultList();

             query =  em.createQuery("SELECT produto FROM Produto produto");
             List<Produto> listaProduto = query.getResultList();

             Produto produto = listaProduto.get(0);
             produto.setListaFornecedor(listaFornecedor.subList(0, 1));
             em.persist(produto);

             produto = listaProduto.get(1);
             produto.setListaFornecedor(listaFornecedor.subList(1, 2));
             em.persist(produto); 
             
             produto = listaProduto.get(2);
             produto.setListaFornecedor(listaFornecedor.subList(2, 3));
             em.persist(produto); 

             em.getTransaction().commit();
       } catch (Exception e) {
            System.out.println(e.toString());
       }

    }  
}

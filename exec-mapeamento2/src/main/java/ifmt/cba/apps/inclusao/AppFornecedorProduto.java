package ifmt.cba.apps.inclusao;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppFornecedorProduto {  //Relacionamento fornecedor <- produto
    public static void main(String[]args) {
    try {
        EntityManager em= EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Query query = em.createQuery("SELECT produto FROM Produto produto");
        List<Produto> listaProdutos = query.getResultList();

        query = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor");
        List<Fornecedor>listaFornecedor = query.getResultList();

        Fornecedor fornecedor = listaFornecedor.get(0);
        System.out.println(listaProdutos);
        fornecedor.setListaProdutos(listaProdutos.subList(0, 1));
        em.persist(fornecedor);

        fornecedor = listaFornecedor.get(1);
        fornecedor.setListaProdutos(listaProdutos.subList(1, 2));
        em.persist(fornecedor);

        fornecedor = listaFornecedor.get(2);
        fornecedor.setListaProdutos(listaProdutos.subList(2, 3));
        em.persist(fornecedor);
        
        em.getTransaction().commit();
    
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    
    }
}

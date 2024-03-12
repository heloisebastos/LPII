package ifmt.cba.apps;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppPF { //AppProduto_Fornecedor

     /*Classe produto N <-> N fornecedor - Recupera fornecedor e agrega fornecedor em produto */
    
    public static void main (String[]args){
        try {
            
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            //seleciona fornecedor 
            Query query = em.createQuery("SELECT nome FROM Fornecedor nome");
            List<Fornecedor> listaFornecedor = query.getResultList();

            //seleciona produto
            query = em.createQuery("SELECT newProduto FROM Produto newProduto");
            List<Produto> listaProdutos = query.getResultList();

            //agregação de fornecedor em produto
            Produto PF = listaProdutos.get(0);
            PF.setListaFornecedor(listaFornecedor.subList(0, 1));
            em.persist(PF);

            PF = listaProdutos.get(1);
            PF.setListaFornecedor(listaFornecedor.subList(1, 2));
            em.persist(PF);

            PF = listaProdutos.get(2);
            PF.setListaFornecedor(listaFornecedor.subList(2, 3));
            em.persist(PF);
             
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

}

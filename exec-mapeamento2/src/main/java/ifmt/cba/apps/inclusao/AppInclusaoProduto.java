package ifmt.cba.apps.inclusao;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppInclusaoProduto {
      public static void main (String []args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'frios'");
            GrupoProduto grupoProduto = (GrupoProduto)query.getSingleResult();

            Produto produto = new Produto("peixe", 10);
            produto.setGrupoproduto(grupoProduto);
            em.persist(produto);
        
            query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'secos'");
            grupoProduto = (GrupoProduto)query.getSingleResult();

            produto = new Produto("arroz", 15.90f);
            produto.setGrupoproduto(grupoProduto);
            em.persist(produto);

            query = em.createQuery("SELECT grupoproduto FROM GrupoProduto grupoproduto WHERE grupoproduto.nome = 'bebidas'");
            grupoProduto = (GrupoProduto)query.getSingleResult();

            produto = new Produto("suco de uva", 8.88f);
            produto.setGrupoproduto(grupoProduto);
            em.persist(produto);

            em.getTransaction().commit();

        } catch (Exception e) {
           System.out.println(e.toString());
        }
    }
}

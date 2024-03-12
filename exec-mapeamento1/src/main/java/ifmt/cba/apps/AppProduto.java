package ifmt.cba.apps;


import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

public class AppProduto {
      /*Produto N->1 Grupo Produto 
      --Na classe Produto cria um objeto,instancia e agrega o produto em grupo produto */

      /*Classe produto N <-> N fornecedor */

      //ItemVenda  N->1 Produto
      public static void main (String []args){
        try {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();

            //seleciona o grupo de produto
            Query query = entityManager.createQuery("SELECT newGrupo FROM GrupoProduto newGrupo WHERE newGrupo.nome='frios' ");
            GrupoProduto newGrupo  = (GrupoProduto)query.getSingleResult();          
            
            //instancia um novo produto  para este grupo de produto que foi selecionado
            Produto newProduto = new Produto("peixe",10);
            
            newProduto.setGrupoproduto(newGrupo); //agrega o novo produto no grupo produto selecionado
            entityManager.persist(newProduto);

            newProduto = new Produto("frango",11);
            newProduto.setGrupoproduto(newGrupo);
            entityManager.persist(newProduto);

            /*repete o processo para os outros novos produtos pertecentes a outro grupo*/
            query= entityManager.createQuery("SELECT newGrupo FROM GrupoProduto newGrupo WHERE newGrupo.nome='bebidas'");
            newGrupo=(GrupoProduto)query.getSingleResult();

            newProduto = new Produto("suco",12);
            newProduto.setGrupoproduto(newGrupo);
            entityManager.persist(newProduto);

            newProduto = new Produto("refrigerante",13);
            newProduto.setGrupoproduto(newGrupo);
            entityManager.persist(newProduto);

            query = entityManager.createQuery("SELECT newGrupo FROM GrupoProduto newGrupo WHERE newGrupo.nome='secos' ");
            newGrupo  = (GrupoProduto)query.getSingleResult();          
            
            newProduto = new Produto("arroz",14);
            
            newProduto.setGrupoproduto(newGrupo); //agrega produto em grupo produto
            entityManager.persist(newProduto);

            newProduto = new Produto("feijao",15);
            newProduto.setGrupoproduto(newGrupo);
            entityManager.persist(newProduto);


            entityManager.getTransaction().commit();


        } catch (Exception e) {
           System.out.println(e.toString());
        }
    }
}

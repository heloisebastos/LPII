package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.GrupoProduto;
import jakarta.persistence.EntityManager;

public class AppGrupoProduto { //Produto N->1 Grupo Produto 
    // Cria os grupos dos produtos
    public static void main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            GrupoProduto newGrupo = new GrupoProduto("frios");
            em.persist(newGrupo);

            newGrupo = new GrupoProduto("secos");
            em.persist(newGrupo);

            newGrupo = new GrupoProduto("bebidas");
            em.persist(newGrupo);
            
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

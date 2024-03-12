package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import jakarta.persistence.EntityManager;

public class AppFornecedor {  /*Classe produto N <-> N fornecedor - 
    Cria um objeto e dá a ele 3 novas instancias */
    
    public static void main(String[]args) {
    try {
        EntityManager em= EntityManagerUtil.getEntityManager();
        em.getTransaction().begin();

        Fornecedor nome = new Fornecedor("Frios MT");
        em.persist(nome);

        nome = new Fornecedor("Sampa Secos");
        em.persist(nome);

        nome = new Fornecedor("Bedidas RJ");
        em.persist(nome);

        em.getTransaction().commit();
    
    } catch (Exception e) {
        System.out.println(e.toString());
    }
    
    }
}

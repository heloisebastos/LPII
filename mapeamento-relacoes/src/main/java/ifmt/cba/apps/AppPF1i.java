package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.PessoaFisica1;
import jakarta.persistence.EntityManager;

public class AppPF1i {

    public static void main (String[]args){
        try {
            EntityManager entityManager = EntityManagerUtil.getEntityManager();
            entityManager.getTransaction().begin();

            PessoaFisica1 pf = new PessoaFisica1(1, "Fulano", 5000.0f);
            entityManager.persist(pf);

            pf = new PessoaFisica1(2, "Fulana", 6000.0f);
            entityManager.persist(pf);

            entityManager.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}

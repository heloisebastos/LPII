package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Vendedor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/*Listar todos os vendedores cadastrados, ordenados por nome (código, nome, valor de 
comissão de cada venda que ele realizou (código da venda, valor total da venda, valor 
comissão na venda)) */

//Não terminei 

@SuppressWarnings("unchecked")
public class VendedorC {//Vendedor Consulta

    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT venda FROM Vendedor venda");
            List<Vendedor> listaVenda = query.getResultList();

            for (Vendedor vendedor : listaVenda ){
                 System.out.println("Codigo:"+vendedor.getCodigo());
                 System.out.println("Nome Vendedor:"+vendedor.getNome());
                 System.out.println("Comissao:"+vendedor.getPerComissao());
                 System.out.println("---------------------------------");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

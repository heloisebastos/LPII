/*package ifmt.cba.apps;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import jakarta.persistence.EntityManager;

public class AppItemVendaV { //AppItemVenda_Venda
    //mapeamento  Venda 1-> N ItemVenda 
    //ItemVenda  N->1 Produto - Cria o objeto e instancia ele 
    public static void main (String[]args) {
        try {
            //entity manager -> realiza a persistencia com o bd 
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin(); //inicia a persistencia
   
            ItemVenda itemVenda = new ItemVenda(5, 3.5f, 0.5f);
            em.persist(itemVenda);
            
            itemVenda = new ItemVenda(15, 5.5f, 2.5f);
            em.persist(itemVenda);
   
            itemVenda = new ItemVenda(25, 10.99f, 0);
            em.persist(itemVenda);

            em.getTransaction().commit(); //encerra a conexao com o bd
           
       } catch (Exception e) {
           System.out.println(e.toString());
       }
   
        
    }
    }
*/
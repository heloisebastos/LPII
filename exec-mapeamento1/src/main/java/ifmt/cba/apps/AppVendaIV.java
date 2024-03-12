package ifmt.cba.apps;

import java.util.Calendar;
import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@SuppressWarnings("unchecked")
public class AppVendaIV { //AppVendaIV - AppVenda_Item Venda
    
    //mapeamento  Venda 1-> N ItemVenda 

    public static void main (String []args){
        try {
             EntityManager entityManager= EntityManagerUtil.getEntityManager();
             entityManager.getTransaction().begin();

             //Seleciona os objetos da tabela ItemVenda
             Query query = entityManager.createQuery("SELECT newVenda FROM ItemVenda newVenda ");
             List<ItemVenda> listaItemVenda = query.getResultList();
            
             //Instancia uma nova data de venda 
             Venda dataVenda = new Venda(Calendar.getInstance());
             dataVenda.setListaItemVendas(listaItemVenda.subList(0, 1)); //Agrega a venda o itemVenda
             entityManager.persist(dataVenda);

             dataVenda = new Venda(Calendar.getInstance());
             dataVenda.setListaItemVendas(listaItemVenda.subList(1, 2));
             entityManager.persist(dataVenda);

             dataVenda = new Venda(Calendar.getInstance());
             dataVenda.setListaItemVendas(listaItemVenda.subList(2, 3));
             entityManager.persist(dataVenda);
             
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

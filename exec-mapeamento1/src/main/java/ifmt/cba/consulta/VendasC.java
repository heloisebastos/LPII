package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/*Listar todas as vendas cadastradas, ordenadas por data da venda (código, data da venda, 
valor total da venda) e seus itens (código, quantidade, preço venda, percentual de desconto) */


// deu problema no imprimir a data de venda  nao fiz valor total da venda 
@SuppressWarnings("unchecked")
public class VendasC {
    public static void main (String[]args){

        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT v FROM Venda v");
            List<Venda> listaVenda = query.getResultList();

            for (Venda venda : listaVenda ){
                System.out.println("CodigoVenda:"+venda.getCodigo());
                //System.out.println("Data Venda"+venda.getDataVenda());
                System.out.println("Itens da venda");
                for (ItemVenda it : venda.getListaItemVendas()){
                    System.out.println("Codigo Venda:"+it.getCodigo());
                    System.out.println("Quantidade:"+it.getQuantidade());
                    System.out.println("Preço :"+it.getPrecoVenda());
                    System.out.println("Desconto"+it.getPerDesconto());
                    System.out.println("---------------------------------");
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

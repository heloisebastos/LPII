package ifmt.cba.consulta;

import java.text.SimpleDateFormat;
import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.ItemVenda;
import ifmt.cba.vo.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/*Listar todas as vendas cadastradas, ordenadas por data da venda (código, data da venda, 
valor total da venda) e seus itens (código, quantidade, preço venda, percentual de desconto) */

@SuppressWarnings("unchecked")
public class ConsultaVendas {
    public static void main (String[]args){

        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            SimpleDateFormat formatar = new SimpleDateFormat("dd/MM/yyyy");
            Query query = em.createQuery("SELECT v FROM Venda v ORDER BY v.dataVenda ");
            List<Venda> listaVenda = query.getResultList();

            for (Venda venda : listaVenda ){
                 System.out.println("Dados venda");
                System.out.println("Codigo Venda:"+venda.getCodigo());
                System.out.println("Data Venda: "+(formatar.format(venda.getDataVenda().getTime())));
                System.out.println("Total da venda: R$"+venda.totalVenda());
                for (ItemVenda i : venda.getListaItemVenda()){
                    System.out.println("\nItem venda");
                    System.out.println("Codigo item:"+i.getCodigo());
                    System.out.println("Quantidade:"+i.getQuantidade());
                    System.out.println("Preço :"+i.getPrecoVenda());
                    System.out.println("Desconto: "+i.getPerDesconto()+"%");
                    System.out.println("---------------------------------");
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

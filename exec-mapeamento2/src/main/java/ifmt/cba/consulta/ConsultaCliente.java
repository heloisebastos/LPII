package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Cliente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/*Listar todos os clientes cadastrados, 
ordenados por nome (código, nome, quantidade de vendas que já foram realizadas para ele);*/


@SuppressWarnings("unchecked")
public class ConsultaCliente {//ClienteConsulta
    public static void main (String []args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT cliente FROM Cliente cliente ORDER BY cliente.nome ");
            List<Cliente> listaCliente = query.getResultList();

            for (Cliente c : listaCliente ){
                System.out.println("Codigo:"+c.getCodigo());
                System.out.println("Nome Produto:"+c.getNome());
                System.out.println("Quantidade de compras:"+c.getListaVenda().size());
                System.out.println("---------------------------------");
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}




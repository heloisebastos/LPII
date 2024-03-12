package ifmt.cba.consulta;


import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

/*Listar todos os fornecedores cadastrados, ordenados por razão social (código e nome) e os 
produtos que ele fornece (código, nome do produto);*/

@SuppressWarnings("unchecked")
public class ConsultaFornecedor { //FornecedorConsulta
    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT fornecedor FROM Fornecedor fornecedor ORDER BY fornecedor.razaoSocial");
            List<Fornecedor> listaFornecedor = query.getResultList();

            for (Fornecedor fornecedor : listaFornecedor ){
                 System.out.println("Codigo Fornecedor:"+fornecedor.getCodigo());
                 System.out.println("RazaoSocial:"+fornecedor.getRazaoSocial());
                for (Produto produto : fornecedor.getListaProdutos()){
                    System.out.println("\n\tCodigo Produto:"+produto.getCodigo());
                    System.out.println("\tNome Produto:"+produto.getNome());
                    System.out.println("---------------------------------");
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

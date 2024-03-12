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
public class FornecedorC { //FornecedorConsulta
    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT nome FROM Fornecedor nome");
            List<Fornecedor> listaFornecedor = query.getResultList();

            for (Fornecedor nome : listaFornecedor ){
                 System.out.println("Codigo:"+nome.getCodigo());
                 System.out.println("RazaoSocial:"+nome.getRazaoSocial());
                System.out.println("---------------------------------");
                for (Produto newProduto : nome.getListaProdutos()){
                    System.out.println("\tCodigo Produto:"+newProduto.getCodigo());
                    System.out.println("\tNome Produto:"+newProduto.getNome());
                    //for (Fornecedor f : newProduto.getListaFornecedor()){
                      //  System.out.println("Codigo Fornecedor:"+f.getCodigo());
                        //System.out.println("Razao Social:"+f.getRazaoSocial());
                   // }
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

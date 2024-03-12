package ifmt.cba.consulta;

import java.util.List;

import ifmt.cba.util.EntityManagerUtil;
import ifmt.cba.vo.Fornecedor;
import ifmt.cba.vo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;


// Listar todos os produtos cadastrados, ordenados por nome (código, nome, preço de venda, 
// nome do grupo de produto e seus fornecedores (código e razão social));

@SuppressWarnings("unchecked")
public class ConsultaProduto { //Produto Consulta

    public static void  main (String[]args){
        try {
            EntityManager em = EntityManagerUtil.getEntityManager();
            em.getTransaction().begin();

            Query query = em.createQuery("SELECT produto FROM Produto produto ORDER BY produto.nome");
            List<Produto> listaProduto = query.getResultList();

            for (Produto p : listaProduto ){
                System.out.println("Codigo:"+p.getCodigo());
                System.out.println("Nome Produto:"+p.getNome());
                System.out.println("Preço Venda:"+p.getPrecoVenda());
                //System.out.println("Fornecedor:"+p.getListaFornecedor().size());
                if (p.getGrupoproduto() != null) {
                    System.out.println("\nGrupo do produto");
                    System.out.println("Codigo:"+p.getGrupoproduto().getCodigo());
                    System.out.println("Nome grupo:"+p.getGrupoproduto().getNome());
                }
                for(Fornecedor f: p.getListaFornecedor()){
                    System.out.println("\nDados fornecedor");
                    System.out.println("Codigo:"+f.getCodigo());
                    System.out.println("Razao Social:"+f.getRazaoSocial());
                    System.out.println("-------------------------------------------------");
                }
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
    
}

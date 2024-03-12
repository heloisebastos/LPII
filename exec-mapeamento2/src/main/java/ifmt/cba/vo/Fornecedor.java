package ifmt.cba.vo;

import java.util.List;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;


@Entity
@DiscriminatorValue("fornecedor")
public class Fornecedor extends PessoaJuridica{


    @ManyToMany(fetch = FetchType.EAGER)
    private List<Produto> listaProdutos;

    public Fornecedor (){

    }

    // public Fornecedor(String nome,String razaoSocial) {
    //     super(nome, razaoSocial);
    // }

    

    public List<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public Fornecedor(String nome, String razaoSocial, String cnpj) {
        super(nome, razaoSocial, cnpj);
    }

    public void setListaProdutos(List<Produto> listaProdutos) {
        this.listaProdutos = listaProdutos;
    }

    
    
}

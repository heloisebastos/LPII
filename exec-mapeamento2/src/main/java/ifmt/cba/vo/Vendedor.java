package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
@Entity
@DiscriminatorValue("vendedor")
public class Vendedor  extends PessoaFisica{

    private float perComissao;

    @OneToMany(mappedBy = "vendedor",fetch = FetchType.EAGER)
    private List<Venda> listaVenda;

    public Vendedor(){

    }

    public Vendedor(String nome, String rg, String cpf, float perComissao) {
        super(nome, rg, cpf);
        this.perComissao = perComissao;
    }

    public float getPerComissao() {
        return perComissao;
    }

    public void setPerComissao(float perComissao) {
        this.perComissao = perComissao;
    }

    public List<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(List<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

      public Float calComissaoVendedor(){
        float total=0;
        for (Venda venda : this.listaVenda){
          total = venda.totalVenda()*(this.perComissao/100);
        }
        return total;
    }
    
}

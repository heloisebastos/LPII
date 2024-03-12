package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends PessoaFisica {
 
    private float limiteCredito;
    
    @OneToMany(mappedBy="cliente",fetch=FetchType.EAGER)
    private List<Venda> listaVenda;
    
    public Cliente (){

    }

    public Cliente(String nome, String rg, String cpf, float limiteCredito) {
        super(nome, rg, cpf);
        this.limiteCredito = limiteCredito;
    }

    public List<Venda> getListaVenda() {
        return listaVenda;
    }

    public void setListaVenda(List<Venda> listaVenda) {
        this.listaVenda = listaVenda;
    }

    public float getLimiteCredito() {
        return limiteCredito;
    }

    public void setLimiteCredito(float limiteCredito) {
        this.limiteCredito = limiteCredito;
    }


}

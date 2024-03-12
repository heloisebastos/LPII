package ifmt.cba.vo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length = 40,nullable=false)
    private String nome;
    
    @Column(precision = 8)
    private float perComissao;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Venda> listaVenda;

    public Vendedor(){

    }

    public Vendedor(String nome, float perComissao) {
        this.nome = nome;
        this.perComissao = perComissao;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
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

    
}

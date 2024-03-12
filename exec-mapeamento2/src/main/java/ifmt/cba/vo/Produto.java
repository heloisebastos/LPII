package ifmt.cba.vo;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable{

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column(length=40,nullable = false)
    private String nome;
    
    @Column(precision = 6)
    private float precoVenda; 
   
    @ManyToOne (fetch = FetchType.EAGER)
    private GrupoProduto grupoproduto;

    @ManyToMany (fetch = FetchType.EAGER)
    private List<Fornecedor> listaFornecedor;

    
    public Produto (){

    }

    
    public Produto(String nome, float precoVenda) {
        this.nome = nome;
        this.precoVenda = precoVenda;
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

    public GrupoProduto getGrupoproduto() {
        return grupoproduto;
    }

    public void setGrupoproduto(GrupoProduto grupoproduto) {
        this.grupoproduto = grupoproduto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

}

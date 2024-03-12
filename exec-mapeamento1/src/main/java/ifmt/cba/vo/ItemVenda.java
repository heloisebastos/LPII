package ifmt.cba.vo;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="itemvenda")
public class ItemVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    private int quantidade;

    @Column(precision = 8)
    private float precoVenda;

    @Column(precision = 8)
    private float perDesconto;


    @ManyToOne(fetch = FetchType.EAGER)
    private Produto produto;

    public ItemVenda (){

    }

    public ItemVenda(int quantidade, float precoVenda, float perDesconto) {
        this.quantidade = quantidade;
        this.precoVenda = precoVenda;
        this.perDesconto = perDesconto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getPerDesconto() {
        return perDesconto;
    }

    public void setPerDesconto(float perDesconto) {
        this.perDesconto = perDesconto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    
      
}

package ifmt.cba.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue (strategy = GenerationType.SEQUENCE)
    private int codigo;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar dataVenda;

    @OneToMany(fetch =FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<ItemVenda> listaItemVenda;
    
    @ManyToOne(fetch =FetchType.EAGER)
    private Vendedor vendedor;
    
    @ManyToOne(fetch =FetchType.EAGER)
    private Cliente  cliente;
    
    public Venda (){
        this.listaItemVenda = new ArrayList<ItemVenda>();

    }

    public Venda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
        this.listaItemVenda = new ArrayList<ItemVenda>();

    }


    public int getCodigo() {
        return codigo;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


    public Calendar getDataVenda() {
        return dataVenda;
    }


    public void setDataVenda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }


    public List<ItemVenda> getListaItemVenda() {
        return listaItemVenda;
    }


    public void setListaItemVenda(List<ItemVenda> listaItemVenda) {
        this.listaItemVenda = listaItemVenda;
    }


     public Float totalVenda(){
        float total=0,aux=0;
         for(ItemVenda itemVenda : this.listaItemVenda){
            aux = itemVenda.getQuantidade()*itemVenda.getPrecoVenda();
            total =aux-( aux * (itemVenda.getPerDesconto()/100));
        }
        return total;
    }


}

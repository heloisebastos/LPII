package ifmt.cba.vo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

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

    @OneToMany(fetch =FetchType.LAZY)
    private List<ItemVenda> listaItemVendas;
    
    @ManyToOne(fetch =FetchType.LAZY)
    private Vendedor vendedor;
    
    @ManyToOne(fetch =FetchType.LAZY)
    private Cliente  cliente;
    
    public Venda (){

    }

    public Venda(Calendar dataVenda) {
        this.dataVenda = dataVenda;
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


    public List<ItemVenda> getListaItemVendas() {
        return listaItemVendas;
    }


    public void setListaItemVendas(List<ItemVenda> listaItemVendas) {
        this.listaItemVendas = listaItemVendas;
    }


}

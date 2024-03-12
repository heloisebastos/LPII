package ifmt.cba.vo;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name ="tabela_b1")
public class B1 implements Serializable { 
    /* Serializable marca que 
    a classe será persistidada com o banco de dados*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int codigo;

    @Column (length = 40,nullable = false)
    private String nome;
    
     public B1(){  // construtor

     }

     public B1 (String nome) {
        this.nome = nome;
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

    

}

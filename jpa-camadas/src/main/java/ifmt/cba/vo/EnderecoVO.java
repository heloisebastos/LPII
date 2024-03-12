package ifmt.cba.vo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

//Usado para representar a instância de endereço, que é agregada em AlunoVO.
//Representa o conceito endereço que pode ser reusado em outras agregações.

@Embeddable
public class EnderecoVO {


    private String logradouro;
    private int numero;
    private String bairro;
    private String cidade;

    //para aparecer na tabela como string
    @Enumerated(EnumType.STRING)
    private EnumUF uf;

    public EnderecoVO(){
        this.logradouro = "";
        this.numero = 0;
        this.bairro = "";
        this.cidade = "";
        this.uf = EnumUF.MT;
    }

    public EnderecoVO(String logradouro, int numero, String bairro, String cidade, EnumUF uf){
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }

    public String getLogradouro(){
        return logradouro;
    }

    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }

    public int getNumero(){
        return numero;
    }

    public void setNumero(int numero){
        this.numero = numero;
    }

    public String getBairro(){
        return bairro;
    }

    public void setBairro(String bairro){
        this.bairro = bairro;
    }

    public String getCidade(){
        return cidade;
    }

    public void setCidade(String cidade){
        this.cidade = cidade;
    }

    public EnumUF getUf(){
        return uf;
    }

    public void setUF(EnumUF uf){
        this.uf = uf;
    }

    public String toString(){
        return this.logradouro + "\n" + this.numero + "\n" + this.bairro + "\n" +this.cidade + " - " + this.uf; 
    }
}
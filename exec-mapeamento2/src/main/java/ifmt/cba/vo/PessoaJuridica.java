package ifmt.cba.vo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")
public class PessoaJuridica extends Pessoa{

    private String razaoSocial;
    private String cnpj;

    public PessoaJuridica (){

    }

    public PessoaJuridica(String nome,String razaoSocial,String cnpj) {
        super(nome);
        this.razaoSocial = razaoSocial;
        this.cnpj=cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getNomeFantasia() {
        return nome;
    }

    public void setNomeFantasia(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    
}

package ifmt.cba.vo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("fisica")
public class PessoaFisica1 extends Pessoa1{
    
    private float salario;

    public PessoaFisica1 () {
        
    }

    public PessoaFisica1(int codigo, String nome, float salario) {
        super(codigo, nome);
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getRendimento() {
        return this.salario;
    }
    
    
}

package ifmt.cba.vo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("juridica")
public class PessoaJuridica1 extends Pessoa1 {
    
    private float prolabore;

    public PessoaJuridica1(){

    }

    public PessoaJuridica1(int codigo, String nome, float prolabore) {
        super(codigo, nome);
        this.prolabore = prolabore;
    }


    public float getProlabore() {
        return prolabore;
    }

    public void setProlabore(float prolabore) {
        this.prolabore = prolabore;
    }

    public float getRendimento(){
        return this.prolabore;
    }

    
}

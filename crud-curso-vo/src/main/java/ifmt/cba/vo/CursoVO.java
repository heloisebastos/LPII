package ifmt.cba.vo;

public class CursoVO {
    private int codigo;
    private String nome;
    private int cargaHoraria;
    private int numSemestre;

    public CursoVO(){
    }

    public int getCodigo(){
        return codigo;
    }

    public void setCodigo(int codigo){
        this.codigo = codigo;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public int getCargaHoraria(){
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria){
        this.cargaHoraria = cargaHoraria;
    }

    public int getNumSemestre(){
        return numSemestre;
    }

    public void setNumSemestre(int numSemestre){
        this.numSemestre = numSemestre;
    }

    public String toString(){
        return nome;
    }

    
}
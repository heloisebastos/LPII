package ifmt.cba.persistencia;

//Especialização da classe Exception para captura e tratamento de exceções ocorridas na camada de persistência.

public class PersistenciaException extends Exception {
    //perguntar ao professor sobre essa linha 5
    private static final long serialVersionUID = 1L;
    public PersistenciaException(){
        super("Erro ocorrido na manipulacao do banco de dados");
    }

    public PersistenciaException(String msg){
        super(msg);
    }
}
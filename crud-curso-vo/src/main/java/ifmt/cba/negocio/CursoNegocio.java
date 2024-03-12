package ifmt.cba.negocio;

import java.util.List;

import ifmt.cba.persistencia.CursoDAO;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.vo.CursoVO;

public class CursoNegocio {
    private CursoDAO cursoDAO;
    
    public CursoNegocio() throws NegocioException{
        try{
            this.cursoDAO = new CursoDAO();
        }catch(PersistenciaException p){
            throw new NegocioException("Erro ao preparar a persistencia - " + p.getMessage());
        }
    }

    public void incluir(CursoVO cursoVO) throws NegocioException{
        try{
            String validacao = this.validarDados(cursoVO);
            if(validacao.isEmpty()){
                this.cursoDAO.incluir(cursoVO);
            }else{
                throw new NegocioException("Dados inconsistentes para a operacao: \n" +validacao);
            }
        }catch(PersistenciaException p){
            throw new NegocioException("Erro ao incluir curso - " +p.getMessage());
        }
    }

    public void alterar(CursoVO cursoVO) throws NegocioException{
        try{
            String validacao = this.validarDados(cursoVO);
            if(validacao.isEmpty()){
                this.cursoDAO.alterar(cursoVO);
            }else{
                throw new NegocioException("Dados inconsistentes para a operacao: \n" +validacao);
            }
        }catch(PersistenciaException p){
            throw new NegocioException("Erro ao alterar curso - " +p.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException{
        try{
            this.cursoDAO.excluir(codigo);
        }catch(PersistenciaException p){
            throw new NegocioException("Erro ao excluir curso - " +p.getMessage());
        }
    }

    public CursoVO buscaPorCodigo(int codigo) throws NegocioException{
        CursoVO retorno = null;
        try{
            retorno = this.cursoDAO.buscaPorCodigo(codigo);
        }catch(PersistenciaException p){
            throw new NegocioException(p.getMessage());
        }
        return retorno;
    }

    public List<CursoVO> buscaPorNome(String nome) throws NegocioException{
        List<CursoVO> retorno = null;
        try{
            retorno = this.cursoDAO.buscaPorNome(nome);
        }catch(PersistenciaException p){
            throw new NegocioException(p.getMessage());
        }
        return retorno;
    }

    public List<CursoVO> buscaTodos() throws NegocioException{

        List<CursoVO> retorno = null;
        try{
            retorno = this.cursoDAO.buscaTodos();
        }catch(PersistenciaException p){
            throw new NegocioException(p.getMessage());
        }
        return retorno;
    }

    public void desconectar() throws NegocioException{
        try{
            this.cursoDAO.desconectar();
        }catch(PersistenciaException p){
            throw new NegocioException("Erro ao desconectar com o banco de dados - "+p.getMessage());
        }
    }

    private String validarDados(CursoVO cursoVO){
        String retorno = "";
        if(cursoVO == null){
            retorno += "Dados de curso nao podem ser nulos";
        }else{
            if(cursoVO.getNome() == null || cursoVO.getNome().isEmpty()){
                retorno += "Nome de curso nao podem ser nulo\n";
            }
            if(cursoVO.getCargaHoraria() <= 0){
                retorno += "Carga horaria de curso deve ser maior que zero\n";
            }

            if(cursoVO.getNumSemestre() <= 0){
                retorno += "Numero de semestre de curso deve ser maior que zero";
            }
        }
        return retorno;
    }
}

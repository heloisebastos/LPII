package ifmt.cba.negocio;

import java.util.List;

import ifmt.cba.persistencia.AlunoDAO;
import ifmt.cba.persistencia.ConexaoBD;
import ifmt.cba.persistencia.PersistenciaException;
import ifmt.cba.vo.AlunoVO;

public class AlunoNegocio {
    private AlunoDAO alunoDAO;

    public AlunoNegocio() throws NegocioException{
        try{
            this.alunoDAO = new AlunoDAO(ConexaoBD.getInstancia());
        }catch(PersistenciaException ex){
            throw new NegocioException("Erro ao inciar a persistencia - " + ex.getMessage());
        }
    }

    public void inserir(AlunoVO alunoVO) throws NegocioException{
        String mensagemErros = this.validarDados(alunoVO);
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }

        try{
            if(alunoDAO.incluir(alunoVO) == 0){
                throw new NegocioException("Inclusao nao realizada");
            }
        }catch(PersistenciaException pe){
            throw new NegocioException("Erro ao incluir o aluno - " + pe.getMessage());
        }
    }

    public void alterar(AlunoVO alunoVO) throws NegocioException{
        String mensagemErros = this.validarDados(alunoVO);
        if(!mensagemErros.isEmpty()){
            throw new NegocioException(mensagemErros);
        }
        try{
            if(alunoDAO.alterar(alunoVO) == 0){
                throw new NegocioException("Alteracao nao realizada");
            }
        }catch(PersistenciaException pe){
            throw new NegocioException("Erro ao alterar o aluno - " + pe.getMessage());
        }
    }

    public void excluir(int codigo) throws NegocioException{
        try{
            if(alunoDAO.excluir(codigo) == 0){
                throw new NegocioException("Exclusao nao realizada");
            }
        }catch(PersistenciaException pe){
            throw new NegocioException("Erro ao excluir o aluno - " +pe.getMessage());
        }
    }   

    public List<AlunoVO> pesquisaParteNome(String parteNome) throws NegocioException{
        try{
            return alunoDAO.buscaPorNome(parteNome);
        }catch(PersistenciaException pe){
            throw new NegocioException("Erro ao pesquisar aluno pelo nome - " +pe.getMessage());
        }
    }

    public AlunoVO pesquisaMatricula(int matricula) throws NegocioException{
        try{
            return alunoDAO.buscaPorMatricula(matricula);
        }catch(PersistenciaException pe){
            throw new NegocioException("Erro ao pesquisar aluno pela matricula - " +pe.getMessage());
        }
    }

    private String validarDados(AlunoVO alunoVO){
        String mensagemErros = "";
        if(alunoVO.getNome() == null || alunoVO.getNome().length() == 0){
            mensagemErros += "Nome do aluno nao pode ser vazio";
        }

        if(alunoVO.getNomeMae() == null || alunoVO.getNomeMae().length() == 0){
            mensagemErros += "\nNome da mae nao pode ser vazio";
        }

        if(alunoVO.getNomePai() == null || alunoVO.getNomePai().length() == 0){
            mensagemErros += "\nNome do pai nao pode ser vazio";
        }

        if(alunoVO.getSexo() == null){
            mensagemErros += "\nSexo nao pode ser vazio";
        }

        if(alunoVO.getEndereco().getLogradouro() == null || alunoVO.getEndereco().getLogradouro().length() == 0){
            mensagemErros += "\nLogradouro nao pode ser vazio";
        }

        if(alunoVO.getEndereco().getNumero() <= 0){
            mensagemErros += "\nNumero deve ser maior que zero";
        }

        if(alunoVO.getEndereco().getBairro() == null || alunoVO.getEndereco().getBairro().length() == 0){
            mensagemErros += "\nBairro nao pode ser vazio";
        }

        if(alunoVO.getEndereco().getCidade() == null || alunoVO.getEndereco().getCidade().length() == 0){
            mensagemErros += "\nCidade nao pode ser vazio";
        } 
        
        if(alunoVO.getEndereco().getUf() == null){
            mensagemErros += "\nUF nao pode ser vazio";
        }
        
        return mensagemErros;
    } 

}
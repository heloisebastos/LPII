package ifmt.cba.persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ifmt.cba.vo.AlunoVO;
import ifmt.cba.vo.EnumSexo;
import ifmt.cba.vo.EnumUF;

public class AlunoDAO extends DAO {
    private static PreparedStatement comandoIncluir;
    private static PreparedStatement comandoAlterar;
    private static PreparedStatement comandoExcluir;
    private static PreparedStatement comandoBuscaMatricula;

    public AlunoDAO(ConexaoBD conexao) throws PersistenciaException{
        super(conexao);
        try{
            comandoIncluir = conexao.getConexao().prepareStatement("INSERT INTO aluno (nome, nomemae, nomepai, sexo, " + "logradouro, numero, bairro, cidade, uf) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            comandoAlterar = conexao.getConexao().prepareStatement("UPDATE aluno SET nome=?, nomemae=?, nomepai=?, sexo=?," + "logradouro=?, numero=?, bairro=?, cidade=?, uf=? WHERE matricula=?");
            comandoExcluir = conexao.getConexao().prepareStatement("DELETE FROM aluno WHERE matricula=?");
            comandoBuscaMatricula = conexao.getConexao().prepareStatement("SELECT * FROM aluno WHERE matricula=?");
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao incluir novo aluno - " + sqle.getMessage());
        }
    }

    public int incluir(AlunoVO alunoVO) throws PersistenciaException{
        int retorno = 0;
        try{
            comandoIncluir.setString(1, alunoVO.getNome());
            comandoIncluir.setString(2, alunoVO.getNomeMae());
            comandoIncluir.setString(3, alunoVO.getNomePai());
            comandoIncluir.setInt(4, alunoVO.getSexo().ordinal());
            comandoIncluir.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoIncluir.setInt(6, alunoVO.getEndereco().getNumero());
            comandoIncluir.setString(7, alunoVO.getEndereco().getBairro());
            comandoIncluir.setString(8, alunoVO.getEndereco().getCidade());
            comandoIncluir.setString(9, alunoVO.getEndereco().getUf().name());
            retorno = comandoIncluir.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao incluir aluno - " + sqle.getMessage());
        }
        return retorno;
    }

    public int  alterar(AlunoVO alunoVO) throws PersistenciaException{
        int retorno = 0;
        try{
            comandoAlterar.setString(1, alunoVO.getNome());
            comandoAlterar.setString(2, alunoVO.getNomeMae());
            comandoAlterar.setString(3, alunoVO.getNomePai());
            comandoAlterar.setInt(4, alunoVO.getSexo().ordinal());
            comandoAlterar.setString(5, alunoVO.getEndereco().getLogradouro());
            comandoAlterar.setInt(6, alunoVO.getEndereco().getNumero());
            comandoAlterar.setString(7, alunoVO.getEndereco().getBairro());
            comandoAlterar.setString(8, alunoVO.getEndereco().getCidade());
            comandoAlterar.setString(9, alunoVO.getEndereco().getUf().name());
            comandoAlterar.setInt(10, alunoVO.getMatricula());
            retorno = comandoAlterar.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao alterar aluno - " + sqle.getMessage());
        }
        return retorno;
    }

    public int excluir(int matricula) throws PersistenciaException{
        int retorno = 0;
        try{
            comandoExcluir.setInt(1, matricula);
            retorno = comandoExcluir.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao excluir o aluno - " + sqle.getMessage());
        }
        return retorno;
    }

    public AlunoVO buscaPorMatricula(int matricula) throws PersistenciaException{
        AlunoVO alu = null;
        try{
            comandoBuscaMatricula.setInt(1, matricula);
            ResultSet resultado = comandoBuscaMatricula.executeQuery();
            if(resultado.next()){
                alu = this.montaAlunoVO(resultado);
            }
        }catch(Exception ex){
            throw new PersistenciaException("Erro na selecao por codigo - " + ex.getMessage());
        }
        return alu;
    }

    public List<AlunoVO> buscaPorNome(String nome) throws PersistenciaException{
        List<AlunoVO> listaAluno = new ArrayList<>();
        AlunoVO alu = null;
        // Pergutar p/ o professor sobre essa linha
        String comandoSQL = "SELECT * FROM aluno WHERE UPPER(nome) LIKE '" + nome.trim().toUpperCase() + "%' ORDER BY NOME LIMIT 10";
        try{
            PreparedStatement comando = conexao.getConexao().prepareStatement(comandoSQL);
            ResultSet resultado = comando.executeQuery();
            while(resultado.next()){
                alu = this.montaAlunoVO(resultado);
                listaAluno.add(alu);
            }
            comando.close();
        }catch(Exception ex){
            throw new PersistenciaException("Erro na selecao por nome - " + ex.getMessage());
        }
        return listaAluno;
    }

    private AlunoVO montaAlunoVO(ResultSet resultado) throws PersistenciaException{
        AlunoVO alu = new AlunoVO();
        if(resultado != null){
            try{
                alu.setMatricula(resultado.getInt("matricula"));
                alu.setNome(resultado.getString("nome").trim());
                alu.setNomeMae(resultado.getString("nomemae"));
                alu.setNomePai(resultado.getString("nomepai"));
                alu.setSexo(EnumSexo.values()[resultado.getInt("sexo")]);
                alu.getEndereco().setLogradouro(resultado.getString("logradouro"));
                alu.getEndereco().setBairro(resultado.getString("bairro"));
                alu.getEndereco().setCidade(resultado.getString("cidade"));
                alu.getEndereco().setUf(EnumUF.valueOf(resultado.getString("uf")));
            }catch(Exception ex){
                throw new PersistenciaException("Erro ao acessar os dados do resultado");
            }
        }
        return alu;
    }

}
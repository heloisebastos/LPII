package ifmt.cba.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ifmt.cba.util.FabricaConexao;
import ifmt.cba.vo.CursoVO;

public class CursoDAO {
    private Connection conexao;
    private PreparedStatement comandoInclusao;
    private PreparedStatement comandoAlteracao;
    private PreparedStatement comandoExclusao;
    private PreparedStatement comandoSelecaoCodigo;
    private PreparedStatement comandoSelecaoNome;

    public CursoDAO() throws PersistenciaException{
        try{
            this.conexao = FabricaConexao.obterConexao();
            this.comandoInclusao = conexao.prepareStatement("INSERT INTO curso (nome,cargaHoraria, numSemestre) VALUES(?, ?, ?)");
            this.comandoAlteracao = conexao.prepareStatement("UPDATE curso SET nome =?, cargaHoraria=?, numSemestre=? WHERE codigo=?");
            this.comandoExclusao = conexao.prepareStatement("DELETE FROM curso WHERE codigo=?");
            this.comandoSelecaoCodigo = conexao.prepareStatement("SELECT * FROM curso WHERE codigo=?");
            this.comandoSelecaoNome = conexao.prepareStatement("SELECT * FROM curso WHERE upper(nome) LIKE ?");
        }catch(Exception ex){
            throw new PersistenciaException("Erro ao preparar a persistencia - " +ex.getMessage());
        }
    }

    public void incluir(CursoVO cursoVO) throws PersistenciaException{
        try{
            this.comandoInclusao.setString(1, cursoVO.getNome());
            this.comandoInclusao.setInt(2, cursoVO.getCargaHoraria());
            this.comandoInclusao.setInt(3, cursoVO.getNumSemestre());
            this.comandoInclusao.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao incluir curso - " +sqle.getMessage());
        }
    }

    public void alterar(CursoVO cursoVO) throws PersistenciaException{
        try{
            this.comandoAlteracao.setString(1, cursoVO.getNome());
            this.comandoAlteracao.setInt(2, cursoVO.getCargaHoraria());
            this.comandoAlteracao.setInt(3, cursoVO.getNumSemestre());
            this.comandoAlteracao.setInt(4, cursoVO.getCodigo());
            this.comandoAlteracao.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao alterar curso - " +sqle.getMessage());
        }
    }

    public void excluir(int codigo) throws PersistenciaException{
        try{
            this.comandoExclusao.setInt(1, codigo);
            this.comandoExclusao.executeUpdate();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao excluir curso - " +sqle.getMessage());
        }
    }

    public CursoVO buscaPorCodigo(int codigo) throws PersistenciaException{
        CursoVO retorno = null;
        ResultSet resultado = null;
        try{
            this.comandoSelecaoCodigo.setInt(1, codigo);
            resultado = this.comandoSelecaoCodigo.executeQuery();
            if(resultado.next()){
                retorno = this.montaVO(resultado);
            }
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao selecionar curso por codigo - " +sqle.getMessage());
        }
        return retorno;
    }

    public List<CursoVO> buscaPorNome(String nome) throws PersistenciaException{
        List<CursoVO> retorno = new ArrayList<CursoVO>();
        ResultSet resultado = null;
        try{
            this.comandoSelecaoNome.setString(1, "%" + nome.toUpperCase() + "%");
            resultado = this.comandoSelecaoNome.executeQuery();
            while(resultado.next()){
                retorno.add(this.montaVO(resultado));
            }
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao selecionar curso por nome - " +sqle.getMessage());
        }
        return retorno;
    }

    public List<CursoVO> buscaTodos() throws PersistenciaException{
        List<CursoVO> retorno = new ArrayList<CursoVO>();
        ResultSet resultado = null;
        try{
            Statement comandoBuscaTodos = this.conexao.createStatement();
            resultado = comandoBuscaTodos.executeQuery("Select * FROM curso ORDER BY codigo");
            while(resultado.next()){
                retorno.add(this.montaVO(resultado));
            }
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao selecionar curso por nome - " +sqle.getMessage());
        }
        return retorno;
    }

    public CursoVO montaVO(ResultSet resultado) throws PersistenciaException{
        CursoVO cursoVOTemp = new CursoVO();
        if(resultado != null){
            try{
                cursoVOTemp.setCodigo(resultado.getInt("codigo"));
                cursoVOTemp.setNome(resultado.getString("nome"));
                cursoVOTemp.setCargaHoraria(resultado.getInt("cargaHoraria"));
                cursoVOTemp.setNumSemestre(resultado.getInt("numSemestre"));
            }catch(SQLException sqle){
                throw new PersistenciaException("Erro no MOR de curso");
            }
        }
        return cursoVOTemp;
    }

    public void desconectar() throws PersistenciaException{
        try{
            this.comandoInclusao.close();
            this.comandoAlteracao.close();
            this.comandoExclusao.close();
            this.comandoSelecaoCodigo.close();
            this.comandoSelecaoNome.close();
            this.conexao.close();
        }catch(SQLException sqle){
            throw new PersistenciaException("Erro ao desconectar com o banco de dados - " + sqle.getMessage());
        }
    }
}
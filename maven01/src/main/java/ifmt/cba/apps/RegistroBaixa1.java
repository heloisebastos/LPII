package ifmt.cba.apps;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

import ifmt.cba.util.FabricaConexao;

public class RegistroBaixa1 {

    private static Connection conexao= null;

    private static enum MotivoEnum {
        VENCIMENTO,DEFEITO
    };

    static {
        try {
            conexao = FabricaConexao.obterConexao();
            
        } catch (Exception exp) {
            System.out.println("Erro ao conectar no banco de dados");
        }
    }

    public static void main (String args[]){
        PreparedStatement comandoRegistroBaixa;
        PreparedStatement comandoBaixaEstoque;
        PreparedStatement comandpSelecaoProduto;
        int estoqueAtualProduto= 0;

        Map <String,Integer> listaProdutos = obterProdutos();

        MotivoEnum motivo = (MotivoEnum) JOptionPane.showInputDialog(null,"Escolha o motivo da baixa de estoque","Motivos de baixa",JOptionPane.QUESTION_MESSAGE,null,motivoEnum.values(),MotivoEnum.values()[0]);

        java.sql.Date dataBaixa = new java.sql.Date(Calendar.getInstance().getTimeInMillis());

        int quantidadeBaixa = Integer.parseInt(JOptionPne.showInputDialog ("Forneça  aquantidade a ser retiado do esotque do produto"));
        String nomeProduto = (String) JOptionPane.showInputDialog(null,"Escolha o produto","Produtos",JOptionPane.QUESTION_MESSAGE,null,listaProdutos.keySet().toArray(),listaProdutos.keySet().toArray() [0]);

        try {
            conexao.setAutoCommit (false);
            comandoRegistroBaixa = conexao.prepareStatement ("INSERT INTO registrobaixa (motivo,data,quantidade,produto)" + "VALUES (?,?,?,?)");
            comandoRegistroBaixa.setInt(1,motivo.ordinal());
            comandoRegistroBaixa.setDate(2,dataBaixa);
            comandoRegistroBaixa.setFloat(3, quantidadeBaixa);
            comandoRegistroBaixa.setInt(4, codigoProduto);
            comandoRegistroBaixa.executeUpdate(); //inclusão do registro de baixa
            
            comandoSelecaoProduto = conexao.prepareStatement ("SELECT estoque FROM produto WHERE codigo = ? ");
            comandoSelecaoProduto.setInt(1,codigoProduto);
            ResultSet resultado = comandoSelcaoProduto.executeQuery ();

            if (resultado.next()) {
                estoqueAtualProduto = resultado.getInt("estoque");
            }
       
        } catch (SQLException sql){
            System.out.println("Erro no registro de baixa de estoque" + sql.toString());

        }

    }









}

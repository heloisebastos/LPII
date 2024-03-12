package ifmt.cba.execucao;

import java.util.List;

import javax.swing.JOptionPane;

import ifmt.cba.negocio.AlunoNegocio;
import ifmt.cba.negocio.NegocioException;
import ifmt.cba.vo.AlunoVO;
import ifmt.cba.vo.EnumSexo;
import ifmt.cba.vo.EnumUF;

public class Principal {

    private static AlunoNegocio alunoNegocio;
    
    @SuppressWarnings("incomplete-switch")
    public static void main(String[] args){
        try{
            alunoNegocio = new AlunoNegocio();
        }catch(NegocioException ne){
            System.out.println("Camada de negocio e persistencia nao iniciada - " +ne.getMessage());
        }

        if(alunoNegocio != null){
            EnumMenu opcao = EnumMenu.Sair;
            do{
                try{
                    opcao = exibirMenu();
                    switch(opcao){
                        case IncluirAluno:
                            incluirAluno();
                            JOptionPane.showMessageDialog(null, "Inclusao realizada com sucesso");
                            break;
                        case AlterarAluno:
                            alterarAluno();
                            JOptionPane.showMessageDialog(null, "Alteracao realizada com sucesso");
                            break;
                        case ExcluirAluno:
                            excluirAluno();
                            JOptionPane.showMessageDialog(null, "Exclusao realizada com sucesso");
                            break;
                        case PesqMatricula:
                            pesquisaPorMatricula();
                            break;
                        case PesqNome:
                            pesquisarPorNome(); 
                            //JOptionPane.showMessageDialog(null, "Busca por nome realizada com sucesso");
                        case Sair:
                            System.exit(0);  
                            break;              
                    }
                }catch(NegocioException ne){
                    System.out.println("Operacao nao realizada corretamente - " +ne.getMessage());
                }
            }while(opcao != EnumMenu.Sair); 
        }
        System.exit(0);
    }

    //Incluir um novo aluno na base de dados
    private static void incluirAluno() throws NegocioException{
        AlunoVO alunoTemp = lerDados();
        alunoNegocio.inserir(alunoTemp);
    }

    //alteração dos dados de um aluno por meio da matricula fornecida
    private static void alterarAluno() throws NegocioException{
        int matricula = 0;
        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matricula do aluno", "Leitura de dados", JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao insconsistente - " +ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if(alunoVO != null){
            AlunoVO alunoTemp = lerDados(alunoVO);
            alunoNegocio.alterar(alunoTemp);
            //JOptionPane.showMessageDialog(null, "Busca por matricula realizada com sucesso");
        }else{
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
    }

    //exclusao do aluno por meio da matricula fornecida
    private static void excluirAluno() throws NegocioException{
        int matricula = 0;
        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null, "Forneca a matricula do aluno", "Leitura de dados", JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Digitacao insconsistente - " +ex.getMessage());
        }

        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if(alunoVO != null){
            alunoNegocio.excluir(alunoVO);
        }else{
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
    }

    private static void pesquisaPorMatricula() throws NegocioException{
        int matricula = 0;
        try{
            matricula = Integer.parseInt(JOptionPane.showInputDialog(null,"Forneca a matricula do aluno", "Leitura de dados", JOptionPane.QUESTION_MESSAGE));
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Digitacao inconsistente - " +ex.getMessage());
        }
        AlunoVO alunoVO = alunoNegocio.pesquisaMatricula(matricula);
        if(alunoVO != null){
            mostrarDados(alunoVO);
        }else{
            JOptionPane.showMessageDialog(null,"Aluno nao localizado");
        }
    }

    private static void pesquisarPorNome() throws NegocioException{
        String nome = JOptionPane.showInputDialog(null,"Forneca o nome do aluno", "Leitura de dados", JOptionPane.QUESTION_MESSAGE);
        if(nome != null){
            List<AlunoVO> listaAlunoVO = alunoNegocio.pesquisaParteNome(nome);
            if(listaAlunoVO.size() > 0){
                for(AlunoVO alunoVO : listaAlunoVO){
                    mostrarDados(alunoVO);
                }
            }else{
                JOptionPane.showMessageDialog(null,"Aluno nao localizado");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Nome nao pode ser nulo");
        }
    }

    private static void mostrarDados(AlunoVO alunoVO){
        if(alunoVO != null){
            System.out.println("Matricula: " +alunoVO.getMatricula());
            System.out.println("Nome: " +alunoVO.getNome());
            System.out.println("Nome da mae: " +alunoVO.getNomeMae());
            System.out.println("Nome do pai: " +alunoVO.getNomePai());
            System.out.println("Sexo: " +alunoVO.getSexo().name());
            if(alunoVO.getEndereco() != null){
                System.out.println("Logradouro: " +alunoVO.getEndereco().getLogradouro());
                System.out.println("Numero: " +alunoVO.getEndereco().getNumero());
                System.out.println("Bairro: " +alunoVO.getEndereco().getBairro());
                System.out.println("Cidade: " +alunoVO.getEndereco().getCidade());
                System.out.println("UF: " +alunoVO.getEndereco().getUf().name());
                System.out.println("----------------------------------------------------------------");
            }            
        }
    }

    private static AlunoVO lerDados(AlunoVO alunoTemp){
        String nome, nomeMae, nomePai, logradouro, bairro, cidade;
        int numero;
        EnumSexo sexo;
        EnumUF uf;
        try{
            nome = JOptionPane.showInputDialog("Forneca o nome do aluno", alunoTemp.getNome().trim());
            alunoTemp.setNome(nome);
            nomeMae = JOptionPane.showInputDialog("Forneca o nome da mae", alunoTemp.getNomeMae().trim());
            alunoTemp.setNomeMae(nomeMae);
            nomePai = JOptionPane.showInputDialog("Forneca o nome do pai", alunoTemp.getNomePai().trim());
            alunoTemp.setNomePai(nomePai);
            sexo = (EnumSexo) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Leitura de dados", JOptionPane.QUESTION_MESSAGE, null, EnumSexo.values(), alunoTemp.getSexo());
            alunoTemp.setSexo(sexo);
            logradouro = JOptionPane.showInputDialog("Forneca o logradouro do endereco", alunoTemp.getEndereco().getLogradouro().trim());
            alunoTemp.getEndereco().setLogradouro(logradouro);
            numero = Integer.parseInt(JOptionPane.showInputDialog("Forneca o numero do endereco", alunoTemp.getEndereco().getNumero()));
            alunoTemp.getEndereco().setNumero(numero);
            bairro = JOptionPane.showInputDialog("Forneca o bairro do endereco", alunoTemp.getEndereco().getBairro().trim());
            alunoTemp.getEndereco().setBairro(bairro);
            cidade = JOptionPane.showInputDialog("Forneca a cidade do endereco", alunoTemp.getEndereco().getCidade().trim());
            alunoTemp.getEndereco().setCidade(cidade);
            uf = (EnumUF) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Leitura de dados", JOptionPane.QUESTION_MESSAGE, null, EnumUF.values(), alunoTemp.getEndereco().getUf());
            alunoTemp.getEndereco().setUF(uf);
        }catch(Exception ex){
            System.out.println("Digitacao inconsistente - " +ex.getMessage());
        }
        return alunoTemp;
    }

    private static AlunoVO lerDados(){
        AlunoVO alunoTemp = new AlunoVO();
        return lerDados(alunoTemp);
    }

    private static EnumMenu exibirMenu(){
        EnumMenu opcao;
        opcao = (EnumMenu) JOptionPane.showInputDialog(null, "Escolha uma opcao", "Menu", JOptionPane.QUESTION_MESSAGE, null, EnumMenu.values(), EnumMenu.values()[0]);
        if(opcao == null){
            JOptionPane.showMessageDialog(null, "Nenhuma opcao escolhida");
            opcao = EnumMenu.Sair;
        }
        return opcao;
    }
}
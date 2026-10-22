import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Objects;
import java.util.Scanner;

/**
 * Classe com as rotinas de entrada e saída do projeto
 * @author Hilario Seibel Junior e <seu nome aqui>
 */
public class Entrada {

    /**
     * Se houver um arquivo input.txt na pasta em que o projeto está sendo executado,
     * define que o Scanner vai ler deste arquivo e não do teclado.
     * Se o arquivo não existir, define que o Scanner vai ler da entrada padrão (teclado)
     * NÃO ALTERE O ESTE CODIGO!!!!
     * @return Um objeto da classe Scanner de onde a entrada será lida
     */
    public static Scanner abrirEntrada() {
        Scanner input = null;
        try {
            // Se houver um arquivo input.txt, o Scanner vai ler dele.
            input = new Scanner(new FileInputStream("input.txt")).useLocale(Locale.US);
        } catch (FileNotFoundException e) {
            // Caso contrário, vai ler do teclado.
            // Locale.US para que o Java sempre leia double com "pontos" ao invés de "vírgulas"
            input = new Scanner(System.in).useLocale(Locale.US);
        }
        finally {
            return input;
        }
    }

    /**
     * Fecha o Scanner antes de sair do programa.
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     */
    public static void fecharEntrada(Scanner input) {
        input.close();
    }

    /**
     * Faz a leitura de uma linha inteira
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return Uma String contendo a linha que foi lida
     */
    public static String lerLinha(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma e retorna esta linha
        System.out.print(msg);
        String linha = input.nextLine();
        return linha;
    }

    /**
     * Faz a leitura de um número inteiro
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para int
     */
    public static int lerInteiro(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um inteiro e retorna este inteiro
        String linha = Entrada.lerLinha(msg, input);
        return Integer.parseInt(linha);
    }

    /**
     * Faz a leitura de um double
     * @param msg: Mensagem que será exibida ao usuário
     * @param input: Um objeto da classe Scanner de onde a entrada está sendo lida
     * @return O número digitado pelo usuário convertido para double
     */
    private static double lerDouble(String msg, Scanner input) {
        // Imprime uma mensagem ao usuário, lê uma linha contendo um double e retorna este double
        String linha = Entrada.lerLinha(msg, input);
        return Double.parseDouble(linha);
    }

    /**
     * Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
     * @return Inteiro contendo a opção escolhida pelo usuário
     */
    public static int menu(Scanner input) {
        // Imprime o menu principal, lê a opção escolhida pelo usuário e retorna a opção selecionada.
        String msg = "*********************\n" +
                "Escolha uma opção:\n" +
                "1) Cadastro\n" +
                "2) Relatórios\n" +
                "0) Sair\n";

        int op = Entrada.lerInteiro(msg, input);

        while (op < 0 || op > 2) {
            System.out.println("Opção inválida. Tente novamente: ");
            op = Entrada.lerInteiro(msg, input);
        }

        return op;
    }

    public static void menu_cadastro(Sistema s, Scanner input) {
        String msg = "*********************\n" +
                "1) Cadastrar Área\n" +
                "2) Cadastrar Curso\n" +
                "3) Cadastrar Aluno Ingressante\n" +
                "4) Cadastrar Aluno Concluinte\n" +
                "5) Cadastrar Resposta de Questionário\n" +
                "6) Cadastrar Resultado de Prova\n" +
                "0) Voltar\n";

        int op = Entrada.lerInteiro(msg, input);

        if (op == 0) return;

        switch(op) {
            case 1:
                Entrada.cadArea(s, input);
                break;
            case 2:
                Entrada.cadCurso(s, input);
                break;
            case 3:
                Entrada.cadIngressante(s, input);
                break;
            case 4:
                Entrada.cadConcluinte(s, input);
                break;
            case 5:
                Entrada.cadResposta(s, input);
                break;
            case 6:
                Entrada.cadProva(s, input);
                break;
            default:
                System.out.println("Opção Inválida.");
        }
    }

    public static void menu_relatorios(Sistema s, Scanner input) {
        String msg = "*********************\n" +
                "1) Listar Resultados por Conceito\n" +
                "2) Listar Resultados por Área\n" +
                "3) Listar Alunos Irregulares\n\n" +
                "0) Voltar\n";

        int op = Entrada.lerInteiro(msg, input);

        if (op == 0) return;

        switch(op) {
            case 1:
                Entrada.resConceito(s, input);
                break;
            case 2:
                Entrada.resArea(s, input);
                break;
            case 3:
                Entrada.lisIrregular(s, input);
                break;
            default:
                System.out.println("Opção Inválida.");
        }
    }

    //ENTRADAS DE CADASTRO
    public static void cadArea(Sistema s, Scanner input) {
        String nome = Entrada.lerLinha("\nDigite o nome da área: ", input);
        String codigo = Entrada.lerLinha("\nDigite o código da área: ", input);

        s.cadastrarArea(new Area(nome, codigo));
        System.out.println("\nÁrea cadastrada com sucesso!");
    }
    public static void cadCurso(Sistema s, Scanner input) {
        int e = 0;
        String nome = Entrada.lerLinha("\nDigite o nome do curso: ", input);
        String codigo = Entrada.lerLinha("\nDigite o código do curso: ", input);
        System.out.println("\nÁrea cadastradas:");
        for(Area a : s.getAreas()){
            System.out.println(a.toString());
        }
        String codA = Entrada.lerLinha("\nDigite o código da área do curso: ", input);
        Area a2 = null;
        for(Area a : s.getAreas()){
            if(Objects.equals(codA, a.getCodigo())){
                a2 = a;
                e+=1;
                break;
            }
        }
        if(e == 0){
            System.out.println("Área não existe");
            return;
        }
        s.cadastrarCurso(new Curso(codigo, nome), a2);
        System.out.println("\nCurso cadastrado com sucesso!");
    }
    public static void cadIngressante(Sistema s, Scanner input) {
        String nome = Entrada.lerLinha("\nDigite o nome do ingressante: ", input);
        String matricula = Entrada.lerLinha("\nDigite a matricula do ingressante: ", input);
        int semestre = Entrada.lerInteiro("\nDigite o semestre de ingresso: ", input);
        System.out.println("\nCursos cadastrados:");
        for(Curso c : s.getCursos()){
            System.out.println(c.toString());
        }
        String codA = Entrada.lerLinha("\nDigite o código do curso do aluno: ", input);
        Curso c2 = null;
        for(Curso c : s.getCursos()){
            if(Objects.equals(codA, c.getCodigo())){
                c2 = c;
            }
        }
        if(c2 == null){
            System.out.println("\nCurso não existe");
            return;
        }
        s.cadastrarAluno(c2, new Ingressante(nome,matricula,semestre));
        System.out.println("\nIngressante cadastrado com sucesso!");
    }
    public static void cadConcluinte(Sistema s, Scanner input) {
        String nome = Entrada.lerLinha("\nDigite o nome do ingressante: ", input);
        String matricula = Entrada.lerLinha("\nDigite a matricula do ingressante: ", input);
        System.out.println("\nCursos cadastrados:");
        for(Curso c : s.getCursos()){
            System.out.println(c.toString());
        }
        String codA = Entrada.lerLinha("\nDigite o código do curso do aluno: ", input);
        Curso c2 = null;
        for(Curso c : s.getCursos()){
            if(Objects.equals(codA, c.getCodigo())){
                c2 = c;
            }
        }
        if(c2 == null){
            System.out.println("\nCurso não existe");
            return;
        }
        s.cadastrarAluno(c2, new Concluinte(nome,matricula));
        System.out.println("\nConcluinte cadastrado com sucesso!");
    }
    public static void cadResposta(Sistema s, Scanner input){
        int e = 0;
        System.out.println("Alunos cadastrados:");
        for(Aluno a : s.getAlunos()){
            if(a instanceof Ingressante i){
                System.out.println(i.toString());
            }
            else if (a instanceof Concluinte c) {
                System.out.println(c.toString());
            }
        }
        String mat = Entrada.lerLinha("\nDigite a matrícula do aluno que respondeu ao questionário: ",input);
        for(Aluno a : s.getAlunos()){
            if(Objects.equals(mat, a.getMatricula())){
                a.cadastrarResposta();
                e = 1;
            }
        }
        if(e == 0){
            System.out.println("\nAluno não encontrado");
            return;
        }
        System.out.println("\nResposta cadastrada com sucesso!");
    }
    public static void cadProva(Sistema s, Scanner input){
        int e = 0;
        System.out.println("Concluintes cadastrados:");
        for(Aluno a : s.getAlunos()){
            if(a instanceof Concluinte c){
                System.out.println(c.toString());
            }
        }
        String mat = Entrada.lerLinha("Digite a matrícula do aluno que realizou a prova: ",input);
        for(Aluno a : s.getAlunos()){
            if(a instanceof Concluinte c){
                if(Objects.equals(mat, a.getMatricula())){
                    double n1 = Entrada.lerDouble("\nDigite o valor da nota de formação geral: ", input);
                    double n2 = Entrada.lerDouble("\nDigite o valor da nota de conhecimentos específicos: ", input);
                    c.cadastrarProva(n1,n2);
                    e = 1;
                }
            }
        }
        if(e==0){
            System.out.println("\nAluno não encontrado");
            return;
        }
        System.out.println("\nProva cadastrada com sucesso!");
    }

    //ENTRADAS DE RELATORIO
    public static void resConceito(Sistema s, Scanner input){
        int desejado = Entrada.lerInteiro("Digite o conceito desejado (1 a 5): ", input);
        s.listarResultados(desejado);

    }
    public static void resArea(Sistema s, Scanner input){
        System.out.println("Áreas cadastradas: ");
        for(Area a : s.getAreas()){
            System.out.println(a.toString());
        }
        String nom = Entrada.lerLinha("Digite o nome da área: ", input);
        s.listarResultados(nom);
    }
    public static void lisIrregular(Sistema s, Scanner input){
        System.out.println("Alunos irregulares com o ENADE:");
        s.listarAlunosIrregulares();
    }
}
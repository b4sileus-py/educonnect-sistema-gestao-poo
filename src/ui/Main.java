package src.ui; // Porque este meu main.java está com esse erro de compilação? como resolver ?

import src.model.*;
import src.service.EscolaService;
import java.util.Scanner;

public class Main {

    private static EscolaService service = new EscolaService();
    private static Scanner scanner = new Scanner(System.in);

    private static Usuario usuarioLogado;

    // ========================================================================
    // MAIN
    // ========================================================================
    public static void main(String[] args) {

        carregarDadosIniciais();  // <<==== PRÉ-CADASTRO COMPLETO

        realizarLogin(); // login inicial

        boolean executando = true;

        while (executando) {

            if (usuarioLogado instanceof Administrador) {
                executando = menuAdministrador();
            } 
            else if (usuarioLogado instanceof Professor) {
                executando = menuProfessor();
            } 
            else if (usuarioLogado instanceof Aluno) {
                executando = menuAluno();
            } 
            else {
                System.out.println("Tipo de usuário desconhecido.");
                executando = false;
            }
        }

        System.out.println("Sistema finalizado. Até a próxima!");
    }

    // ========================================================================
    // LOGIN
    // ========================================================================
    private static void realizarLogin() {
        boolean autenticado = false;

        while (!autenticado) {
            System.out.println("\n ┌───────────────────────────────────────┐");
            System.out.println("| --------- Terminal EduConnect --------- |");
            System.out.println(" └───────────────────────────────────────┘\n");

            System.out.print("Login: ");
            String login = scanner.nextLine();

            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            Usuario candidato = service.buscarUsuarioPorLogin(login);

            if (candidato != null && candidato.autenticar(login, senha)) {
                usuarioLogado = candidato;
                System.out.println("\nBem-vindo, " + usuarioLogado.getNome() + "!");
                autenticado = true;
            } else {
                System.out.println("Credenciais inválidas. Tente novamente.\n");
            }
        }
    }

    // ========================================================================
    // PRÉ-CADASTRO AUTOMÁTICO
    // ========================================================================
    private static void carregarDadosIniciais() {

        System.out.println("\n[PRÉ-CADASTRO] Inicializando dados...\n");

        // ---------------- CURSOS ----------------
        Curso c1 = service.cadastrarCursoEAD("Análise e Desenvolvimento de Sistemas", "ADS", 2460, "Portal EduConnect");
        Curso c2 = service.cadastrarCursoEAD("Pedagogia", "PDG", 3250, "Portal EduConnect");
        Curso c3 = service.cadastrarCursoPresencial("Arquitetura", "ARQ", 4300, "SL-101");
        Curso c4 = service.cadastrarCursoEAD("Ciência da Computação", "CCOMP", 3000, "Portal EduConnect");
        Curso c5 = service.cadastrarCursoPresencial("Engenharia Civil", "ECIV", 4200, "BL-22");

        // ---------------- PROFESSORES ----------------
        Professor p1 = service.cadastrarProfessor("Edmar Senne", "ed.senne85", "TheDark.N1ght", "Desenvolvimento de Sistemas", "PROF01");
        Professor p2 = service.cadastrarProfessor("Juliana Moura", "ju.moura72", "M0onlight.xx", "Engenharia de Software", "PROF02");
        Professor p3 = service.cadastrarProfessor("Carlos Menezes", "carlos.mnz81", "IronRoots_7", "Arquitetura e Urbanismo", "PROF03");
        Professor p4 = service.cadastrarProfessor("Fernanda Ribeiro", "fer.rib22", "T3rraNova!21", "Pedagogia", "PROF04");
        Professor p5 = service.cadastrarProfessor("Ricardo Lima", "ric.lima73", "StoneWall#8", "Engenharia Civil", "PROF05");

        // ---------------- ALUNOS ----------------
        Aluno a1 = service.cadastrarAluno("Roberto Siqueira", "rob.siq94", "B4sileus.oy", "2025-001", c1);
        Aluno a2 = service.cadastrarAluno("Ana Ferreira", "ana.fer99", "Sunflow3r@21", "2025-002", c2);
        Aluno a3 = service.cadastrarAluno("Marcos Rocha", "marcos.r88", "R00tBrain#9", "2025-003", c3);
        Aluno a4 = service.cadastrarAluno("Luiza Andrade", "lu.andra01", "BlueSky_55", "2025-004", c4);
        Aluno a5 = service.cadastrarAluno("Bruno Martins", "bruno.mt22", "WolfLine77!", "2025-005", c5);

        // ---------------- TURMAS ----------------
        service.criarTurma("ADS-A", p1, c1);
        service.criarTurma("PDG-01", p4, c2);
        service.criarTurma("ARQ-M1", p3, c3);
        service.criarTurma("CCOMP-2N", p2, c4);
        service.criarTurma("ECIV-T3", p5, c5);

        // ---------------- MATRÍCULAS (DISTRIBUÍDAS) ----------------
        service.adicionarAlunoTurma("2025-001", "ADS-A");     // Roberto → ADS
        service.adicionarAlunoTurma("2025-002", "PDG-01");    // Ana → Pedagogia
        service.adicionarAlunoTurma("2025-003", "ARQ-M1");    // Marcos → Arquitetura
        service.adicionarAlunoTurma("2025-004", "ADS-A");     // Luiza → ADS (2 na mesma turma)
        service.adicionarAlunoTurma("2025-005", "ECIV-T3");   // Bruno → Civil

        // ---------------- AVALIAÇÕES ----------------
        service.registrarAvaliacao("2025-001", "Prova POO", 9.5);
        service.registrarAvaliacao("2025-002", "Relatório de Pesquisa", 8.7);
        service.registrarAvaliacao("2025-003", "Projeto Maquete", 9.0);
        service.registrarAvaliacao("2025-004", "Estruturas de Dados", 7.8);
        service.registrarAvaliacao("2025-005", "Cálculo I", 8.3);

        System.out.println("[PRÉ-CADASTRO] Dados carregados com sucesso!\n");
    }

    // ========================================================================
    // MENUS
    // ========================================================================
    private static boolean menuAdministrador() {
        System.out.println("\n ----------- MENU ADMINISTRADOR ----------- ");
        System.out.println("1) Cadastrar Aluno");
        System.out.println("2) Cadastrar Professor");
        System.out.println("3) Cadastrar Curso");
        System.out.println("4) Criar Turma");
        System.out.println("5) Matricular Aluno em Turma");
        System.out.println("6) Registrar Avaliação");
        System.out.println("7) Relatórios Completos");
        System.out.println("8) Trocar Usuário");
        System.out.println("0) Sair");
        System.out.print("> ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1 -> cadastrarAluno();
            case 2 -> cadastrarProfessor();
            case 3 -> cadastrarCurso();
            case 4 -> criarTurma();
            case 5 -> matricularAluno();
            case 6 -> registrarAvaliacao();
            case 7 -> gerarRelatoriosAdmin();
            case 8 -> { realizarLogin(); return true; }
            case 0 -> { return false; }
            default -> System.out.println("Opção inválida.");
        }
        return true;
    }

    private static boolean menuProfessor() {
        System.out.println("\n=== MENU PROFESSOR ===");
        System.out.println("1) Registrar Avaliação");
        System.out.println("2) Relatórios de Turmas");
        System.out.println("5) Listar Tudo");
        System.out.println("8) Trocar Usuário");
        System.out.println("0) Sair");
        System.out.print("> ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1 -> registrarAvaliacao();
            case 2 -> gerarRelatoriosProfessor();
            case 5 -> gerarRelatoriosAdmin();
            case 8 -> { realizarLogin(); return true; }
            case 0 -> { return false; }
            default -> System.out.println("Opção inválida.");
        }
        return true;
    }

    private static boolean menuAluno() {
        System.out.println("\n=== MENU ALUNO ===");
        System.out.println("1) Ver Minhas Avaliações");
        System.out.println("2) Ver Meu Curso");
        System.out.println("5) Listar Tudo");
        System.out.println("8) Trocar Usuário");
        System.out.println("0) Sair");
        System.out.print("> ");

        int opcao = lerInteiro();

        switch (opcao) {
            case 1 -> mostrarAvaliacoesAluno();
            case 2 -> mostrarCursoAluno();
            case 5 -> gerarRelatoriosAdmin();
            case 8 -> { realizarLogin(); return true; }
            case 0 -> { return false; }
            default -> System.out.println("Opção inválida.");
        }
        return true;
    }

    // ========================================================================
    // UTILITÁRIOS
    // ========================================================================
    private static int lerInteiro() {
        try { return Integer.parseInt(scanner.nextLine()); }
        catch (Exception e) { return -1; }
    }

    // ========================================================================
    // CADASTROS
    // ========================================================================
    private static void cadastrarAluno() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Código do Curso (ou vazio): ");
        String cod = scanner.nextLine();

        Curso curso = null;
        if (!cod.isBlank()) {
            curso = service.cursoRepo.buscarPorCodigo(cod).orElse(null);
        }

        service.cadastrarAluno(nome, login, senha, matricula, curso);
        System.out.println("Aluno cadastrado!");
    }

    private static void cadastrarProfessor() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Login: ");
        String login = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Especialidade: ");
        String esp = scanner.nextLine();

        System.out.print("Registro: ");
        String reg = scanner.nextLine();

        service.cadastrarProfessor(nome, login, senha, esp, reg);
        System.out.println("Professor cadastrado!");
    }

    private static void cadastrarCurso() {
        System.out.print("Nome do curso: ");
        String nome = scanner.nextLine();

        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        System.out.print("Carga horária: ");
        int carga = lerInteiro();

        System.out.println("Tipo: 1-Presencial | 2-EAD");
        int tipo = lerInteiro();

        if (tipo == 1) {
            System.out.print("Sala: ");
            String sala = scanner.nextLine();
            service.cadastrarCursoPresencial(nome, codigo, carga, sala);
        } else {
            System.out.print("Plataforma: ");
            String plat = scanner.nextLine();
            service.cadastrarCursoEAD(nome, codigo, carga, plat);
        }

        System.out.println("Curso cadastrado!");
    }

    private static void criarTurma() {
        System.out.print("Código da turma: ");
        String cod = scanner.nextLine();

        System.out.print("Registro do professor: ");
        String reg = scanner.nextLine();

        System.out.print("Código do curso: ");
        String cursoCod = scanner.nextLine();

        Professor professor = service.professorRepo.buscarPorRegistro(reg).orElse(null);
        Curso curso = service.cursoRepo.buscarPorCodigo(cursoCod).orElse(null);

        if (professor == null || curso == null) {
            System.out.println("Erro: professor ou curso não encontrado.");
            return;
        }

        service.criarTurma(cod, professor, curso);
        System.out.println("Turma criada!");
    }

    private static void matricularAluno() {
        System.out.print("Matrícula do aluno: ");
        String mat = scanner.nextLine();

        System.out.print("Código da turma: ");
        String cod = scanner.nextLine();

        boolean ok = service.adicionarAlunoTurma(mat, cod);

        System.out.println(ok ? "Aluno matriculado!" : "Erro ao matricular.");
    }

    private static void registrarAvaliacao() {
        System.out.print("Matrícula do aluno: ");
        String matricula = scanner.nextLine();

        System.out.print("Descrição: ");
        String desc = scanner.nextLine();

        System.out.print("Nota (0 a 10): ");
        double nota = Double.parseDouble(scanner.nextLine());

        boolean ok = service.registrarAvaliacao(matricula, desc, nota);

        System.out.println(ok ? "Avaliação registrada!" : "Erro ao registrar.");
    }

    // ========================================================================
    // RELATÓRIOS
    // ========================================================================
    private static void gerarRelatoriosAdmin() {
        System.out.println("\n============ RELATÓRIO DE ALUNOS ============");
        service.alunoRepo.listar().forEach(a -> System.out.println(a.gerarRelatorio()));

        System.out.println("\n========== RELATÓRIO DE PROFESSORES ==========");
        service.professorRepo.listar().forEach(p -> System.out.println(p.gerarRelatorio()));

        System.out.println("\n============ RELATÓRIO DE CURSOS ============");
        service.cursoRepo.listar().forEach(c -> System.out.println(c.gerarRelatorio()));

        System.out.println("\n============ RELATÓRIO DE TURMAS ============");
        service.turmaRepo.listar().forEach(t -> System.out.println(t.resumo()));
    }

    private static void gerarRelatoriosProfessor() {
        System.out.println("\n============ TURMAS (GERAL) ============");
        service.turmaRepo.listar().forEach(t -> System.out.println(t.resumo()));
    }

    // ========================================================================
    // FUNÇÕES DO ALUNO
    // ========================================================================
    private static void mostrarAvaliacoesAluno() {
        Aluno a = (Aluno) usuarioLogado;

        System.out.println("\n============ MINHAS AVALIAÇÕES ============");

        if (a.getAvaliacoes().isEmpty()) {
            System.out.println("Nenhuma avaliação registrada.");
            return;
        }

        a.getAvaliacoes().forEach(av ->
                System.out.println(av.getDescricao() + " - Nota: " + av.getNota())
        );
    }

    private static void mostrarCursoAluno() {
        Aluno a = (Aluno) usuarioLogado;

        System.out.println("\n=== MEU CURSO ===");
        if (a.getCurso() == null) {
            System.out.println("Não matriculado em nenhum curso.");
        } else {
            System.out.println(a.getCurso().gerarRelatorio());
        }
    }
}
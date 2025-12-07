package src.service;

import src.model.*;
import src.repository.*;

import java.util.Optional;

public class EscolaService {

    public final AlunoRepository alunoRepo = new AlunoRepository();
    public final ProfessorRepository professorRepo = new ProfessorRepository();
    public final CursoRepository cursoRepo = new CursoRepository();
    public final TurmaRepository turmaRepo = new TurmaRepository();

    public Aluno cadastrarAluno(String nome, String login, String senha, String matricula, Curso curso) {
        Aluno aluno = new Aluno(nome, login, senha, matricula, curso);
        alunoRepo.salvar(aluno);
        return aluno;
    }

    public Professor cadastrarProfessor(String nome, String login, String senha, String especialidade, String registro) {
        Professor professor = new Professor(nome, login, senha, especialidade, registro);
        professorRepo.salvar(professor);
        return professor;
    }

    public Curso cadastrarCursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        Curso curso = new CursoPresencial(nome, codigo, cargaHoraria, sala);
        cursoRepo.salvar(curso);
        return curso;
    }

    public Curso cadastrarCursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        Curso curso = new CursoEAD(nome, codigo, cargaHoraria, plataforma);
        cursoRepo.salvar(curso);
        return curso;
    }

    public Turma criarTurma(String codigoTurma, Professor professor, Curso curso) {
        Turma turma = new Turma(codigoTurma, professor, curso);
        turmaRepo.salvar(turma);
        return turma;
    }

    public boolean adicionarAlunoTurma(String matricula, String codigoTurma) {
        Optional<Aluno> alunoEncontrado = alunoRepo.buscarPorMatricula(matricula);
        Optional<Turma> turmaEncontrada = turmaRepo.buscarPorCodigo(codigoTurma);

        if (alunoEncontrado.isPresent() && turmaEncontrada.isPresent()) {
            turmaEncontrada.get().adicionarAluno(alunoEncontrado.get());
            return true;
        }
        return false;
    }

    public boolean registrarAvaliacao(String matricula, String descricao, double nota) {
        Optional<Aluno> alunoEncontrado = alunoRepo.buscarPorMatricula(matricula);
        if (!alunoEncontrado.isPresent()) return false;

        Avaliacao avaliacao = new Avaliacao(descricao);
        boolean notaValida = avaliacao.atribuirNota(nota);

        if (!notaValida) return false;

        alunoEncontrado.get().adicionarAvaliacao(avaliacao);
        return true;
    }

    // MÉTODO DA FASE 5 - Buscar usuário para autenticação
    public Usuario buscarUsuarioPorLogin(String login) {

        // ADMIN PADRÃO DO SISTEMA
        if (login.equals("admin")) {
            return new Administrador("Administrador", "admin", "123");
        }

        // BUSCA ALUNO POR LOGIN
        for (Aluno a : alunoRepo.listar()) {
            if (a.getLogin().equals(login)) return a;
        }

        // BUSCA O PROFESSOR POR LOGIN
        for (Professor p : professorRepo.listar()) {
            if (p.getLogin().equals(login)) return p;
        }

        return null;
    }
        // Busca usuário e valida senha
    public Usuario autenticar(String login, String senha) {
        Usuario u = buscarUsuarioPorLogin(login);
        if (u != null && u.autenticar(login, senha)) {
            return u;
        }
        return null;
    }

}

package src.model;

import java.util.ArrayList;
import java.util.List;

// A Turma conecta Curso, Professor e vários Alunos.
// Representa uma relação de agregação: os alunos existem sem depender da turma.
public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public String getCodigo() { return codigo; }

    public void adicionarAluno(Aluno aluno) {
        if (aluno != null && !listaAlunos.contains(aluno)) {
            listaAlunos.add(aluno);
        }
    }

    public boolean removerAluno(String matricula) {
        return listaAlunos.removeIf(a -> a.getMatricula().equals(matricula));
    }

    // Retorna resumo para relatórios
    public String resumo() {
        return "Turma " + codigo +
               " | Curso: " + (curso != null ? curso.getNome() : "N/A") +
               " | Professor: " + (professor != null ? professor.getNome() : "N/A") +
               " | Alunos: " + listaAlunos.size();
    }

    public Aluno buscarAluno(String matricula) {
        for (Aluno a : listaAlunos) {
            if (a.getMatricula().equals(matricula)) {
                return a;
            }
        }
        return null; // Não achou
    }
}


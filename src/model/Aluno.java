package src.model;

import java.util.ArrayList;
import java.util.List;

// Um aluno possui matrícula, pode estar associado a um curso e ter também várias avaliações.
public class Aluno extends Usuario { 
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha); // Reutiliza construtor da superclasse
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public Curso getCurso() { return curso; }

    public List<Avaliacao> getAvaliacoes() { return avaliacoes; }

    // Associa uma avaliação ao aluno
    public void adicionarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao != null) {
            avaliacoes.add(avaliacao);
        }
    }

    // Implementação personalizada do relatório para alunos
    @Override
    public String gerarRelatorio() {
        StringBuilder sb = new StringBuilder();

        sb.append("Aluno: ")
          .append(nome)
          .append(" | Matrícula: ")
          .append(matricula)
          .append(" | Curso: ")
          .append(curso != null ? curso.getNome() : "Não matriculado")
          .append("\nAvaliações:\n");

        for (Avaliacao a : avaliacoes) {
            sb.append(" - ").append(a.getDescricao())
              .append(": ").append(a.getNota()).append("\n");
        }

        return sb.toString();
    }
}
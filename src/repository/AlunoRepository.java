package src.repository;

import src.model.Aluno;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Responsável por armazenar e gerenciar objetos do tipo Aluno.
// Aqui usamos uma lista em memória (simulando um "banco de dados" temporário).
public class AlunoRepository {

    // Lista que guarda todos os alunos cadastrados
    private List<Aluno> alunos = new ArrayList<>();

    // Salva o aluno no "banco" (lista)
    public void salvar(Aluno aluno) {
        alunos.add(aluno);
    }

    // Retorna todos os alunos cadastrados (para relatórios, listagem, etc)
    public List<Aluno> listar() {
        return alunos;
    }

    // Busca aluno pela matrícula — útil para matrícula em turma ou lançar nota
    public Optional<Aluno> buscarPorMatricula(String matricula) {
        return alunos.stream()
                .filter(a -> a.getMatricula().equals(matricula))
                .findFirst();
    }
}


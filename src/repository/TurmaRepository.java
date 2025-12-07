package src.repository;

import src.model.Turma;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Armazena todas as turmas criadas no sistema.
public class TurmaRepository {

    private List<Turma> turmas = new ArrayList<>();

    public void salvar(Turma turma) {
        turmas.add(turma);
    }

    public List<Turma> listar() {
        return turmas;
    }

    // Localiza uma turma pelo código para poder matricular alunos nela
    public Optional<Turma> buscarPorCodigo(String codigo) {
        return turmas.stream()
                .filter(t -> t.getCodigo().equals(codigo))
                .findFirst();
    }
}

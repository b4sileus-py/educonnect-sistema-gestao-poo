package src.repository;

import src.model.Professor;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Repositório dedicado a armazenar professores.
// O padrão é o mesmo do AlunoRepository, mantendo consistência do projeto.
public class ProfessorRepository {

    private List<Professor> professores = new ArrayList<>();

    public void salvar(Professor professor) {
        professores.add(professor);
    }

    public List<Professor> listar() {
        return professores;
    }

    // Busca professor pelo registro profissional (identificador principal dele no sistema)
    public Optional<Professor> buscarPorRegistro(String registro) {
        return professores.stream()
                .filter(p -> p.getRegistro().equals(registro))
                .findFirst();
    }
}

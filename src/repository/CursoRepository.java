package src.repository;

import src.model.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Armazena cursos, sejam eles presenciais ou EAD.
// Como ambos herdam de Curso, não precisamos separar repositórios.
public class CursoRepository {

    private List<Curso> cursos = new ArrayList<>();

    public void salvar(Curso curso) {
        cursos.add(curso);
    }

    public List<Curso> listar() {
        return cursos;
    }

    // Busca curso pelo código, usado para criar turmas e associar alunos
    public Optional<Curso> buscarPorCodigo(String codigo) {
        return cursos.stream()
                .filter(c -> c.getCodigo().equals(codigo))
                .findFirst();
    }
}

package src.model;

// Curso presencial herda de Curso.
// Adiciona sala de aula como informação relevante.
public class CursoPresencial extends Curso {
    private String sala;

    public CursoPresencial(String nome, String codigo, int cargaHoraria, String sala) {
        super(nome, codigo, cargaHoraria);
        this.sala = sala;
    }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " [Presencial - Sala: " + sala + "]";
    }
}
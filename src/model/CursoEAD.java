package src.model;

// Curso EAD herda de Curso.
// Inclui a plataforma virtual utilizada.
public class CursoEAD extends Curso {
    private String plataforma;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        super(nome, codigo, cargaHoraria);
        this.plataforma = plataforma;
    }

    @Override
    public String detalharCurso() {
        return super.detalharCurso() + " [EAD - Plataforma: " + plataforma + "]";
    }
}
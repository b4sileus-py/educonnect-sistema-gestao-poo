package src.model;

// As subclasses (Presencial e EAD) vão especializar detalhes específicos.
public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public int getCargaHoraria() { return cargaHoraria; }

    // Método que poderá ser sobrescrito nas subclasses para detalhamento específico.
    public String detalharCurso() {
        return "Curso: " + nome + " (" + codigo + ") - " + cargaHoraria + "h";
    }

    public String gerarRelatorio() {
        return detalharCurso();
    }

}

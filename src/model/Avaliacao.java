package src.model;

// Encapsula a nota para evitar manipulação direta e garantir validação.
public class Avaliacao {
    private double nota; // Encapsulada para garantir regra de atribuição
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1; // Indica que ainda não foi atribuída
    }

    public double getNota() { return nota; }
    public String getDescricao() { return descricao; }

    // Atribuir nota só é permitido através deste método (encapsulamento)
    public boolean atribuirNota(double valor) {
        if (valor >= 0 && valor <= 10) {
            this.nota = valor;
            return true;
        }
        return false;
    }
}
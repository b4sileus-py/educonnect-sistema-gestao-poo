package src.model; // Administrador.java

// Administrador é um tipo especial de usuário.
// Vai poder futuramente ter permissões exclusivas no sistema.

public class Administrador extends Usuario {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public String gerarRelatorio() {
        return "Administrador: " + nome + " (login: " + login + ")";
    }
}
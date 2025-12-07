package src.model; // Administrador.java

// O único com acesso privilegiado. Terá acesso a todas as funções do sistema..
public class Administrador extends Usuario {

    public Administrador(String nome, String login, String senha) {
        super(nome, login, senha);
    }

    @Override
    public String gerarRelatorio() {
        return "Administrador: " + nome + " (login: " + login + ")";
    }

}

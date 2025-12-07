package src.model;

// Modelo base para Aluno, Professor e Administrador.
// Centraliza atributos comuns e a regra padrão de autenticação.

public abstract class Usuario implements Autenticacao {

    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }

    // Relatório padrão
    public String gerarRelatorio() {
        return "Usuário: " + nome + " (login: " + login + ")";
    }

    // Regra padrão de autenticação
    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }
}

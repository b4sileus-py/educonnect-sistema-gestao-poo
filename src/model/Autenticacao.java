package src.model;

// Interface que define um contrato de autenticação.
// Qualquer classe que implementar deve fornecer sua lógica de validação de login e senha.
public interface Autenticacao {
    boolean autenticar(String login, String senha);
}


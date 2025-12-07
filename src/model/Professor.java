package src.model;

// Possui registro profissional e especialidade, que são informações relevantes ao contexto acadêmico.
public class Professor extends Usuario {
    private String especialidade;
    private String registro;

    public Professor(String nome, String login, String senha, String especialidade, String registro) {
        super(nome, login, senha);
        this.especialidade = especialidade;
        this.registro = registro;
    }

    public String getEspecialidade() { return especialidade; }
    public String getRegistro() { return registro; }

    // Relatório focado nas informações profissionais
    @Override
    public String gerarRelatorio() {
        return "Professor: " + nome +
               " | Especialidade: " + especialidade +
               " | Registro: " + registro;
    }
}
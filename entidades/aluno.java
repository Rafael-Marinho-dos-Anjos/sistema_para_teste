package entidades;

public class aluno {
    private String nome;
    private String cpf;
    private String matricula;

    public aluno (String nome, String cpf, String matricula){
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
    }
    
    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
    public String getMatricula() { return this.matricula; }
}

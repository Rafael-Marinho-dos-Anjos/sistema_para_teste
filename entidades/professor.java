package entidades;

public class professor {
    private String nome;
    private String cpf;

    public professor (String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
}

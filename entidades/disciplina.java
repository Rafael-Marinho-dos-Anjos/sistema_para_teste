package entidades;

import java.util.ArrayList;

public class disciplina {
    private String nome;
    private String cod;
    private professor prof;
    private ArrayList<String> alunos = new ArrayList<>();
 
    public disciplina (String nome, String cod) throws IllegalArgumentException {
        this.nome = nome;
        this.cod = cod;
    }
 
    public disciplina (String nome, String cod, professor prof) throws IllegalArgumentException {
        this.nome = nome;
        this.cod = cod;
        this.prof = prof;
    }

    public void lotarProfessor(professor prof) {
        this.prof = prof;
    }

    public void matricularAluno(String matricula) {
        if (this.alunos.contains(matricula)) {
            throw new IllegalArgumentException("Aluno já matriculado na disciplina.");
        }
        this.alunos.add(matricula);
    }

    public void removerAluno(String matricula) {
        if (!this.alunos.contains(matricula)) {
            throw new IllegalArgumentException("Aluno não matriculado na disciplina.");
        }
        this.alunos.remove(matricula);
    }

    public String getNome() { return this.nome; }
    public String getCod() { return this.cod; }
    public professor getProf() { return this.prof; }
    public ArrayList<String> getAlunos() { return this.alunos; }
}

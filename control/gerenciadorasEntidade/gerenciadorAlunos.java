package control.gerenciadorasEntidade;

import java.security.KeyManagementException;
import java.util.ArrayList;
import java.util.HashMap;

import cadastro.cadastrarAluno;
import entidades.aluno;

public class gerenciadorAlunos {
    private static ArrayList<String> cpfs = new ArrayList<>();
    private static HashMap<String, aluno> alunos = new HashMap<String, aluno>();

    public void novoAluno() {
        try {
            String[] aluno = cadastrarAluno.realizarCadastro();

            if (cpfs.contains(aluno[1])) {
                throw new IllegalArgumentException("Já existe aluno com esse CPF.");
            }
            if (alunos.containsKey(aluno[2])) {
                throw new IllegalArgumentException("Já existe aluno com essa matrícula.");
            }
            
            alunos.put(aluno[2], new aluno(aluno[0], aluno[1], aluno[2]));
            cpfs.add(aluno[1]);
        }
        catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    public String[] listarAlunos() {
        ArrayList<String> alunos_ = new ArrayList<String>();
        for (String key : alunos.keySet()) {
            aluno aln = alunos.get(key);
            String cpf = aln.getCpf();
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(10, 11);
            alunos_.add(key + " - " + aln.getNome() + "\t CPF: " + cpf);
        }

        String[] alns = new String[alunos_.size()];
        for (int i=0; i < alunos_.size(); i++) {
            alns[i] = alunos_.get(i);
        }

        return alns;
    }

    public void removerAluno(String matricula) {
        if (!alunos.containsKey(matricula)) {
            throw new IllegalArgumentException("Não existe aluno com a matrícula informada.");
        }
        else {
            alunos.remove(matricula);
        }
    }
    
    public aluno getAluno(String matricula) {
        return alunos.get(matricula);
    }

    public aluno getAlunoByCpf(String cpf) throws KeyManagementException {
        for (String key: alunos.keySet()) {
            if (alunos.get(key).getCpf() == cpf) {
                return alunos.get(key);
            }
        }

        throw new KeyManagementException("Não existe aluno com o CPF informado");
    }
}

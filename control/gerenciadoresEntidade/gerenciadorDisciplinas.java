package control.gerenciadoresEntidade;

import java.util.ArrayList;
import java.util.HashMap;

import cadastro.cadastrarDisciplina;
import entidades.disciplina;

public class gerenciadorDisciplinas {
    private static ArrayList<String> nomes = new ArrayList<String>();

    private static HashMap<String, disciplina> disciplinas = new HashMap<>();
 
    public void novaDisciplina () throws IllegalArgumentException {
        try {
            String[] disc = cadastrarDisciplina.realizarCadastro();
            
            if (nomes.contains(disc[0])) {
                throw new IllegalArgumentException("Já existe uma disciplina com esse nome.");
            }

            if (disciplinas.containsKey(disc[1])) {
                throw new IllegalArgumentException("Já existe uma disciplina com esse código.");
            }

            nomes.add(disc[0]);

            disciplinas.put(disc[1], new disciplina(disc[0], disc[1]));
        }
        catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    public String[] listarDisciplinas() {
        ArrayList<String> discList = new ArrayList<String>();
        for (String key: disciplinas.keySet()) {
            discList.add(key + " - " + disciplinas.get(key).getNome());
        }

        String[] arr = new String[discList.size()];
        for (int i=0; i < discList.size(); i++) {
            arr[i] = discList.get(i);
        }
        return arr;
    }

    public void removerDisciplina (String codigo) {
        if (!disciplinas.containsKey(codigo)) {
            throw new IllegalArgumentException("Não há disciplina com o código informado.");
        }
        else {
            nomes.remove(disciplinas.get(codigo).getNome());
            disciplinas.remove(codigo);
        }
    }

    public ArrayList<disciplina> getDisciplinas() {
        ArrayList<disciplina> disciplinas_ = new ArrayList<>();
        for (String key : disciplinas.keySet()) {
            disciplinas_.add(disciplinas.get(key));
        }

        return disciplinas_;
    }

    public disciplina getDisciplina(String codigo) { return disciplinas.get(codigo); }
}

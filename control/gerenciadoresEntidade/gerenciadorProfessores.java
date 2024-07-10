package control.gerenciadoresEntidade;

import java.util.ArrayList;
import java.util.HashMap;

import cadastro.cadastrarProfessor;
import entidades.professor;

public class gerenciadorProfessores {
    private static ArrayList<String> cpfs = new ArrayList<String>();

    private static HashMap<String, professor> professores = new HashMap<String, professor>();
    private static int profCount = 0;

    public void novoProfessor() {
        try {
            String[] prof = cadastrarProfessor.realizarCadastro();

            if (cpfs.contains(prof[1])) {
                throw new IllegalArgumentException("Já existe professor com esse CPF.");
            }

            cpfs.add(prof[1]);

            professores.put(String.valueOf(++profCount), new professor(prof[0], prof[1]));
        }
        catch (IllegalArgumentException err) {
            System.out.println(err.getMessage());
        }
    }

    public String[] listarProfessores() {
        ArrayList<String> profs = new ArrayList<String>();
        for (String key : professores.keySet()) {
            professor prof = professores.get(key);
            String cpf = prof.getCpf();
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(10, 11);
            profs.add(key + " - " + prof.getNome() + "\t CPF: " + cpf);
        }

        String[] profs_ = new String[profs.size()];
        for (int i=0; i < profs.size(); i++) {
            profs_[i] = profs.get(i);
        }

        return profs_;
    }

    public void removerProfessor(int idProfessor) {
        if (!professores.containsKey(String.valueOf(idProfessor))) {
            throw new IllegalArgumentException("Não existe professor com o ID informado.");
        }
        else {
            cpfs.remove(professores.get(String.valueOf(idProfessor)).getCpf());
            professores.remove(String.valueOf(idProfessor));
        }
    }

    public professor getProfessor(int idProfessor) {
        return professores.get(String.valueOf(idProfessor));
    }
    public professor getProfessor(String idProfessor) {
        return professores.get(idProfessor);
    }
}

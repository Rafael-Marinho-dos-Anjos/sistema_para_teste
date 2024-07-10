package control.gerenciadoresMenu;

import java.util.ArrayList;

import control.gerenciadoresEntidade.gerenciadorAlunos;
import control.gerenciadoresEntidade.gerenciadorDisciplinas;
import control.gerenciadoresEntidade.gerenciadorProfessores;
import control.menus.MenuDisciplina;
import entidades.aluno;
import entidades.disciplina;
import entidades.professor;
import utils.SafeReading;
import utils.ScannerHolder;

public class GerenciadorMenuDisc {
    private static gerenciadorDisciplinas gerDisc = new gerenciadorDisciplinas();
    private static gerenciadorAlunos gerAln = new gerenciadorAlunos();
    private static gerenciadorProfessores gerProf = new gerenciadorProfessores();
    private static ScannerHolder sh = ScannerHolder.getInstance();

    public static void startMenu() {
        System.out.println("\n");
        System.out.print("Digite o código da disciplina que deseja acessar: ");
        String cod = sh.getScanner().nextLine();
        try {
            disciplina disc = gerDisc.getDisciplina(cod);

            if (disc == null) {
                System.out.println("Código de disciplina inválido");
                return;
            }
            int escolha = 0;
            
            while (escolha != 7 && escolha != 5) {
                escolha = MenuDisciplina.menu();

                switch (escolha) {
                    case 1:
                        lotarProfessor(disc);
                        break;

                    case 2:
                        matricularAluno(disc);
                        break;

                    case 3:
                        verProfessor(disc);
                        break;

                    case 4:
                        verAlunos(disc);
                        break;

                    case 5:
                        removerDisciplina(disc);
                        break;

                    case 6:
                        removerAluno(disc);
                        break;
                }
            }
        }
        catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        }
    }

    private static void lotarProfessor(disciplina disc) {
        int profId = SafeReading.readInt("Digite o id do professor: ");
        try {
            professor prof = gerProf.getProfessor(profId);
            if (prof == null) { System.out.println("Não há professor com o ID informado.");}
            else {
                disc.lotarProfessor(prof);
                System.out.println("\nProfessor lotado com sucesso.\n");
            }
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        sh.getScanner().nextLine();
    }

    private static void matricularAluno(disciplina disc) {
        System.out.print("Digite a matrícula do aluno: ");
        String mat = sh.getScanner().nextLine();
        try {
            aluno aln = gerAln.getAluno(mat);
            disc.matricularAluno(aln.getMatricula());
            System.out.println("\nAluno matriculado com sucesso.\n");
        }
        catch (Exception err) {
            System.out.println(err.getMessage());
        }
        sh.getScanner().nextLine();
    }

    private static void verProfessor(disciplina disc) {
        professor prof = disc.getProf();
        if (prof == null) {
            System.out.println("Esta disciplina não possui professor.");
        }
        else {
            String cpf = prof.getCpf();
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(10, 11);
            System.out.println("Professor da disciplina " + disc.getNome() + ":");
            System.out.println(
                "Nome: " + prof.getNome() + "\t CPF: " + cpf
            );
        }
        sh.getScanner().nextLine();
    }

    private static void verAlunos(disciplina disc) {
        System.out.println("Alunos matriculados na disciplina " + disc.getNome() + ":");
        ArrayList<String> matriculas = disc.getAlunos();
        for (String matricula: matriculas) {
            aluno aln = gerAln.getAluno(matricula);
            String cpf = aln.getCpf();
            cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(10, 11);
            System.out.println("\n"+matricula + " - " + aln.getNome() + "\t CPF: " + cpf);
        }
        sh.getScanner().nextLine();
    }

    private static void removerDisciplina(disciplina disc) {
        gerDisc.removerDisciplina(disc.getCod());
        System.out.println("Disciplina " + disc.getNome() + " removida.");
        sh.getScanner().nextLine();
    }

    private static void removerAluno(disciplina disc) {
        int matricula = SafeReading.readInt("Informe a matricula do aluno: ");
        if (!disc.getAlunos().contains(String.valueOf(matricula))) {
            System.out.println("Aluno não matriculado na disciplina.");
        }
        else {
            disc.removerAluno(String.valueOf(matricula));
            System.out.println("Aluno removido.");
        }
        sh.getScanner().nextLine();
    }
}

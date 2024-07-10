package control.gerenciadoresMenu;

import control.gerenciadorasEntidade.gerenciadorAlunos;
import control.gerenciadorasEntidade.gerenciadorDisciplinas;
import control.gerenciadorasEntidade.gerenciadorProfessores;
import control.menus.MenuPrincipal;
import utils.SafeReading;
import utils.ScannerHolder;

public class GerenciadorRaiz {
    private static gerenciadorDisciplinas gerDisc = new gerenciadorDisciplinas();
    private static gerenciadorAlunos gerAln = new gerenciadorAlunos();
    private static gerenciadorProfessores gerProf = new gerenciadorProfessores();
    private static ScannerHolder sh = ScannerHolder.getInstance();
    
    public static void startMenu() {
        int escolha = 0;
        while (escolha != 10) {
            escolha = MenuPrincipal.menu();
            switch (escolha) {
                case 1:
                {
                    novaDisciplina();
                    break;
                }
                case 2:
                {
                    novoProfessor();
                    break;
                }
                case 3:
                {
                    novoAluno();
                    break;
                }
                case 4:
                {
                    verDisciplinas();
                    break;
                }
                case 5:
                {
                    verProfessores();
                    break;
                }
                case 6:
                {
                    verAlunos();
                    break;
                }
                case 7:
                {
                    removerDisciplina();
                    break;
                }
                case 8:
                {
                    removerProfessor();
                    break;
                }
                case 9:
                {
                    removerAluno();
                    break;
                }
            }
        }
    }

    private static void novaDisciplina() {
        gerDisc.novaDisciplina();
        System.out.println("\nDisciplina cadastrada!");
        sh.getScanner().nextLine();
    }

    private static void novoProfessor() {
        gerProf.novoProfessor();
        System.out.println("\nProfessor cadastrado!");
        sh.getScanner().nextLine();
    }

    private static void novoAluno() {
        gerAln.novoAluno();
        System.out.println("\nAluno cadastrado!");
        sh.getScanner().nextLine();
    }

    private static void verDisciplinas() {
        System.out.println("\n\n");
        System.out.println(" ------ Disciplinas ------\n");
        String[] disciplinas = gerDisc.listarDisciplinas();
        for (String disc : disciplinas) {
            System.out.println(disc);
        }
        GerenciadorMenuDisc.startMenu();
    }

    private static void verProfessores() {
        System.out.println("\n\n");
        System.out.println(" ------ Professores ------\n");
        String[] professores = gerProf.listarProfessores();
        for (String prof : professores) {
            System.out.println(prof);
        }
        GerenciadorMenuProf.startMenu();
    }

    private static void verAlunos() {
        System.out.println("\n\n");
        System.out.println(" ------ Alunos ------\n");
        String[] alunos = gerAln.listarAlunos();
        for (String aluno : alunos) {
            System.out.println(aluno);
        }
        GerenciadorMenuAluno.startMenu();
    }

    private static void removerDisciplina() {
        try {
            System.out.print("Digite o código da disciplina a ser removida: ");
            String cod = sh.getScanner().nextLine();
            gerDisc.removerDisciplina(cod);
        }
        catch (Exception err) { System.out.println(err.getMessage()); }
    }

    private static void removerProfessor() {
        try {
            int id = SafeReading.readInt("Digite o ID do professor a ser removido: ");
            gerProf.removerProfessor(id);
        }
        catch (Exception err) { System.out.println(err.getMessage()); }
    }

    private static void removerAluno() {
        try {
            System.out.print("Digite a matrícula do aluno a ser removido: ");
            String mat = sh.getScanner().nextLine();
            gerAln.removerAluno(mat);
        }
        catch (Exception err) { System.out.println(err.getMessage()); }
    }
}

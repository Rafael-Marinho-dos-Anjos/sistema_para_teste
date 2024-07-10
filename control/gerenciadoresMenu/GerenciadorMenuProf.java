package control.gerenciadoresMenu;

import java.util.ArrayList;

import control.gerenciadorasEntidade.gerenciadorDisciplinas;
import control.gerenciadorasEntidade.gerenciadorProfessores;
import control.menus.MenuProfessor;
import entidades.disciplina;
import entidades.professor;
import utils.SafeReading;
import utils.ScannerHolder;

public class GerenciadorMenuProf {
    private static gerenciadorDisciplinas gerDisc = new gerenciadorDisciplinas();
    private static gerenciadorProfessores gerProf = new gerenciadorProfessores();
    private static ScannerHolder sh = ScannerHolder.getInstance();

    public static void startMenu() {
        int id = SafeReading.readInt("\nDigite o ID do professor que deseja acessar: ");
        professor prof = gerProf.getProfessor(id);
        if (prof == null) {
            System.out.println("ID de professor inválido.");
        }
        else {
            int escolha = 0;

            while (escolha != 5 && escolha != 3) {
                escolha = MenuProfessor.menu();

                switch (escolha) {
                    case 1:
                        lotarProfessor(prof);
                        break;

                    case 2:
                        disciplinasProfessor(prof);
                        break;
            
                    case 3:
                        removerProfessor(prof, id);
                        break;

                    case 4:
                        retirarDisciplina(prof);
                        break;
                }
            }
        }
    }

    private static void lotarProfessor(professor prof) {
        System.out.print("Digite o código da disciplina: ");
        String cod = sh.getScanner().nextLine();
        disciplina disc = gerDisc.getDisciplina(cod);
        if (disc == null) {
            System.out.println("Código de disciplina inválido.");
        }
        else {
            disc.lotarProfessor(prof);
            System.out.println("Professor lotado na disciplina " + disc.getNome() + ".");
        }
        sh.getScanner().nextLine();
    }

    private static void disciplinasProfessor(professor prof) {
        System.out.println("Disciplinas ministradas pelo professor " + prof.getNome() + ":");
        ArrayList<disciplina> disciplinas = gerDisc.getDisciplinas();
        for (disciplina disc : disciplinas) {
            if (disc.getProf().equals(prof)) {
                System.out.println("\t" + disc.getCod() + " - " + disc.getNome());
            }
        }
        sh.getScanner().nextLine();
    }

    private static void removerProfessor(professor prof, int id) {
        ArrayList<disciplina> discs = gerDisc.getDisciplinas();
        for (disciplina disc : discs) {
            try {
                if (disc.getProf().equals(prof)) {
                    disc.lotarProfessor(null);
            }}
            catch (Exception e) {}
        }
        gerProf.removerProfessor(id);
        System.out.println("Professor removido.");
        sh.getScanner().nextLine();
    }

    private static void retirarDisciplina(professor prof) {
        System.out.print("Digite o código da disciplina: ");
        String cod = sh.getScanner().nextLine();
        disciplina disc = gerDisc.getDisciplina(cod);
        if (disc == null) { System.out.println("Código de disciplina inválido."); }
        else {
            disc.lotarProfessor(null);
            System.out.println("Professor removido da disciplina " + disc.getNome() + ".");
        }
        sh.getScanner().nextLine();
    }
}

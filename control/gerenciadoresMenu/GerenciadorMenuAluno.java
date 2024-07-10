package control.gerenciadoresMenu;

import java.util.ArrayList;

import control.gerenciadorasEntidade.gerenciadorAlunos;
import control.gerenciadorasEntidade.gerenciadorDisciplinas;
import control.menus.MenuAluno;
import entidades.aluno;
import entidades.disciplina;
import utils.ScannerHolder;

public class GerenciadorMenuAluno {
    private static gerenciadorDisciplinas gerDisc = new gerenciadorDisciplinas();
    private static gerenciadorAlunos gerAln = new gerenciadorAlunos();
    private static ScannerHolder sh = ScannerHolder.getInstance();

    public static void startMenu() {
        System.out.println("\n");
        System.out.print("Digite a matrícula do aluno que deseja acessar: ");
        String mat = sh.getScanner().nextLine();
        try {
            aluno aln = gerAln.getAluno(mat);
            if (aln == null) {
                System.out.println("Matrícula inválida.");
                return;
            }
            int escolha = 0;

            while (escolha != 5 && escolha != 3) {
                escolha = MenuAluno.menu();
                
                switch (escolha) {
                    case 1:
                        matricular(aln);
                        break;
                        
                    case 2:
                        listarDisciplinas(aln);
                        break;
                    case 3:
                        remover(aln);
                        break;
                    
                    case 4:
                        retirarDisciplina(aln);
                        break;
                }
            }
        }
        catch (IllegalArgumentException err) {
            System.err.println(err.getMessage());
        }
    }

    private static void matricular(aluno aln) {
        System.out.print("Digite o código da disciplina: ");
        String cod = sh.getScanner().nextLine();
        disciplina disc = gerDisc.getDisciplina(cod);
        if (disc == null) {
            System.out.println("Código de disciplina inválido.");
        }
        else {
            try {
                disc.matricularAluno(aln.getMatricula());
                System.out.println("Aluno matriculado na disciplina " + disc.getNome() + ".");
            }
            catch (IllegalArgumentException err) {
                System.out.println(err.getMessage());
            }
        }
        sh.getScanner().nextLine();
    }

    private static void listarDisciplinas(aluno aln) {
        ArrayList<disciplina> disciplinas = gerDisc.getDisciplinas();
        System.out.println("Disciplinas do aluno " + aln.getNome() + ":");
        for (disciplina dis : disciplinas) {
            if (dis.getAlunos().contains(aln.getMatricula())) {
                System.out.println("\t" + dis.getCod() + " - " + dis.getNome());
            }
        }
        sh.getScanner().nextLine();
    }

    private static void remover(aluno aln) {
        ArrayList<disciplina> disciplinas = gerDisc.getDisciplinas();
        System.out.println("Disciplinas do aluno " + aln.getNome() + ":");
        for (disciplina dis : disciplinas) {
            if (dis.getAlunos().contains(aln.getMatricula())) {
                dis.removerAluno(aln.getMatricula());
            }
        }
        gerAln.removerAluno(aln.getMatricula());
        System.out.println("Aluno " + aln.getNome() + " removido.");
        sh.getScanner().nextLine();
    }

    private static void retirarDisciplina(aluno aln) {
        System.out.print("Digite o código da disciplina: ");
        String cod = sh.getScanner().nextLine();
        disciplina disc = gerDisc.getDisciplina(cod);
        if (disc == null) {
            System.out.println("Código de disciplina inválido.");
        }
        else {
            if (disc.getAlunos().contains(aln.getMatricula())) {
                disc.removerAluno(aln.getMatricula());
                System.out.println("Aluno removido da disciplina " + disc.getNome() + ".");
            }
            else {
                System.out.println("Aluno não matriculado na disciplina " + disc.getNome() + ".");
            }
        }
        sh.getScanner().nextLine();
    }
}

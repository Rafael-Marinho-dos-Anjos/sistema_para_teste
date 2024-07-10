package control.menus;

import utils.SafeReading;

public class MenuAluno {
    public static int menu() {
        System.out.println("\n\n   ------ Menu Aluno ------");
        System.out.println();
        System.out.println("-- Cadastro --");
        System.out.println("\t1. Matricular em disciplina;");
        System.out.println();
        System.out.println(" -- Visualização --");
        System.out.println("\t2. Listar todas as disciplinas do aluno;");
        System.out.println();
        System.out.println(" -- Deleção --");
        System.out.println("\t3. Apagar Aluno;");
        System.out.println("\t4. Retirar de disciplina;");
        System.out.println();
        System.out.println();
        System.out.println("5. Voltar.");
        System.out.println();
        
        int escolha = 0;

        while (escolha <= 0 || escolha > 6) {
            escolha = SafeReading.readInt("Digite o número da opção escolhida: ");
        }

        return escolha;
    }
}

package control.menus;

import utils.SafeReading;

public class MenuDisciplina {
    public static int menu() {
        System.out.println("\n\n   ------ Menu Disciplinas ------");
        System.out.println();
        System.out.println("-- Cadastro --");
        System.out.println("\t1. Lotar professor;");
        System.out.println("\t2. Matricular aluno;");
        System.out.println();
        System.out.println(" -- Visualização --");
        System.out.println("\t3. Professor da disciplina;");
        System.out.println("\t4. Listar todos os alunos;");
        System.out.println();
        System.out.println(" -- Deleção --");
        System.out.println("\t5. Apagar disciplina;");
        System.out.println("\t6. Retirar Aluno;");
        System.out.println();
        System.out.println();
        System.out.println("7. Voltar.");
        System.out.println();
        
        int escolha = 0;

        while (escolha <= 0 || escolha > 7) {
            escolha = SafeReading.readInt("Digite o número da opção escolhida: ");
        }

        return escolha;
    }
}

package control.menus;

import utils.SafeReading;

public class MenuPrincipal {
    public static int menu() {
        System.out.println("\n\n   ------ Menu Principal ------");
        System.out.println();
        System.out.println("-- Cadastro --");
        System.out.println("\t1. Cadastrar disciplina;");
        System.out.println("\t2. Cadastrar professor;");
        System.out.println("\t3. Cadastrar aluno;");
        System.out.println();
        System.out.println(" -- Visualização --");
        System.out.println("\t4. Listar todas as disciplinas;");
        System.out.println("\t5. Listar todos os professores;");
        System.out.println("\t6. Listar todos os alunos;");
        System.out.println();
        System.out.println(" -- Deleção --");
        System.out.println("\t7. Apagar disciplina;");
        System.out.println("\t8. Apagar professor;");
        System.out.println("\t9. Apagar aluno;");
        System.out.println();
        System.out.println();
        System.out.println("10. Sair.");
        System.out.println();
        
        int escolha = 0;

        while (escolha <= 0 || escolha > 12) {
            escolha = SafeReading.readInt("Digite o número da opção escolhida: ");
        }

        return escolha;
    }
}

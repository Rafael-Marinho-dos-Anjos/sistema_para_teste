package cadastro;

import utils.ScannerHolder;

public class cadastrarDisciplina {
    public static String[] realizarCadastro() {
        ScannerHolder io = ScannerHolder.getInstance();
        String nome = "";
        String codigo = "";
        
        boolean valido = false;
        while (!valido) {
            System.out.print("Digite o nome da disciplina: ");
            nome = io.getScanner().nextLine();

            if (nome.length() < 4) {
                System.out.println("O nome deve conter pelo menos 4 letras.");
            }
            else if (!nome.matches("^[a-zA-Z\s]+$")) {
                System.out.println("O nome deve conter apenas letras e espaço.");
            }
            else if (nome.matches("^\s[a-zA-Z\s]+$")) {
                System.out.println("O nome não pode iniciar com espaço.");
            }
            else { valido = true; }
        }

        valido = false;
        while (!valido) {
            System.out.print("Digite o código da disciplina: ");
            codigo = io.getScanner().nextLine();

            if (codigo.length() != 5) {
                System.out.println("O código deve conter exatamente 5 caracteres.");
            }
            else if (!codigo.matches("^[0-9A-Z]+$")) {
                System.out.println("O código deve ser composto apenas por algarismos ou letras maiúsculas.");
            }
            else { valido = true; }
        }
        
        String[] disciplina = {nome, codigo};
        return disciplina;
    }
}

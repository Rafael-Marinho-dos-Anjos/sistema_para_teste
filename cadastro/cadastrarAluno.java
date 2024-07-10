package cadastro;

import utils.ScannerHolder;

public class cadastrarAluno {
    public static String[] realizarCadastro() {
        ScannerHolder io = ScannerHolder.getInstance();
        String nome = "";
        String cpf = "";
        String matricula = "";
        
        boolean valido = false;
        while (!valido) {
            System.out.print("Digite o nome do aluno: ");
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
            System.out.print("Digite o CPF do aluno sem pontos ou traços: ");
            cpf = io.getScanner().nextLine();

            if (cpf.length() != 11) {
                System.out.println("O CPF deve conter exatamente 11 algarismos.");
            }
            else if (!cpf.matches("^[0-9]+$")) {
                System.out.println("O CPF deve ser composto apenas por algarismos.");
            }
            else { valido = true; }
        }

        valido = false;
        while (!valido) {
            System.out.print("Digite a matrícula do aluno: ");
            matricula = io.getScanner().nextLine();

            if (String.valueOf(matricula).length() != 6) {
                System.out.println("A matrícula deve conter exatamente 6 algarismos.");
            }
            else if (!matricula.matches("^[0-9]+$")) {
                System.out.println("A matrícula deve ser composta apenas por algarismos.");
            }
            else { valido = true; }
        }

        String[] aluno = {nome, cpf, matricula};
        return aluno;
    }
}
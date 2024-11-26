import Exceptions.CpfException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidaCpf {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean invalido = true;
        String cpf = "";
        String estado = "";
        while (invalido) {
            try {
                System.out.print("Digite seu CPF: ");
                cpf = sc.nextLine();

                System.out.print("Digite a sigla do seu Estado de nascença: ");
                estado = sc.nextLine();

                if (!cpfValidation(cpf)) {
                    throw new CpfException("CPF invalido");
                } else if (!stateAndCpf(cpf, estado)) {
                    throw new CpfException("Este CPF não pertence a esse estado");
                } else {
                    invalido = false;
                    System.out.println("CPF e estado validos");
                }

            } catch (CpfException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static boolean cpfValidation(String cpf) {

        cpf = cpf.replace(".", "");
        cpf = cpf.replace("-", "");
        if (
                cpf.length() != 11
                        || cpf.equals("00000000000")
                        || cpf.equals("11111111111")
                        || cpf.equals("22222222222")
                        || cpf.equals("33333333333")
                        || cpf.equals("44444444444")
                        || cpf.equals("55555555555")
                        || cpf.equals("66666666666")
                        || cpf.equals("77777777777")
                        || cpf.equals("88888888888")
                        || cpf.equals("99999999999")
        ) {
            return false;
        }
        char dig10, dig11;
        int sm, i, r, num, peso;
        try {
            sm = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }
            r = 11 - (sm % 11);
            if (r == 10 || r == 11) dig10 = '0';
            else dig10 = (char) (r + 48);


            sm = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                num = (int) (cpf.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if (r == 10 || r == 11) dig11 = '0';
            else
                dig11 = (char) (r + 48);


            return (dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10));


        } catch (
                InputMismatchException e) {
            return (false);
        }

    }

    public static boolean stateAndCpf(String cpf, String estado) {

        try {
            if (estado.length() != 2) {
                throw new CpfException("Estado inválido!");
            }
            cpf = cpf.replace(".", "");
            cpf = cpf.replace("-", "");
            char dig9 = cpf.charAt(8);

            return (dig9 == '1' && (estado.equals("DF") || estado.equals("GO") || estado.equals("MS") || estado.equals("MT") || estado.equals("TO")))
                    || (dig9 == '2' && (estado.equals("AC") || estado.equals("AM") || estado.equals("AP")
                    || estado.equals("PA") || estado.equals("Ro") || estado.equals("RR")))
                    || (dig9 == '3' && (estado.equals("CE") || estado.equals("MA") || estado.equals("PI")))
                    || (dig9 == '4' && (estado.equals("AL") || estado.equals("PB") || estado.equals("PE") || estado.equals("RN")))
                    || (dig9 == '5' && (estado.equals("BA") || estado.equals("SE")))
                    || (dig9 == '6' && estado.equals("MG"))
                    || (dig9 == '7' && (estado.equals("ES") || estado.equals("RJ")))
                    || (dig9 == '8' && estado.equals("SP"))
                    || (dig9 == '9' && (estado.equals("PR") || estado.equals("SC")))
                    || (dig9 == '0' && estado.equals("RS"));


        } catch (CpfException e) {
            System.out.println(e.getMessage());
            return false;
        }

    }
}

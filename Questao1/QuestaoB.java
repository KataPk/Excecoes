package Questao1;

import validacoes.ValidaEmail;

import java.util.Scanner;

public class QuestaoB {

    public static void main(String[] args) {
        ValidaEmail validaEmail = new ValidaEmail();
        Scanner sc = new Scanner(System.in);
        String email = "";
        boolean invalido = true;
        while (invalido) {
            try {
                System.out.print("Digite seu email institucional: ");
                email = sc.nextLine();

                if (validaEmail.validaEmailFatec(email)) {
                    invalido = false;
                    System.out.println("\nEmail válido!");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }

}

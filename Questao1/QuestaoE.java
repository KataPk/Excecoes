/*
   Crie um programa que solicita ao usuário três notas para calcular a média.
   - Se uma das notas fornecidas não for numérica ou estiver fora do intervalo permitido (0 a 10), o programa deve lançar uma exceção.
   - O programa continuará pedindo valores válidos até que todas as notas sejam fornecidas corretamente.
*/

package Questao1;

import validacoes.ValidaNota;

import java.util.InputMismatchException;
import java.util.Scanner;

public class QuestaoE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean invalido = true;
        double nota1;
        double nota2;
        double nota3;
        double media;
        ValidaNota validaNota = new ValidaNota();
        while (invalido) {
            try {
                System.out.print("Digite a primeira nota: ");
                nota1 = sc.nextDouble();
                if (!validaNota.validarNota(nota1)) throw new Exception();
                System.out.print("Digite a segunda nota: ");
                nota2 = sc.nextDouble();
                if (!validaNota.validarNota(nota2)) throw new Exception();

                System.out.print("Digite a terceira nota: ");
                nota3 = sc.nextDouble();
                if (!validaNota.validarNota(nota3)) throw new Exception();

                media = (nota1 + nota2 + nota3) / 3;

                System.out.println("A sua média é: " + media);
                invalido = false;

            } catch (InputMismatchException e) {
                System.out.println("Nota invalida");
                sc.nextLine();
            } catch (Exception ignored){

            }
        }
    }


}

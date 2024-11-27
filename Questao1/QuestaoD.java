/*
   Faça um programa que solicita ao usuário uma temperatura e a unidade correspondente (Celsius, Fahrenheit ou Kelvin).
   O programa deve realizar as seguintes verificações e ações:

   1. Valide se a entrada de temperatura é numérica. Caso contrário, lance e trate uma InputMismatchException.
   2. Verifique se a unidade fornecida é válida (C, F ou K). Caso não seja, lance e trate uma IllegalArgumentException.
   3. Caso o usuário insira um valor de temperatura abaixo do zero absoluto (0 K, -273.15 °C ou -459.67 °F),
      lance uma customizada "InvalidTemperatureException" com uma mensagem apropriada.
   4. Verifique se o usuário deixou a entrada de temperatura ou unidade vazia. Se sim, lance uma NullPointerException.

   O programa deve continuar pedindo valores válidos até que o usuário forneça uma entrada correta.
   Após validar as entradas, o programa calculará e exibirá as temperaturas correspondentes nas outras duas unidades.
*/


package Questao1;

import Exceptions.InvalidTemperatureException;

import java.util.Scanner;

public class QuestaoD {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean invalido = true;
        double temp = 0;
        double celsius = 0;
        double kelvin = 0;
        double fahrenheit;
        String unidade;
        while (invalido) {
            try {
                System.out.print("Digite a unidade da temperatura a ser convertida: ");
                unidade = sc.nextLine();
                if (unidade == null || unidade.isEmpty()) throw new NullPointerException("Unidade inválida");
                if (unidade.length() > 1 || (!unidade.equals("C") && !unidade.equals("F") && !unidade.equals("K")))
                    throw new IllegalArgumentException("Unidade inválida");

                System.out.print("Insira o valor da temperatura a ser convertida: ");
                temp = sc.nextDouble();
                if (Double.isNaN(temp) || Double.isInfinite(temp))
                    throw new IllegalArgumentException("temperatura inválida");
                if ((unidade.equals("C") && temp < -273.15) || (unidade.equals("K") && temp < 0) || (unidade.equals("F") && temp < -459.67))
                    throw new InvalidTemperatureException("Temperatura inválida. A temperatura não pode ser menor que 0° Kelvin");

                if (unidade.equals("C")) {
                    fahrenheit = temp * 9 / 5 + 32;
                    kelvin = temp + 273.15;
                    invalido = false;
                    System.out.println("Temperatura em Kelvin: " + kelvin + "\nTemperatura em Fahrenheit: " + fahrenheit);
                } else if (unidade.equals("F")) {
                    celsius = (temp - 32) * 5 / 9;
                    kelvin = (temp - 32) * 5 / 9 + 273.15;
                    invalido = false;
                    System.out.println("Temperatura em Celcius: °" + celsius + "\nTemperatura em Kelvin: " + kelvin);

                } else {
                    celsius = temp - 273.15;
                    fahrenheit = (temp - 273.15) * 9 / 5 + 32;
                    invalido = false;
                    System.out.println("Temperatura em Celcius: °" + celsius + "\nTemperatura em Fahrenheit: " + fahrenheit);

                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                sc.nextLine();

            }


        }

    }


}

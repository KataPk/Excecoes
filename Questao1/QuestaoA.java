package Questao1;

import Exceptions.CpfException;

import java.util.Scanner;
import validacoes.ValidaCpf;


public class QuestaoA {

        public static void main(String[] args) {
            ValidaCpf validaCpf = new ValidaCpf();

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

                    if (!validaCpf.cpfValidation(cpf)) {
                        throw new CpfException("CPF invalido");
                    } else if (!validaCpf.stateAndCpf(cpf, estado)) {
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

    }



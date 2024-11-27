package Questao1;

import Exceptions.EmailException;
import validacoes.ValidaCadastro;
import validacoes.ValidaEmail;

import java.util.Scanner;

public class QuestaoC {

    public static void main(String[] args) {

        ValidaEmail validaEmail = new ValidaEmail();
        ValidaCadastro validaCadastro = new ValidaCadastro();
        boolean invalido = true;
        Scanner sc = new Scanner(System.in);
        String dataNasc;
        String nome;
        String email;
        String telefone;
        String placa;
        String modelo;
        String marca;
        while (invalido) {

            try {
                System.out.print("Digite seu nome: ");
                nome = sc.nextLine();

                System.out.print("Digite seu email: ");
                email = sc.nextLine();
                if (!validaEmail.validaEmail(email)) throw new EmailException("Email inválido");

                System.out.print("Digite sua data de nascimento (formato: DD/MM/YYY): ");
                dataNasc = sc.nextLine();
                if (!validaCadastro.validaData(dataNasc)) throw new Exception();

                System.out.print("Digite seu telefone para contato: ");
                telefone = sc.nextLine();

                System.out.print("Digite a placa do seu veículo: ");
                placa = sc.nextLine();
                if (!validaCadastro.validaPlaca(placa)) throw new Exception("Placa inválida");

                System.out.print("Digite o modelo do veículo: ");
                modelo = sc.nextLine();

                System.out.print("Digite a marca do veículo: ");
                marca = sc.nextLine();

                System.out.println("Nome: " + nome + "\nData Nascimento: " + dataNasc + "\nTelefone: " + telefone
                        + "\nVeículo: " + modelo + "\nMarca: " + marca + "\nPlaca: " + placa);
                invalido = false;
            } catch (Exception e) {
                if (e.getMessage() != null && !e.getMessage().isEmpty())
                    System.out.println(e.getMessage());

            }


        }
    }
}

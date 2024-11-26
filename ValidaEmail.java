import java.util.Scanner;

public class ValidaEmail {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = "";
        boolean invalido = true;
        while (invalido) {
            try {
                System.out.print("Digite seu email institucional: ");
                email = sc.nextLine();

                if (!email.contains("@")|| email.indexOf('@') < 5) {
                    throw new Exception("Digite um email válido");
                } else if (!email.contains("@fatec.sp.gov.br")) {
                    throw new RuntimeException("O email deve ser o institucional (fatec.sp..gov.br)");
                }
                invalido = false;
                System.out.println("\nEmail válido!");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }


    }


}

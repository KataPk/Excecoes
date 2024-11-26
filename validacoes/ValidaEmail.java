package validacoes;

import Exceptions.EmailException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaEmail {


    public boolean validaEmail(String email) {
        try {
            if (email != null && !email.isEmpty()) {
                String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"; // metodo usando regex para validação
                Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(email);
                if (!matcher.matches()) throw new EmailException("Email inválido");
                else return true;
            } else throw new EmailException("Email inválido");
        } catch (Exception e) {
            return false;
        }

    }


    public boolean validaEmailFatec(String email) {

        try {
            if (email != null && !email.isEmpty()) {
                String fatecExpression = "^[\\w\\.-]+@fatec.sp.gov.br$"; // metodo usando regex para validação
                Pattern pattern = Pattern.compile(fatecExpression, Pattern.CASE_INSENSITIVE);
                Matcher fatecMatcher = pattern.matcher(email);

                if (!fatecMatcher.matches() && validaEmail(email))
                    throw new EmailException("Você inseriu seu email pessoal");
                else if (!fatecMatcher.matches()) throw new EmailException("Digite um email válido");
                else return true;
            } else throw new EmailException("Email Inválido");

        } catch (EmailException e) {
            System.out.println(e.getMessage());
            return false;

        }
    }
}

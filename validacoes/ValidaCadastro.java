package validacoes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidaCadastro {

 public boolean validaPlaca(String placa){

     String tradicional = "^[a-zA-Z]{3}-\\d{4}$";
     String mercoSul = "^[a-zA-Z]{3}\\d{1}[a-zA-Z]{1}\\d{2}$";
     try{
         Pattern pattern = Pattern.compile(tradicional, Pattern.CASE_INSENSITIVE);
         Matcher matcher = pattern.matcher(placa);
         if (matcher.matches()) return true;
         else {
             pattern = Pattern.compile(mercoSul, Pattern.CASE_INSENSITIVE);
             matcher = pattern.matcher(placa);

             return matcher.matches();
         }

     } catch(Exception e){
         return false;

     }

 }


 public boolean validaData(String data) {

     DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
     int anos;
     try {
         LocalDate dataNasc = LocalDate.parse(data, format);
         LocalDate hoje = LocalDate.now();

         anos = hoje.getYear() - dataNasc.getYear();

         if (anos < 18){
             System.out.println("Você precisa ser maior de idade para possuir um carro");
             return false;
         } else return true;

     } catch (Exception e){
         System.out.println("Data inválida");
         return false;
     }
 }



}

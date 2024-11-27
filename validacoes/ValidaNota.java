package validacoes;

public class ValidaNota {

    public boolean validarNota(double nota){
        try{
            if(nota>10 || nota<0) throw new Exception();
            return true;



        } catch(Exception e){
            System.out.println("A nota não pode ser maior que 10 e menor que 0!");
            return false;
        }


    }


}

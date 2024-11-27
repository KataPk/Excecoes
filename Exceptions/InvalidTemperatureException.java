package Exceptions;

public class InvalidTemperatureException extends Exception{


    public InvalidTemperatureException() {
    }

    public InvalidTemperatureException(String message) {
        super(message);
    }
}

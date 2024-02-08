package uol.compass.commerce.exceptions;

public class ApplicationInitializationException extends Exception {

    public ApplicationInitializationException(String message) {
        super(message);
    }

    public ApplicationInitializationException(String message, Throwable cause) {
        super(message, cause);
    }
}
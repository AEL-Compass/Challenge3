package uol.compass.commerce.exceptions;

public class ProductJsonException extends Exception {

    public ProductJsonException(String message) {
        super(message);
    }

    public ProductJsonException(String message, Throwable cause) {
        super(message, cause);
    }
}
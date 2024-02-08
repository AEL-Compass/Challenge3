package uol.compass.commerce.exceptions;

public class ProductInsertionException extends Exception {

    public ProductInsertionException(String message) {
        super(message);
    }

    public ProductInsertionException(String message, Throwable cause) {
        super(message, cause);
    }
}

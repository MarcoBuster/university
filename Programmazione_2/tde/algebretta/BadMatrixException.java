package algebretta;

public class BadMatrixException extends IllegalArgumentException {
    public BadMatrixException() {
        super();
    }

    public BadMatrixException(String message) {
        super(message);
    }
}

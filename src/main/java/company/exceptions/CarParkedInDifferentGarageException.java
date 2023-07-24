package company.exceptions;

public class CarParkedInDifferentGarageException extends RuntimeException{
    public CarParkedInDifferentGarageException() {
    }

    public CarParkedInDifferentGarageException(String message) {
        super(message);
    }
}

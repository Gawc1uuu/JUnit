package company.exceptions;

public class GarageFullException extends RuntimeException{
    public GarageFullException() {
    }

    public GarageFullException(String message) {
        super(message);
    }
}

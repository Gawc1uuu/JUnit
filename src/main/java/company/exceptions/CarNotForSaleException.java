package company.exceptions;

public class CarNotForSaleException extends RuntimeException{

    public CarNotForSaleException() {
    }

    public CarNotForSaleException(String message) {
        super(message);
    }
}

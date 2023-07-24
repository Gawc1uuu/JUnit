package company.exceptions;

public class EmployeeAlreadyHiredException extends RuntimeException{
    public EmployeeAlreadyHiredException() {
    }

    public EmployeeAlreadyHiredException(String message) {
        super(message);
    }
}

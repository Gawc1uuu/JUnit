package array.exceptions;

public class ArrayIsNullException extends RuntimeException{
    public ArrayIsNullException() {
    }

    public ArrayIsNullException(String message) {
        super(message);
    }
}

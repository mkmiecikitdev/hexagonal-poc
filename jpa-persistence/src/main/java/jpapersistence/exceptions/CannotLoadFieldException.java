package jpapersistence.exceptions;

public class CannotLoadFieldException extends RuntimeException {
    public CannotLoadFieldException(String field) {
        super(String.format("Cannot load field from DB: %s", field));
    }
}

package exception;

public class SachException extends Exception {
    private String message;

    public SachException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package exception;

public class MonHocException extends Exception {

    private String message;

    public MonHocException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

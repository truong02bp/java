package exception;

public class SinhVienException extends Exception {
    private String message;

    public SinhVienException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

package finki.ukim.mk.emtlab1.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exception.");
    }
}

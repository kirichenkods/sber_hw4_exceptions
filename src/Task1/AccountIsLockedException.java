package Task1;

public class AccountIsLockedException extends Exception {
    public AccountIsLockedException(int countSeconds) {
        super("До конца блокировки осталось: " + countSeconds);
    }
}

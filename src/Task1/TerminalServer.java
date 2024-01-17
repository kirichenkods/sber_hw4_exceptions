package Task1;

public class TerminalServer {
    private int account;

    public TerminalServer() {
        this.account = 0;
    }

    public int getAccount() {
        return account;
    }

    public void withdraw(int money) throws IllegalArgumentException {
        if (money > account) {
            throw new IllegalArgumentException("запрашиваемая сумма больше остатка на счете");
        }
        if (validSum(money)) {
            account -= money;
        }
    }

    public void put(int money) throws IllegalArgumentException {
        if (validSum(money)) {
            account += money;
        }
    }

    private boolean validSum(int money) throws IllegalArgumentException {
        if (money < 100) {
            throw new IllegalArgumentException("Сумма должна быть положительной");
        }
        if (money % 100 != 0) {
            throw new IllegalArgumentException("Введите сумму кратную 100!");
        }
        return true;
    }

}

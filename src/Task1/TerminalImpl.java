package Task1;

public class TerminalImpl implements Terminal {

    private final TerminalServer server;
    private final PinValidator pinValidator;

    public TerminalImpl(String pin) {
        this.server = new TerminalServer();
        this.pinValidator = new PinValidator(pin);
    }

    public boolean isPinCorrect() {
        return pinValidator.isPinCorrect();
    }

    @Override
    public int checkAccount() {
        return server.getAccount();
    }

    @Override
    public void withdrawMoney(int money) {
        try {
            server.withdraw(money);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void putMoney(int money) {
        try {
            server.put(money);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }
    }

}

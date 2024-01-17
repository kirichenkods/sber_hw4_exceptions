package Task1;

public class PinValidator {
    private final String pin;
    private static final int LIMIT_COUNT_ATTEMPTS = 3;
    private static final int BLOCK_TIME = 10;
    private static boolean isBlock = false;
    private static long startBlock;

    private final UserInterface userInterface;

    public PinValidator(String pin) {
        this.pin = pin;
        this.userInterface = new UserInterfaceConsole();
    }

    public boolean isPinCorrect() {
        int countAttempts = 0;

        while (true) {

            String inputPin = "";
            try {
                inputPin = getPin();
            } catch (AccountIsLockedException e) {
                System.err.println(e.getMessage());
                continue;
            }
            if (pin.equals(inputPin)) {
                return true;
            } else {
                userInterface.report("введен не верный пин-код");
            }
            countAttempts++;
            if (countAttempts == LIMIT_COUNT_ATTEMPTS) {
                isBlock = true;
                userInterface.report("аккаунт заблокирован на " + BLOCK_TIME + " секунд");
                countAttempts = 0;
                startBlock = System.currentTimeMillis();
            }
        }

    }

    private String getPin() throws AccountIsLockedException {
        StringBuilder inputPin = new StringBuilder();
        if (!isBlock) {
            userInterface.report("введите пин код");
        }

        do {
            String sym = userInterface.readSymbol();
            if (isBlock) {
                int finishBlock = getCountSecondsFromStart();
                if (finishBlock > BLOCK_TIME) {
                    isBlock = false;
                } else {
                    throw new AccountIsLockedException(BLOCK_TIME - finishBlock);
                }
            }
            try {
                inputPin.append(Integer.valueOf(sym.substring(0)));
            } catch (NumberFormatException e) {
                System.err.println("введите число");
            }
        } while (inputPin.length() != pin.length());

        return inputPin.toString();
    }

    private int getCountSecondsFromStart() {
        long now = System.currentTimeMillis();
        return (int) ((now - startBlock) / 1000.0);
    }
}

package Task1;

public class Main {
    public static void main(String[] args) {
        TerminalImpl terminal = new TerminalImpl("1234");
        String cmd = "";

        while (true) {
            UserInterface userInterface = new UserInterfaceConsole();
            if ("0".equals(cmd)) {
                break;
            }
            String message = "введите 0 для выхода\n" +
                        "введите любой символ для продолжения";
            userInterface.report(message);
            cmd = userInterface.readSymbol();

            if (terminal.isPinCorrect()) {
                while (true) {
                    userInterface.printMainMenu();
                    cmd = userInterface.readSymbol();

                    if ("1".equals(cmd)) {
                        userInterface.report("остаток: " + terminal.checkAccount());
                    } else if ("2".equals(cmd)) {
                        userInterface.report("введите сумму для снятия: ");
                        int sum = userInterface.getSum();
                        terminal.withdrawMoney(sum);
                    } else if ("3".equals(cmd)) {
                        userInterface.report("введите сумму для пополнения счета: ");
                        int sum = userInterface.getSum();
                        terminal.putMoney(sum);
                    } else if ("0".equals(cmd)) {
                        break;
                    } else {
                        userInterface.report("введите один из предложенных вариантов");
                    }
                }
            }
        }

    }

}
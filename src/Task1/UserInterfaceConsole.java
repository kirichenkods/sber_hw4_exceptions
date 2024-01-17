package Task1;

import java.util.Scanner;

public class UserInterfaceConsole implements UserInterface {
    @Override
    public void report(String message) {
        System.out.println(message);
    }

    @Override
    public void printMainMenu() {
        String startMessage = "введите 1 для проверки счёта\n" +
                "введите 2 для снятия денег\n" +
                "введите 3 для пополнения счёта\n" +
                "введите 0 для выхода";
        report(startMessage);
    }

    public String readSymbol() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input.substring(0);
    }

    public int getSum() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.err.println("введено не число");
        }
        return 0;
    }

}

package utils;

import lombok.Data;

import java.util.List;
import java.util.Scanner;

@Data
public class ConsoleManager {
    Scanner scanner = new Scanner(System.in);

    public ConsoleManager() {
    }

    public String readConsole() {
        String input = "";
        try {
            input = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return input;
    }

    public int readInteger() {
        String temp = readConsole();
        int number = 0;

        try {
            number = Integer.parseInt(temp);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return number;
    }

    public int chooseOption(String title, List<String> options) {
        Logger.printMessage(title);

        for (int i = 0; i < options.size(); i++) {
            System.out.println(String.format("%d) %s", i + 1, options.get(i)));
        }

        System.out.println("0) Cofnij");

        int integer = readInteger();
        return integer;
    }

    public int chooseOption(MessageFactory title, List<String> options) {
        return chooseOption(title.toString(), options);
    }
}

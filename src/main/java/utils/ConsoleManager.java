package utils;

import lombok.Data;

import java.util.Scanner;

@Data
public class ConsoleManager {
    Scanner scanner = new Scanner(System.in);

    public ConsoleManager() {
    }

    public String readConsole() {
        String input = "";
        try
        {
            input = scanner.nextLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return input;
    }
}

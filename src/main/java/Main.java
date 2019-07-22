/*                          Elektroniczny system oceniania

  Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów. Uprawniony
  użytkownik może wstawiać oceny, a student może tylko je wyświetlać. Tworzenie raportów i
  statystyk, itp
  */

import fileManager.JsonManager;
import gradeSystem.GradeSystem;
import gradeSystem.users.student.Student;
import gradeSystem.users.student.StudentImpl;
import utils.ConsoleManager;
import utils.Logger;
import utils.MessageFactory;

public class Main {
    public static void main(String[] args) {
        Logger.logMessage("Uruchomienie aplikacji");
        Logger.printMessage(MessageFactory.WELCOME_MESSAGE.toString());

        JsonManager.load();
        ConsoleManager consoleManager = new ConsoleManager();

        do {
            Logger.printMessage(MessageFactory.LOGIN_MESSAGE.toString());
            //gradeSystem.returnListOfUsers();
            String s = consoleManager.readConsole();
            System.out.println(s);
        }
        while (true);
    }
}


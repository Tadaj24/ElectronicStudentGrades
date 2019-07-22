/*                          Elektroniczny system oceniania

  Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów. Uprawniony
  użytkownik może wstawiać oceny, a student może tylko je wyświetlać. Tworzenie raportów i
  statystyk, itp
  */

import fileManager.JsonManager;
import gradeSystem.GradeSystem;
import gradeSystem.users.User;
import gradeSystem.users.student.StudentImpl;
import utils.ConsoleManager;
import utils.Logger;
import utils.MessageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private static ConsoleManager consoleManager = new ConsoleManager();
    private static GradeSystem gradeSystem;

    public static void main(String[] args) {
        Logger.logMessage("Uruchomienie aplikacji");

        gradeSystem = JsonManager.load();

        do {
            loginIntoApp();
        }
        while (true);
    }

    private static void mainMenuOptions(){
        Logger.printMessage(MessageFactory.WELCOME_MESSAGE);
    }

    private static void loginIntoApp() {
        Logger.printMessage(MessageFactory.LOGIN_TITLE);

        List<User> userList = gradeSystem.getListOfAllUsers();

        int choosedOption = consoleManager.chooseOption(
                MessageFactory.LOGIN_MESSAGE,
                userList.stream()
                        .sorted()
                        .map(x -> x.toString())
                        .collect(Collectors.toList()));
        Logger.clearTerminal();

        if (choosedOption == 0) {
            return;
        }

        User currentUser = userList.get(choosedOption - 1);
        for (int i = 1; i <= 3; i++) {
            if (!verifyPassword(currentUser)) {
                Logger.printMessage(MessageFactory.INCORRECT_PASSWORD_NEXT_TRY);
                if (i == 3) {
                    Logger.printMessage(MessageFactory.INCORRECT_PASSWORD_TOO_MANY_TRIES);
                    return;
                }
            }
            // if user enter correct password, program will skip to this line
            break;
        }

        if (currentUser instanceof StudentImpl){
            ((StudentImpl) currentUser).printGrades();
        }
    }

    private static boolean verifyPassword(User user) {
        Logger.printMessage(MessageFactory.LOGIN_PASSWORD_MESSAGE);
        String password = consoleManager.readConsole();
        boolean isPasswordCorrect = user.login(password);

        if (isPasswordCorrect) {
            Logger.printMessage(MessageFactory.LOGIN_CORRECT_PASSWORD);
        } else {
            Logger.printMessage(MessageFactory.LOGIN_INCORRECT_PASSWORD);
        }

        return isPasswordCorrect;
    }

}


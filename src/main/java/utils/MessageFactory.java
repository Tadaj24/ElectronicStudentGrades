package utils;

public enum MessageFactory {
    // In the future, it would be easy to added other languages by adding extra parameter to constructor
    WELCOME_MESSAGE("Witaj w elektornicznym systemie ocen. Zaloguj się aby uzyskać dostęp do funkcjonalności aplikacji."),
    LOGIN_TITLE(">>>LOGOWANIE<<<"),
    LOGIN_MESSAGE("Wybierz użytkownika:"),
    LOGIN_PASSWORD_MESSAGE("Podaj hasło:"),
    LOGIN_INCORRECT_PASSWORD("Błędne hasło!"),
    LOGIN_CORRECT_PASSWORD("Poprawne hasło. Zaraz zostaniesz zalogowany"),
    INCORRECT_PASSWORD_NEXT_TRY("Spróbuj podać hasło ponownie"),
    INCORRECT_PASSWORD_TOO_MANY_TRIES("Zbyt wiele razy podano niepoprwane hasło. APlikacja zostanie za chwilę zamknięta..."),
    ;

    String content;

    MessageFactory(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}

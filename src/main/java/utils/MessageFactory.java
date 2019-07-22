package utils;

public enum MessageFactory {
    WELCOME_MESSAGE("Witaj w elektornicznym systemie ocen. Zaloguj się aby uzyskać dostęp do funkcjonalności aplikacji."),
    LOGIN_MESSAGE(">>>LOGOWANIE<<<\nWybierz użytkownika:");

    String content;

    MessageFactory(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}

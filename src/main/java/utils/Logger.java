package utils;

import fileManager.ConfigManager;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static Logger ourInstance = new Logger();
    private static File logFile;

    public static Logger getInstance() {
        return ourInstance;
    }

    private Logger() {
        logFile = new File(String.format("%s\\logs_%s.log", ConfigManager.getLogsDirectory(), getCurrentTime()
                .replace("/", "")
                .replace(":", "")
                .replace(' ', '_')));
    }

    public static void printMessage(String message){
        System.out.println(message);
    }

    public static void printErrorMessage(String message) {
        System.err.println(message);
    }

    public static void logMessage(String message) {
        message = String.format("[%s] %s\n", getCurrentTime(), message);
        try {
            FileUtils.writeStringToFile(logFile, message, Charset.defaultCharset(), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logErrorMessage(String message) {
        message = String.format("[%s][ERROR] %s\n", getCurrentTime(), message);
        logMessage(message);
    }

    private static String getCurrentTime() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return formatter.format(date);
    }
}

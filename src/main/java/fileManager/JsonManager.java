package fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import gradeSystem.GradeSystem;
import org.apache.commons.io.FileUtils;
import utils.Logger;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class JsonManager {
    public static GradeSystem load() {
        Logger.logMessage("Loading JSON file...");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            File file = new File(String.format("%s\\GradeSystem.json", ConfigManager.getPathToJsonFile()));
            if (!file.exists()){
                Logger.printMessage("Nie znaleziono poprzedniej konfiguracji systemu, w związku z czym zostanie stworzona nowa.");
                Logger.logMessage("Brak zdefiniowanej konfiguracji systemu.");
                Logger.logMessage("Tworzenie pustej bazy...");
                return new GradeSystem();
            }

            String jsonFileContent = FileUtils.readFileToString(file, Charset.defaultCharset());
            Logger.logMessage("Readed JSON file end with success.");

            Logger.logMessage("Parsing JSON file...");
            GradeSystem gradeSystem = gson.fromJson(jsonFileContent, GradeSystem.class);
            Logger.logMessage("Parsing JSON file ended with success.");

            return gradeSystem;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logger.logErrorMessage("Loading grade system failed. Please, try again.");
        return null;
    }

    public static void save(GradeSystem system) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            String json = gson.toJson(system);
            File file = new File(String.format("%s\\gradeSystem.GradeSystem.json", ConfigManager.getPathToJsonFile()));
            FileUtils.writeStringToFile(file, json, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

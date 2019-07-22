package fileManager;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import gradeSystem.GradeSystem;
import gradeSystem.users.User;
import gradeSystem.users.student.StudentImpl;
import gradeSystem.users.teacher.TeacherImpl;
import org.apache.commons.io.FileUtils;
import utils.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class JsonManager {
    public static void main(String[] args) {
        GradeSystem gradeSystem = load();
        save(gradeSystem);
    }

    public static GradeSystem load() {
        Logger.logMessage("Preparing system...");

        List<StudentImpl> students = loadStudents();
        List<TeacherImpl> teachers = loadTeachers();

        Logger.logMessage("Preparing system end successfully.");
        return new GradeSystem(students, teachers);
    }

    private static List<StudentImpl> loadStudents() {
        Type type = new TypeToken<List<StudentImpl>>(){}.getType();

        return deserialize("GS_students.json", type)
                .stream()
                .map(x -> (StudentImpl) x)
                .collect(Collectors.toList());
    }

    private static List<TeacherImpl> loadTeachers() {
        Type type = new TypeToken<List<TeacherImpl>>(){}.getType();

        return deserialize("GS_teachers.json", type)
                .stream()
                .map(x -> (TeacherImpl) x)
                .collect(Collectors.toList());
    }

    private static List<User> deserialize(String fileName, Type type){
        Logger.logMessage(String.format("Loading \"%s\" JSON file...", fileName));
        Gson gson = new Gson();
        try {
            File file = new File(String.format("%s\\%s", ConfigManager.getPathToJsonFile(), fileName));
            if (!file.exists()){
                Logger.printMessage("Nie znaleziono poprzedniej konfiguracji systemu, w związku z czym zostanie stworzona nowa.");
                Logger.logMessage(String.format("No file found: %s", fileName));
                Logger.logMessage("Tworzenie pustej bazy...");
                return new ArrayList<>();
            }

            String jsonFileContent = FileUtils.readFileToString(file, Charset.defaultCharset());
            Logger.logMessage("Readed JSON file end with success.");

            Logger.logMessage("Parsing JSON file...");
            List<User> userList = gson.fromJson(jsonFileContent, type);
            Logger.logMessage("Parsing JSON file ended with success.");

            return userList;
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logger.logErrorMessage("Loading grade system failed. Please, try again.");
        return null;
    }

    public static void save(GradeSystem gradeSystem) {
        saveStudentsToJson(gradeSystem.getStudentsList());
        saveTeachersToJson(gradeSystem.getTeachersList());
    }

    public static void saveStudentsToJson(List<StudentImpl> students){
        serialize("GS_students.json",
                students.stream().map(x -> (User) x).collect(Collectors.toList()),
                new TypeToken<List<StudentImpl>>(){}.getType());
    }


    public static void saveTeachersToJson(List<TeacherImpl> teachers){
        serialize("GS_teachers.json",
                teachers.stream().map(x -> (User) x).collect(Collectors.toList()),
                new TypeToken<List<StudentImpl>>(){}.getType());
    }

    private static void serialize(String fileName, List<User> system, Type type){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            String json = gson.toJson(system, type);
            File file = new File(String.format("%s\\%s", ConfigManager.getPathToJsonFile(), fileName));
            FileUtils.writeStringToFile(file, json, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package testHelpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fileManager.JsonManager;
import gradeSystem.users.teacher.TeacherImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExampleTeacherCreator {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<TeacherImpl> teachers = createExampleTeachers();
        Type listOfTestObject = new TypeToken<List<TeacherImpl>>(){}.getType();
        String json = gson.toJson(teachers);
        System.out.println(json);
        JsonManager.saveTeachersToJson(teachers);
        List<TeacherImpl> teachers1 = gson.fromJson(json, listOfTestObject);
        System.out.println();
    }

    public static List<TeacherImpl> createExampleTeachers(){
        List<TeacherImpl> teachers = new ArrayList<>();

        teachers.add(new TeacherImpl("Janusz", "Ryk", "123"));
        teachers.add(new TeacherImpl("Kazik", "Struś", "123"));
        teachers.add(new TeacherImpl("Antonio", "Bandera", "123"));

        return teachers;
    }
}

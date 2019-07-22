package TestUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import gradeSystem.users.student.StudentImpl;
import gradeSystem.users.teacher.TeacherImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ExampleTeacherCreator {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<TeacherImpl> teachers = createExampleTeachers();
        Type listOfTestObject = new TypeToken<List<TeacherImpl>>(){}.getType();
        String json = gson.toJson(teachers);
        System.out.println(json);

        List<TeacherImpl> teachers1 = gson.fromJson(json, listOfTestObject);
        System.out.println();
    }

    public static List<TeacherImpl> createExampleTeachers(){
        List<TeacherImpl> teachers = new ArrayList<>();

        teachers.add(new TeacherImpl("Janusz", "R", "123"));
        teachers.add(new TeacherImpl("Kozak", "S", "123"));
        teachers.add(new TeacherImpl("Dupa", "T", "123"));

        return teachers;
    }
}

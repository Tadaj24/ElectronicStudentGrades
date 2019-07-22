package testHelpers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import fileManager.JsonManager;
import gradeSystem.subjects.Subject;
import gradeSystem.subjects.SubjectName;
import gradeSystem.subjects.grades.Grade;
import gradeSystem.users.student.StudentImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class ExampleStudentCreator {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<StudentImpl> students = createExampleStudents();
        Type listOfTestObject = new TypeToken<List<StudentImpl>>(){}.getType();
        String json = gson.toJson(students);
        System.out.println(json);
        JsonManager.saveStudentsToJson(students);
        List<StudentImpl> students1 = gson.fromJson(json, listOfTestObject);

        System.out.println(json);
    }

    public static List<StudentImpl> createExampleStudents(){
        List<StudentImpl> students = new ArrayList<>();

        students.add(createStudent("Piotr", "Rudy", "123"));
        students.add(createStudent("Ryszard", "Sadza", "123"));
        students.add(createStudent("Brajan", "Teraz", "123"));

        return students;
    }


    private static StudentImpl createStudent(String firstName, String secondName, String password) {
        Random random = new Random();
        HashSet<Subject> list = new HashSet<>();
        for (SubjectName value : SubjectName.values()) {
            Grade[] grades = new Grade[3];
            for (int i = 0; i < 3; i++) {
                grades[i] = new Grade(random.nextInt() % 5 + 1, random.nextInt() % 3 + 1);
            }

            list.add(new Subject(value, grades));
        }

        StudentImpl student = new StudentImpl(firstName, secondName, password, list);
        return student;
    }
}

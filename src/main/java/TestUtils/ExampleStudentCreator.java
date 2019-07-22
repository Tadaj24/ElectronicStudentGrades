package TestUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
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
        Gson gson = new Gson();
        List<StudentImpl> students = createExampleStudents();
        Type listOfTestObject = new TypeToken<List<StudentImpl>>(){}.getType();
        String json = gson.toJson(students);
        System.out.println(json);

        List<StudentImpl> students1 = gson.fromJson(json, listOfTestObject);
        System.out.println();
    }

    public static List<StudentImpl> createExampleStudents(){
        List<StudentImpl> students = new ArrayList<>();

        students.add(createStudent("Blazej", "R", "123"));
        students.add(createStudent("Wojtek", "S", "123"));
        students.add(createStudent("Kamil", "T", "123"));

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

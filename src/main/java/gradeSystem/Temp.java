package gradeSystem;

import com.google.gson.Gson;
import gradeSystem.GradeSystem;
import gradeSystem.subjects.Subject;
import gradeSystem.subjects.SubjectName;
import gradeSystem.subjects.grades.Grade;
import gradeSystem.users.student.StudentImpl;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Temp {
    public static void main(String[] args) {
        Gson gson = new Gson();
        List<StudentImpl> students = new ArrayList<>();

        students.add(createStrudent("Adam", "Be", "123"));
        students.add(createStrudent("Adamek", "Beadsad", "123"));
        students.add(createStrudent("Adamas", "Beed", "123"));

        String json = gson.toJson(new GradeSystem());
        System.out.println(json);

        List<StudentImpl> students1 = gson.fromJson(json, (Type) StudentImpl.class);
    }

    public static List<StudentImpl> getSimpleStudents(){
        List<StudentImpl> students = new ArrayList<>();

        students.add(createStrudent("Blazej", "R", "123"));
        students.add(createStrudent("Wojtek", "S", "123"));
        students.add(createStrudent("Kamil", "T", "123"));

        return students;
    }


    private static StudentImpl createStrudent(String firstName, String secondName, String password) {
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

import com.google.gson.Gson;
import subjects.Subject;
import subjects.SubjectName;
import subjects.grades.Grade;
import subjects.grades.GradeWeight;
import users.student.Student;
import users.student.StudentImpl;

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

        String json = gson.toJson(students);
        System.out.println(json);

        List<StudentImpl> students1 = gson.fromJson(json, (Type) StudentImpl.class);


    }

    public static List<StudentImpl> getSimpleStudents(){
        List<StudentImpl> students = new ArrayList<>();

        students.add(createStrudent("Adam", "Be", "123"));
        students.add(createStrudent("Adamek", "Beadsad", "123"));
        students.add(createStrudent("Adamas", "Beed", "123"));

        return students;
    }


    private static StudentImpl createStrudent(String firstName, String secondName, String password) {
        Random random = new Random();
        HashSet<Subject> list = new HashSet<>();
        for (SubjectName value : SubjectName.values()) {
            Grade[] grades = new Grade[3];
            for (int i = 0; i < 3; i++) {
                grades[i] = new Grade(random.nextInt() % 6 + 1, random.nextInt() % 3 + 1);
            }

            list.add(new Subject(value, grades));
        }

        StudentImpl student = new StudentImpl(firstName, secondName, password, list);
        return student;
    }
}
/*

    HashSet<Subject> lista = new HashSet<>();
        lista.add(new Subject(SubjectName.History,
                new Grade(1, GradeWeight.ONE),
                new Grade(2, GradeWeight.TWO),
                new Grade(3, GradeWeight.THREE)));
                lista.add(new Subject(SubjectName.Matematic,
                new Grade(11, GradeWeight.ONE),
                new Grade(31, GradeWeight.THREE)));
                lista.add(new Subject(SubjectName.Polish,
                new Grade(2311, GradeWeight.THREE)));
                StudentImpl student = new StudentImpl("Adam", "Kowalski", "123", lista);*/

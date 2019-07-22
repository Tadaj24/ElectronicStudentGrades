package gradeSystem;

import gradeSystem.users.User;
import gradeSystem.users.student.StudentImpl;
import gradeSystem.users.teacher.TeacherImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeSystem {
    List<StudentImpl> studentsList;
    List<TeacherImpl> teachersList;

    public ArrayList<String> returnListOfUsers() {
        Stream<String> studentsLogin = studentsList.stream().map(x -> x.toString());
        Stream<String> teachersLogin = teachersList.stream().map(x -> x.toString());

        AtomicInteger index = new AtomicInteger(1);

        return (ArrayList<String>) Stream.concat(studentsLogin, teachersLogin)
                .sorted()
                .map(x -> String.format("%s) %s", index.getAndIncrement(), x))
                .collect(Collectors.toList());
    }

    public ArrayList<User> getListOfAllUsers() {
        Stream<User> studentsLogin = studentsList.stream().map(x -> (User) x);
        Stream<User> teachersLogin = teachersList.stream().map(x -> (User) x);

        AtomicInteger index = new AtomicInteger(1);

        return (ArrayList<User>) Stream.concat(studentsLogin, teachersLogin)
                .collect(Collectors.toList());
    }

    public GradeSystem(List<StudentImpl> studentsList, List<TeacherImpl> teachersList) {
        this.studentsList = studentsList;
        this.teachersList = teachersList;
    }

    public List<StudentImpl> getStudentsList() {
        return studentsList;
    }

    public List<TeacherImpl> getTeachersList() {
        return teachersList;
    }
}

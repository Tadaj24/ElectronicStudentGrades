package gradeSystem;

import gradeSystem.users.student.StudentImpl;
import gradeSystem.users.teacher.TeacherImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradeSystem {
    List<StudentImpl> studentsList = new ArrayList<>();
    List<TeacherImpl> teachersList = new ArrayList<>();

    public ArrayList<String> returnListOfUsers(){
        Stream<String> studentsLogins = studentsList
                .stream()
                .map(x -> x.toString());

/*        Stream<String> techersLogins = teachersList
                .stream()
                .map(x -> x.toString());*/

        AtomicInteger index = new AtomicInteger(1);

//        return (ArrayList<String>) Stream.concat(studentsLogins, techersLogins)
        return (ArrayList<String>) studentsLogins
                .sorted()
                .map(x -> String.format("%s) %s", index.getAndIncrement(), x))
                .collect(Collectors.toList());
    }


    public List<StudentImpl> getStudentsList() {
        return studentsList;
    }

    public List<TeacherImpl> getTeachersList() {
        return teachersList;
    }
}

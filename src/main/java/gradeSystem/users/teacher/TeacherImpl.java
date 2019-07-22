package users.teacher;

import subjects.SubjectName;
import subjects.grades.Grade;
import users.User;
import users.student.StudentImpl;

public class TeacherImpl extends User implements Teacher {
    public TeacherImpl(String firstName, String secondName, String password) {
        super(firstName, secondName, password, "Nauczyciel");
    }

    public void printStudentGrades(StudentImpl student) {

    }

    public void addGrade(StudentImpl student, SubjectName subjectName, Grade grade) {

    }
}

package gradeSystem.users.teacher;

import gradeSystem.subjects.SubjectName;
import gradeSystem.subjects.grades.Grade;
import gradeSystem.users.User;
import gradeSystem.users.student.StudentImpl;

public class TeacherImpl extends User implements Teacher {
    public TeacherImpl(String firstName, String secondName, String password) {
        super(firstName, secondName, password, "Nauczyciel");
    }

    public void printStudentGrades(StudentImpl student) {

    }

    public void addGrade(StudentImpl student, SubjectName subjectName, Grade grade) {

    }
}

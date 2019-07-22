package users.teacher;

import subjects.SubjectName;
import subjects.grades.Grade;
import users.student.StudentImpl;

public interface Teacher {
    void printStudentGrades(StudentImpl student);
    void addGrade(StudentImpl student, SubjectName subjectName, Grade grade);
}

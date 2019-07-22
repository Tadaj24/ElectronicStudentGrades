package gradeSystem.users.teacher;

import gradeSystem.subjects.SubjectName;
import gradeSystem.subjects.grades.Grade;
import gradeSystem.users.student.StudentImpl;

public interface Teacher {
    void printStudentGrades(StudentImpl student);
    void addGrade(StudentImpl student, SubjectName subjectName, Grade grade);
}

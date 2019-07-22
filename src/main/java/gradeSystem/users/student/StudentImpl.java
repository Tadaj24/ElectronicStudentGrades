package users.student;

import subjects.Subject;
import subjects.SubjectName;
import users.User;

import java.util.HashSet;

public class StudentImpl extends User implements Student{
    HashSet<Subject> subjectsList;

    public StudentImpl(String firstName, String secondName, String password) {
        super(firstName, secondName, password, "Student");
        addDefualtGradesToList();
    }

    public StudentImpl(String firstName, String secondName, String password, HashSet<Subject> subjectsList) {
        super(firstName, secondName, password, "Student");
        this.subjectsList = subjectsList;
        addDefualtGradesToList();
    }

    public void printGrades() {

    }

    private void addDefualtGradesToList(){
        if (subjectsList == null){
            subjectsList = new HashSet<>();
        }

        for (SubjectName value : SubjectName.values()) {
            subjectsList.add(new Subject(value));
        }
    }
}

package gradeSystem.subjects;

import gradeSystem.subjects.grades.Grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Subject {
    SubjectName subjectName;
    List<Grade> gradeList;

    public Subject(SubjectName subjectName) {
        this.subjectName = subjectName;
        gradeList = new ArrayList<>();
    }

    public Subject(SubjectName subjectName, Grade... grades) {
        this.subjectName = subjectName;
        gradeList = new ArrayList<>();

        if (grades.length == 0) {
            return;
        }

        for (Grade grade : grades) {
            gradeList.add(grade);
        }
    }

    public void addGradeToList(Grade grade) {
        gradeList.add(grade);
    }

    @Override
    public String toString() {
        return String.format("%s: %s;",
                subjectName.toString(),
                gradeList.stream().map(x -> x.toString()).collect(Collectors.joining(", ")));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subject subject = (Subject) o;
        return subjectName == subject.subjectName;
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName.name);
    }
}

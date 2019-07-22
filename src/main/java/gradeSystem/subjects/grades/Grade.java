package subjects.grades;

import lombok.*;
import subjects.SubjectName;

@EqualsAndHashCode
@Getter(AccessLevel.PUBLIC)
@Setter(AccessLevel.PRIVATE)
public class Grade {
    double value;
    GradeWeight weight;

    public Grade(double value, GradeWeight weight) {
        this.value = value;
        this.weight = weight;
    }

    public Grade(double value, int weight) {
        this.value = value;
        this.weight = GradeWeight.fromInteger(weight);
    }

    public void modifiedGrade(double newValue, GradeWeight newWeight) {
        this.value = newValue;
        this.weight = newWeight;
    }

    public void modifiedGrade(double newValue) {
        modifiedGrade(newValue, weight);
    }

    public void modifiedGrade(GradeWeight newWeight) {
        modifiedGrade(value, newWeight);
    }


    @Override
    public String toString() {
        return String.format("%s wagi @s", value, weight);
    }

}

package gradeSystem.subjects.grades;

public enum GradeWeight {
    ONE(1),
    TWO(2),
    THREE(3);

    int priority;

    GradeWeight(int priority) {
        this.priority = priority;
    }

    public static GradeWeight fromInteger(int x) {
        switch(x) {
            case 1:
                return ONE;
            case 2:
                return TWO;
            default: return THREE;
        }
    }
}

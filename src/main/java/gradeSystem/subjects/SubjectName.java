package gradeSystem.subjects;

public enum SubjectName {
    Polish("Polski"),
    Matematic("Matematyka"),
    History("Historia");

    String name;

    SubjectName(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}

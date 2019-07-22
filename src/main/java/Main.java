/*                          Elektroniczny system oceniania

  Zarządzanie wstawianiem i wyświetlaniem ocen cząstkowych z różnych przedmiotów. Uprawniony
  użytkownik może wstawiać oceny, a student może tylko je wyświetlać. Tworzenie raportów i
  statystyk, itp
  */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;
import fileManager.ReadFile;
import subjects.Subject;
import subjects.SubjectName;
import subjects.grades.Grade;
import subjects.grades.GradeWeight;
import users.User;
import users.student.StudentImpl;
import users.teacher.TeacherImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        //ReadFile.getAllUsersFromFile();


        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        GradeSystem gradeSystem = new GradeSystem();

        String json = gson.toJson(gradeSystem);
        System.out.println(json);

        GradeSystem g2 = gson.fromJson(json, GradeSystem.class);
        System.out.println();
    }
}


package stream.listToMap;

import stream.filterSchoolboy.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class listToMap {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
            students.add(new Student(10, "Surname1"));
            students.add(new Student(20, "Surname2"));
            students.add(new Student(30, "Surname3"));
            students.add(new Student(40, "Surname4"));
            students.add(new Student(50, "Surname5"));
            students.add(new Student(60, "Surname6"));
            students.add(new Student(70, "Surname7"));
            students.add(new Student(80, "Surname8"));
            students.add(new Student(90, "Surname9"));

           Map<Integer,String> map = students.stream()
                   .collect(Collectors.toMap(
                           e->e.getScore(),
                           e->e.getSurname()
                   ));
        System.out.println(map);
        }
    }


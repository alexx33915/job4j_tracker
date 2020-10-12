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
        students.add(new Student(20, "Surname1"));

        System.out.println(listToMap(students));
    }

    static Map<String, Integer> listToMap(List<Student> students) {
        Map<String, Integer> map = students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname,
                        Student::getScore,
                        (a,b) -> a+b
                ));
        return map;
    }
}



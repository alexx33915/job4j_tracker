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

    static Map<String, Student> listToMap(List<Student> students) {
        Map<String, Student> map = students.stream()
                .collect(Collectors.toMap(
                       e -> e.getSurname(),
                       e->e,
                        (a,b) -> a
                ));
        return map;
    }
}



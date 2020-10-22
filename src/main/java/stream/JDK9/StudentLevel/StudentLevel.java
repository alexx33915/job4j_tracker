package stream.JDK9.StudentLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .filter(st -> st != null)
                .sorted((left, right) -> right.getScore() -left.getScore())
                .takeWhile(st ->st.getScore() > bound)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Student> input = new ArrayList<>();
        input.add(new Student("Masha", 28));
        input.add(new Student("Pety", 128));




    }
}
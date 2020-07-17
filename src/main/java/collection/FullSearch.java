package collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task2> list) {
        HashSet<String> numbers = new HashSet<>();
        // for-each
        for (Task2 task2 :list) {
           numbers.add(task2.getNumber());
        }
        return numbers;
    }
}
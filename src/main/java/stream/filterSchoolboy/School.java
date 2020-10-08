package stream.filterSchoolboy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public  class School {
    List<Student> collect(List<Student> students, Predicate<Student> predict) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (predict.test(student)) {
                result.add(student);
            }
        }
        return result;
    }
}

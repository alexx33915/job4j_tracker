package stream.JDK9.StudentLevel;

import java.util.Comparator;

public class StudentCompare implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getScore()-o2.getScore();
    }
}

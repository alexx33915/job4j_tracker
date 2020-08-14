package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("AAA", 6),
                new Job("ZZZ", 3),
                new Job("AAA", 2),
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 4)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));

        for (Job job : jobs) {
            System.out.println(job);
        }
    }
}
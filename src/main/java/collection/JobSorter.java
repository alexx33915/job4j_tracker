package collection;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JobSorter {
    public static void main(String[] args) {
    /*    List<Job> jobs = Arrays.asList(
                new Job("AAA", 6),
                new Job("ZZZ", 3),
                new Job("AAA", 2),
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 4)
        );
// Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobAscByPriority()));
*/

        List<Job> jobs = Arrays.asList(
                new Job("AAA", 6),
                new Job("ZZZ", 3),
                new Job("AAA", 2),
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 4)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
      //  assertThat(jobs.get(0).getName(), Matchers.is("AAA"));
       // assertThat(jobs.get(0).getPriority(), Matchers.is(2));




        for (Job job : jobs) {
            System.out.println(job);
        }

    }
}
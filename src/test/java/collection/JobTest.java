package collection;

import static org.junit.Assert.*;
import org.hamcrest.Matchers;
import org.junit.Test;
import java.util.*;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class JobTest {
    @Test
     public void testComparatorJobDescByName() {
        List<Job> jobs = Arrays.asList(
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 2)
        );
        JobDescByName jdbn = new JobDescByName();
        jobs.sort(jdbn);
        Iterator<Job> it = jobs.iterator();
        assertThat(it.next(), is(new Job("ZZZ", 4)));
        assertThat(it.next(), is(new Job("CCC", 1)));
        assertThat(it.next(), is( new Job("AAA", 2)));
    }
    @Test
    public void testComparatorJobAscByName() {
        List<Job> jobs = Arrays.asList(
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 2)
        );
        JobAscByName jabn = new JobAscByName();
        jobs.sort(jabn);
        assertThat(jobs.get(0).getName(), Matchers.is("AAA"));
    }
    @Test
    public void testComparatorJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 2)
        );
        JobAscByPriority p = new JobAscByPriority();
        jobs.sort(p);
        assertThat(jobs.get(0).getPriority(), Matchers.is(1));
    }
    @Test
    public void testComparatorJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 2)
        );
        JobDescByPriority p = new JobDescByPriority();
        jobs.sort(p);
        assertThat(jobs.get(0).getPriority(), Matchers.is(4));
    }

    @Test
    public void testComparatorJobAscByNameAndJobAscByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("AAA", 6),
                new Job("ZZZ", 3),
                new Job("AAA", 2),
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 4)
        );
        Collections.sort(jobs, new JobAscByName().thenComparing(new JobAscByPriority()));
        assertThat(jobs.get(0).getName(), Matchers.is("AAA"));
        assertThat(jobs.get(0).getPriority(), Matchers.is(2));
    }

    @Test
    public void testComparatorJobDescByNameAndJobDescByPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("AAA", 6),
                new Job("ZZZ", 3),
                new Job("AAA", 2),
                new Job("CCC", 1),
                new Job("ZZZ", 4),
                new Job("AAA", 4)
        );
        Collections.sort(jobs, new JobDescByName().thenComparing(new JobDescByPriority()));
        assertThat(jobs.get(0).getName(), Matchers.is("ZZZ"));
        assertThat(jobs.get(0).getPriority(), Matchers.is(4));
    }
}
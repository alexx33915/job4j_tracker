package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.IsNull.nullValue;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);

        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void testfindAll() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);

        Item item2 = new Item("test2");
        tracker.add(item2);

        Item[] result = tracker.findAll();
        assertThat(result[0].getName(), is("test1"));
    }

    @Test
    public void testfindByName() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1");
        tracker.add(item);

        Item item2 = new Item("test2");
        tracker.add(item2);

        Item[] result = tracker.findByName("test2");
        assertThat(result[0].getName(), is("test2"));
    }

    @Test
    public void whenReplace() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        Item bugWithDesc = new Item("Bug with description");

        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }


    @Test
    public void whenDelete() {
        Tracker tracker = new Tracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = bug.getId();
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
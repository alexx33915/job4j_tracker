package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        UserAction action = new CreateAction();
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
         action.execute(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem(){

        UserAction action = new EditItemAction();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(), // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        action.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem(){
        UserAction action = new DeleteItemAction();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = { item.getId() };
        action.execute(new StubInput(answers), tracker);
        Item delete = tracker.findById(item.getId());
        Item item3 = null;
        assertThat(delete, is( item3));
    }
    @Test
    public void whenExit() {
        StubInput input = new StubInput(  new String[] {"0"}  );
        StubAction action = new StubAction();
        new StartUI().init(input, new Tracker(), new UserAction[] { action });
        assertThat(action.isCall(), is(true));
    }
}
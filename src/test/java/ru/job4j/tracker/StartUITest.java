package ru.job4j.tracker;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import static java.lang.System.lineSeparator;
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

       // Item created = tracker.findAll()[0];
        Item created = tracker.findAll().get(0);
        Item expected = new Item("Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }

    @Test
    public void whenReplaceItem() {

        UserAction action = new EditItemAction();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {
                item.getId(),     // id сохраненной заявки в объект tracker.
                "replaced item"
        };
        action.execute(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        UserAction action = new DeleteItemAction();
        Tracker tracker = new Tracker();
        Item item = new Item("new item");
        tracker.add(item);
        String[] answers = {item.getId()};
        action.execute(new StubInput(answers), tracker);
        Item delete = tracker.findById(item.getId());
        Item item3 = null;
        assertThat(delete, is(item3));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> listAction =new ArrayList<>();
        listAction.add(action);
        new StartUI(out).init(input, new Tracker(), listAction);
        assertThat(action.isCall(), is(true));
    }

    /*@Test
    public void whenPrtMenu() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;        // System.out;
        System.setOut(new PrintStream(out));

        StubInput input = new StubInput(new String[]{"0"});
        StubAction action = new StubAction();
        List<UserAction> listAction =new ArrayList<>();
        listAction.add(action);
        new StartUI().init(input, new Tracker(), listAction);
        String expect = new StringJoiner(lineSeparator(), "", lineSeparator())
                .add("Menu.")
                .add("0. Stub action")
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }*/

    @Test
    public void findAllActionTest() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);

        ShowAllAction act = new ShowAllAction();
        act.execute(new StubInput(new String[]{}), tracker);

        String expect = new StringJoiner(lineSeparator(), "", lineSeparator())
                .add(" name = " + item.getName() + ", id = " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

    @Test
    public void findByNameAction() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream def = System.out;
        System.setOut(new PrintStream(out));

        Tracker tracker = new Tracker();
        Item item = new Item("fix bug");
        tracker.add(item);

        FindItemByNameAction act = new FindItemByNameAction();
        act.execute(new StubInput(new String[]{"fix bug"}), tracker);

        String expect = new StringJoiner(lineSeparator(), "", lineSeparator())
                .add(" name = " + item.getName() + ", id = " + item.getId())
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(def);
    }

  /*  @Test
    public void whenExitWihtOutput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<UserAction>();
        actions.add(new ExitProgramAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu.\\r\\n0. Exit" + lineSeparator()));
    }*/

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"5", "0"}
        );
        Tracker tracker = new Tracker();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitProgramAction());

        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                String.format(
                        "Menu.%n"
                                + "0. Exit%n"
                                + "Wrong input, you can select: 0 .. 0%n"
                                + "Menu.%n"
                                + "0. Exit%n"
                )
                )
        );
    }


    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[]{"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

}
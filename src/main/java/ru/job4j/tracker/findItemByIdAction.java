package ru.job4j.tracker;

public class findItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter id: ");
        Item tmp = tracker.findById(name);
        if (tmp == null) {
            System.out.println("application not found");
        } else {
            System.out.println(tmp);
        }
        return true;
    }
}

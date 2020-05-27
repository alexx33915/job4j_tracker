package ru.job4j.tracker;

public class deleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter id: ");
        if (tracker.delete(name)) {
            System.out.println("application successfully delete");
        } else {
            System.out.println("the application is not delete ");
        }
        return true;
    }
}

package ru.job4j.tracker;

public class EditItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter id: ");
        String name2 = input.askStr("Enter New Item: ");
        Item item = new Item(name2);
        if (tracker.replace(name, item)) {
            System.out.println("application successfully changed");
        } else {
            System.out.println("the application is not changed");
        }
        return true;
    }
}

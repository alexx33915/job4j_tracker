package ru.job4j.tracker;

public class findItemByNameAction implements UserAction {
    @Override
    public String name() {
        return"=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        if (result.length != 0) {

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        } else {
            System.out.println("application not found");
        }
        return true;
    }
}

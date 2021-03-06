package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> result = tracker.findByName(name);
        if (result.size() != 0) {

            for (Item i : result) {
                System.out.println(i);
            }
        } else {
            System.out.println("application not found");
        }
        return true;
    }
}

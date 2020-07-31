package ru.job4j.tracker;

import java.util.Collections;
import java.util.List;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> result = tracker.findAll();

        for(Item i: result){
            System.out.println(i);
        }
        return true;
    }
}

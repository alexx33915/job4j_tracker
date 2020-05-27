package ru.job4j.tracker;

public class showAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] result = tracker.findAll();

        for(Item i: result){
            System.out.println(i);
        }
        //for (int i = 0; i < result.length; i++) {
         //   System.out.println(result[i]);
       // }
        return true;
    }
}

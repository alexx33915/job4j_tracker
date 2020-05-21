package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Show all items ====");
        Item[] result = tracker.findAll();
        for (int i = 0; i < result.length; i++) {

            System.out.println(result[i]);
        }
    }

    public static void editItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Edit item ===");
        String name = input.askStr("Enter id: ");
        String name2 = input.askStr("Enter New Item: ");
        Item item = new Item(name2);
        if (tracker.replace(name, item)) {
            System.out.println("application successfully changed");
        } else {
            System.out.println("the application is not changed");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Delete item ===");
        String name = input.askStr("Enter id: ");
        if (tracker.delete(name)) {
            System.out.println("application successfully delete");
        } else {
            System.out.println("the application is not delete ");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Find item by Id ===");
        String name = input.askStr("Enter id: ");
        Item tmp = tracker.findById(name);
        if (tmp == null) {
            System.out.println("application not found");
        } else {
            System.out.println(tmp);
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println();
        System.out.println("=== Find items by name ===");
        String name = input.askStr("Enter name: ");
        Item[] result = tracker.findByName(name);
        if (result.length != 0) {

            for (int i = 0; i < result.length; i++) {
                System.out.println(result[i]);
            }
        } else {
            System.out.println("application not found");
        }
    }

    public void init(Input input, Tracker tracker) {

        boolean run = true;
        while (run) {
            this.showMenu();

            int select = input.askInt("Select:");
            switch (select) {
                case (0):
                    StartUI.createItem(input, tracker);
                    break;
                case (1):
                    StartUI.showAllItems(input, tracker);
                    break;
                case (2):
                    StartUI.editItem(input, tracker);
                    break;
                case (3):
                    StartUI.deleteItem(input, tracker);
                    break;
                case (4):
                    StartUI.findItemById(input, tracker);
                    break;
                case (5):
                    StartUI.findItemByName(input, tracker);
                    break;
                case (6):
                    System.out.println();
                    System.out.println("Exit");
                    run = false;
                    break;
                default:
                    System.out.println();
                    System.out.println("select item (0-6) ");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println();
        System.out.println("Menu.");
        System.out.println("0. Add new Item ");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
    }


    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }

}
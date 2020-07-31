package ru.job4j.tracker;

import java.util.Comparator;

public class ItemSortByNameAscending implements Comparator<Item> {
    @Override
    public int compare(Item o1, Item o2) {
        if (o1.getName().equals( o2.getName())) {
            return 0;
        }
        if (o1.getName().compareTo(o2.getName())>0) {
            return 1;
        }
        else {
            return -1;
        }
    }
}

package collection.SortByNumber_4;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] o1split = o1.split("\\.");
        String[] o2split = o2.split("\\.");
        return Integer.parseInt(o1split[0])-Integer.parseInt(o2split[0]);
    }
}

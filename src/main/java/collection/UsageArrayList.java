package collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> strs = new ArrayList<String>();
        strs.add("Petr");
        strs.add("Ivan");
        strs.add("Stepan");

        for (String s : strs) {
            System.out.println(s);
        }


    }
}

package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {

        String[] masStr1 = o1.split("/", 2);
        String[] masStr2 = o2.split("/", 2);

        int rsl = masStr2[0].compareTo(masStr1[0]);
        return rsl == 0 ? o1.compareTo(o2) : rsl;
    }
}















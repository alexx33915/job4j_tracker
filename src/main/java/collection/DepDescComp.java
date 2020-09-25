package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] masStr1 = o1.split("/", 2);
        String[] masStr2 = o2.split("/", 2);


        int rsl = masStr1[0].compareTo(masStr2[0]);
        if (rsl > 0) {
            return -1;
        } else if (rsl < 0) {
            return 1;
        } else {

            if (masStr1.length == 1 || masStr2.length == 1) {
                return masStr1.length > masStr2.length ? 1 : -1;
            }

            int rsl2 = masStr1[1].compareTo(masStr2[1]);
            if (rsl2 > 0) {
                return 1;
            } else if (rsl2 < 0) {
                return -1;
            }
        }
        return 0;
    }
}















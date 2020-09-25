package collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String[] masStr1 = o1.split("/", 2);
        String[] masStr2 = o2.split("/", 2);
        if (masStr1.length == 1 || masStr2.length == 1) {
            int result = masStr1[0].compareTo(masStr2[0]);
            if (result > 0) {
                return -1;
            } else if (result < 0) {
                return 1;
            } else {
                return masStr1.length > masStr2.length ? 1 : -1;
            }
        } else if (masStr1[0].equals(masStr2[0])) {
            if (!masStr1[1].equals(masStr2[1])) {
                int result = masStr1[1].compareTo(masStr2[1]);
                if (result > 0) {
                    return 1;
                } else {
                    return -1;
                }
            }
        } else {
            int result = masStr1[0].compareTo(masStr2[0]);
            if (result > 0) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}















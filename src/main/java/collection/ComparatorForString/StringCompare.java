package collection.ComparatorForString;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        if (o1.length() == o2.length()) {
            for (int i = 0; i < o2.length(); i++) {
                int result = Integer.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            return 0;
        }
        if (o1.length() > o2.length()) {
            for (int i = 0; i < o2.length(); i++) {
                int result = Integer.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            return 1;
        } else {
            for (int i = 0; i < o1.length(); i++) {
                int result = Integer.compare(o1.charAt(i), o2.charAt(i));
                if (result != 0) {
                    return result;
                }
            }
            return -1;
        }
    }
}

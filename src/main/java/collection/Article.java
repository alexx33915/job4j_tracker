package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        origin=origin.replaceAll("\\p{P}", "");
        String[] original = origin.split(" ");
        String[] text = line.split(" ");

        Set<String> set = new HashSet<>();
        for (int i = 0; i < original.length; i++) {
            set.add( original[i]);
        }
        for (int j = 0; j < text.length; j++) {
            if (!set.contains(text[j])) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Article {
    public static boolean generateBy(String origin, String line) {
        boolean rsl = true;
        origin = origin.replace('.', ' ')
                       .replace('!', ' ')
                       .replace(',', ' ');
        String[] original = origin.split(" ");
        String[] text = line.split(" ");
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < original.length; i++) {
            map.put(i, original[i]);
        }
        for (int j = 0; j < text.length; j++) {
            String ss = text[j];
            if (!map.containsValue(ss)) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}

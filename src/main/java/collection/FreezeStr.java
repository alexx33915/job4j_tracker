package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        Map<Character, Integer> map1 = readString(left);
        Map<Character, Integer> map2 = readString(right);

        for (Map.Entry<Character, Integer> pair : map1.entrySet()) {
            if (map2.containsKey(pair.getKey())) {
                if (!map2.get(pair.getKey()).equals(pair.getValue())) {
                    rsl = false;
                }
            } else {
                rsl = false;
            }
        }
        return rsl;
    }

    static public Map<Character, Integer> readString(String left) {
        Map<Character, Integer> map = new HashMap<>();
        char[] charArray = left.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (map.containsKey(charArray[i])) {
                Integer value = map.get(charArray[i]);
                map.put(charArray[i], ++value);
            } else {
                map.put(charArray[i], 1);
            }
        }
        return map;
    }
}

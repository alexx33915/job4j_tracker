package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        boolean rsl = true;
        Map<Character, Integer> map1 = readString(left);
        for (int i = 0; i < right.length(); i++) {
            Character ch = right.charAt(i);
            if (map1.containsKey(ch)) {
                Integer value = map1.get(ch);
                if (value > 1) {
                    map1.put(ch, --value);
                } else {
                    map1.remove(ch);
                }
            } else {
                rsl = false;
                break;
            }
        }
        if (!(map1.size() == 0)) {
            rsl = false;
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

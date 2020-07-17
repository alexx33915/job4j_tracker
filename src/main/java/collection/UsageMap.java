package collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> adress = new HashMap<>();
        adress.put("sash-2007@yandex.ru", "Александр Копылов");

        for (String key : adress.keySet()) {
            String value = adress.get(key);
            System.out.println(key + " = " + value);
        }

    }
}

package collection;


import java.util.HashSet;

public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (int i = 0; i <origin.length ; i++) {
            check.add(origin[i]);
        }

        for (int i = 0; i < text.length; i++) {
            if(!check.contains(text[i]))
                return  false;
        }


        /* for-each origin -> new HashSet. */
        /* for-each text -> hashSet.contains */
        return rsl;
    }
}
package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConvertList {
    public static List<Integer> convert(List<int[]> list) {
        List<Integer> rsl = new ArrayList<>();

        Iterator <Integer> ii = rsl.iterator();
        while (ii.hasNext()){
           Integer tt = ii.next();

        }


        for (int[] row : list) {
            for (int cell : row) {
                rsl.add(cell);
            }
        }
        return rsl;
    }
}
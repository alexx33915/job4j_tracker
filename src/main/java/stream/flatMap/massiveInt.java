package stream.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class massiveInt {
    public static void main(String[] args) {
       int[][] nums = { { 0, 1, 2 }, { 3, 4, 5 } };

        System.out.println(
                String.valueOf(Arrays.stream(nums)
                .flatMapToInt(x -> Arrays.stream(x))
                .collect(
                        ()->new ArrayList<Integer>(),
                        (list, item)->list.add(item),
                        (list1, list2)-> list1.addAll(list2)
                        )
        ));
    }

}

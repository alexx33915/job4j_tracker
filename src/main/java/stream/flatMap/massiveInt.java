package stream.flatMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;

import static java.util.stream.Collectors.*;

public class massiveInt {
    public static void main(String[] args) {
        Integer[][] nums = {{0, 1, 2}, {3, 4, 5}};
        List<Integer> list = massiveToList(nums);
    }

    public static List<Integer> massiveToList(Integer[][] mas) {
        return Arrays.stream(mas)
                .flatMap(x -> Arrays.stream(x))
                .collect(Collectors.toList());
    }
}
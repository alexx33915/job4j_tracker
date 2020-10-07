package stream.streamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApi {
    public static void main(String[] args) {
        List<Integer> list =   Arrays.asList(1, 3, -5, 2, -3);
        List<Integer> istPositive = list.stream().filter(x -> x > 0).collect(Collectors.toList());
        System.out.println(istPositive);
    }
}

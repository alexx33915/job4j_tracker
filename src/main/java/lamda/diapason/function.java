package lamda.diapason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class function {
    public static List<Double> diapason(int a, int b, Function<Double, Double> func) {
        List<Double> list = new ArrayList<>();
        for (int i = a; i <= b; i++) {
            list.add(func.apply((double) i));
        }
        return list;
    }
}













package lamda.diapason;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class daopasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D, 17D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadraticFunctionQuadraticResults() {
        List<Double> result = function.diapason(2, 5, x -> x*x + 1);
        List<Double> expected = Arrays.asList(5D, 10D, 17D, 26D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentiaFunctionExponentialResults() {
        List<Double> result = function.diapason(0, 5, x -> Math.pow(5,x)+4 );
        List<Double> expected = Arrays.asList(5D, 9D, 29D, 129D, 629D,3129D) ;
        assertThat(result, is(expected));
    }
}
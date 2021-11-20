package problems;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RabbitsInForest {

    public static void main(String[] args) {
//        System.out.println(numRabbits(new int[]{1, 1, 2}));
        System.out.println(numRabbits(new int[]{10, 10, 10}));

    }

    public static int numRabbits(int[] answers) {
        return Arrays
                .stream(answers)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .reduce(0, (a, c) -> a + getMinimumRabbits(c), Integer::sum);

    }

    private static int getMinimumRabbits(Map.Entry<Integer, Long> c) {
        int key = c.getKey();
        int value = c.getValue().intValue();

        if (key + 1 == value) {
            return value;
        }

        if (key + 1 > value) {
            return key + 1;
        }
        key = key + 1;
        return (value / key) * key + Math.min(value % key, 1) * key;

    }

}

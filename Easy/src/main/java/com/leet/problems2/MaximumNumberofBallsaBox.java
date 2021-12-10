package com.leet.problems2;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MaximumNumberofBallsaBox {
    public static void main(String[] args) {
        System.out.println(new MaximumNumberofBallsaBox().countBalls(19,28));
    }


    public int countBalls(int lowLimit, int highLimit) {
        return IntStream
                .range(lowLimit, highLimit + 1)
                .map(this::sumOfDigits)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .max()
                .orElse(0);
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}

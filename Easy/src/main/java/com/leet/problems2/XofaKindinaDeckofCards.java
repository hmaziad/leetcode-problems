package com.leet.problems2;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class XofaKindinaDeckofCards {
    public static void main(String[] args) {

        System.out.println(new XofaKindinaDeckofCards().hasGroupsSizeX(new int[]{1,1,2,2,2,2,2,2}));
    }
    public boolean hasGroupsSizeX(int[] deck) {

        return Arrays
                .stream(deck)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values()
                .stream()
                .mapToInt(Long::intValue)
                .reduce(this::gcd)
                .orElse(0) > 1;
    }

    private int gcd(int a, int b) {
        return b > 0 ? gcd(b, a % b) : a;
    }
}

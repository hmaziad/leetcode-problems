package com.leet.problems;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {

    }

    public int findLHS(int[] nums) {

        var counts = Arrays
                .stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        int maxCount = 0;

        for (var entry : counts.entrySet()) {
            if (counts.containsKey(entry.getKey() + 1)) {
                maxCount = Math.max(maxCount, (int) (entry.getValue() + counts.get(entry.getKey() + 1)));
            }
        }

        return maxCount;
    }
}

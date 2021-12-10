package com.leet.problems2;

import java.util.Arrays;

public class MaximumDifferenceBetweenIncreasingElements {
    public static void main(String[] args) {

        System.out.println(new MaximumDifferenceBetweenIncreasingElements().maximumDifference(new int[]{1, 5, 2, 10}));
    }

    public int maximumDifference(int[] nums) {

        int min = Integer.MAX_VALUE;
        int maxDiff = -1;

        for (int num : nums) {
            min = Math.min(min, num);
            maxDiff = Math.max(maxDiff, num - min);
        }

        return maxDiff == 0 ? -1 : maxDiff;
    }
}

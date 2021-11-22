package com.leet.problems;

import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        System.out.println(missingNumber(new int[]{0}));
    }

    public static int missingNumber(int[] nums) {
        int sum = (nums.length) * (nums.length +1) / 2;
        int total = Arrays.stream(nums).sum();
        return sum - total;
    }
}

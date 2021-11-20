package com.leet.problems;

// https://leetcode.com/problems/minimum-value-to-get-positive-step-by-step-sum/
public class MinimumValuetoGetPositiveStepbyStepSum {
    public static void main(String[] args) {
//        System.out.println(minStartValue(new int[]{-3, 2, -3, 4, 2}));
//        System.out.println(minStartValue(new int[]{1, 2}));
//        System.out.println(minStartValue(new int[]{1,-2,-3}));
        System.out.println(minStartValue(new int[]{2,3,5,-5,-1}));
    }

    public static int minStartValue(int[] nums) {

        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = nums[i] + nums[i - 1];
            min = Math.min(min, nums[i]);
        }
        return min < 1 ? min * -1 + 1 : 1;
    }

}

package com.leet.problems;

public class CheckArraySortedandRotated {
    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
        System.out.println(check(new int[]{2, 1}));
        System.out.println(check(new int[]{2, 1, 3, 4}));
        System.out.println(check(new int[]{1, 3, 2}));
    }

    public static boolean check(int[] nums) {
        if (nums.length < 2) {
            return true;
        }
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                break;
            }
        }

        int breakingPoint = i;

        for (; i < nums.length; i++) {
            if (nums[i] > nums[0] || (i > breakingPoint && nums[i] < nums[i - 1])) {
                return false;
            }
        }
        return true;
    }
}

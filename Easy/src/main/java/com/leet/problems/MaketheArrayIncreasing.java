package com.leet.problems;

public class MaketheArrayIncreasing {
    public static void main(String[] args) {
        var obj = new MaketheArrayIncreasing();

        System.out.println(obj.minOperations(new int[]{8,9,9}));
    }

    public int minOperations(int[] nums) {
        if (nums == null || nums.length < 2) {
            return 0;
        }
        int operations = 0;
        int diff;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                continue;
            }
            diff = nums[i - 1] - nums[i] + 1;
            operations += diff;
            nums[i] += diff;
        }

        return operations;
    }

}

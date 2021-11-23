package problems;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {
//        System.out.println(canPartition(new int[]{1, 5, 11, 5}));
//        System.out.println(canPartition(new int[]{1, 2, 3, 5}));
//        System.out.println(canPartition(new int[]{1, 9, 3, 11}));
//        System.out.println(canPartition(new int[]{1, 0, 1, 0, 0, 1, 1}));
//        System.out.println(canPartition(new int[]{3, 3, 3, 9}));
//        System.out.println(canPartition(new int[]{3}));
//        System.out.println(canPartition(new int[]{3,4}));
//        System.out.println(canPartition(new int[]{14, 9, 8, 4, 3, 2}));

//        dynamic programming
        System.out.println(canPartition(new int[]{23, 13, 11, 7, 6, 5, 5}));

    }

    public static boolean canPartition(int[] nums) {
        int sum1 = Arrays.stream(nums).sum();
        if (nums.length == 1 || sum1 % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        sum1 /= 2;
        int sum2 = sum1;

        for (int i = nums.length - 1; i >= 0; i--) {
            int current = nums[i];
            if (sum1 - current >= 0) {
                sum1 -= current;
                continue;
            }
            sum2 -= current;
        }

        return sum1 == 0 && sum2 == 0;
    }
}
package problems;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static void main(String[] args) {

        var main = new PartitionEqualSubsetSum();
        System.out.println(main.canPartition(new int[]{1, 5, 11, 5}));
    }

    public boolean canPartition(int[] nums) {

        final int sum = Arrays.stream(nums).sum();

        if (sum % 2 == 1) {
            return false;
        }

        final int target = sum / 2;
        final int len = nums.length;

        final boolean[][] dp = new boolean[len + 1][target + 1];
        dp[0][0] = true;
        for (int row = 1; row < dp.length; row++) {
            for (int col = 1; col < dp[0].length; col++) {
                dp[row][col] = dp[row - 1][col] || (col - nums[row - 1] >= 0 && dp[row - 1][col - nums[row - 1]]);
            }
        }

        return dp[len][target];
    }
}
package problems;

// https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int target = 7;
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int len = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE
                ;
        for (int i = 0, j = 0; i < len && j < len; ) {
            if (sum + nums[j] >= target) {
                min = Math.min(min, j - i + 1);
                sum -= nums[i++];
                continue;
            }
            sum += nums[j++];
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

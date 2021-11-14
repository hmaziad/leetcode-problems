package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {

//        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{0,0,0,0}));
//        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            findSlidingWindow(nums[i] * -1, i + 1, nums, res);
        }

        return res;
    }

    private static void findSlidingWindow(int target, int startingIndex, int[] nums, List<List<Integer>> res) {

        for (int i = startingIndex, j = nums.length - 1; i < j; ) {
            int sum = nums[i] + nums[j];
            if (sum == target) {
                res.add(List.of(nums[startingIndex - 1], nums[i], nums[j]));
                while (i < j && nums[i] == nums[i + 1]) i++;
                while (i < j && nums[j] == nums[j - 1]) j--;
                i++;
                j--;
            }
            if (sum < target) {
                i++;
                continue;
            }
            if (sum > target) {
                j--;
                continue;
            }
        }
    }

}

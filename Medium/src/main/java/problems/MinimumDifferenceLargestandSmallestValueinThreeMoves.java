package problems;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves/
public class MinimumDifferenceLargestandSmallestValueinThreeMoves {

    public static void main(String[] args) {
        /*System.out.println(minDifference(new int[]{5, 3, 2, 4}));
        System.out.println(minDifference(new int[]{1,5,0,10,14}));
        System.out.println(minDifference(new int[]{6,6,0,1,1,4,6}));
        System.out.println(minDifference(new int[]{1,5,6,14,15}));
        System.out.println(minDifference(new int[]{1,5,6,14,15}));
        System.out.println("**************");
        */
//        System.out.println(minDifference(new int[]{4}));
//        System.out.println(minDifference(new int[]{4,4,4,4,4}));
//        System.out.println(minDifference(new int[]{0,40,50,90,  100}));
        System.out.println(minDifference(new int[]{9, 48, 92, 48, 81, 31}));
    }

    public static int minDifference(int[] nums) {

        if (nums.length <= 4) {
            return 0;
        }

        Arrays.sort(nums);
        int moves = 3;
        int first = 0;
        int last = nums.length - 1;
        int idealFirst = Math.min(first + 4, last);
        int idealLast = Math.max(last - 4, first);
        int diff = nums[first] - nums[last];

        while (diff > 0 && moves > 0) {
            if (last == first) {
                break;
            }

            int diffFF = nums[idealFirst] - nums[first];
            int diffLL = nums[last] - nums[idealLast];

            if (diffFF > diffLL) {
                first++;
                diff = nums[last] - nums[first];
            } else if (diffLL > diffFF) {
                last--;
                diff = nums[last] - nums[first];
            } else {
                first++;
                if (nums[last] == nums[last - 1]) {
                    last--;
                }
                diff = nums[last] - nums[first];
            }
            idealFirst = Math.min(idealFirst, last);
            idealLast = Math.max(idealLast, first);
            moves--;
        }

        return diff;

    }
}

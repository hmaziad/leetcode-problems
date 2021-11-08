package problems;

import java.util.HashMap;
import java.util.Map;
// https://leetcode.com/problems/4sum-ii/
public class FourSumII {
    public static void main(String[] args) {


    }

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> countPerComplement = new HashMap<>();
        int output = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                int sum = nums1[i] + nums2[j];
                countPerComplement.put(sum, countPerComplement.getOrDefault(sum, 0) + 1);
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums1.length; j++) {
                int sum = nums3[i] + nums4[j];
                output += countPerComplement.getOrDefault(sum * -1, 0);
            }
        }

        return output;

    }
}

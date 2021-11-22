package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianofTwoSortedArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return findMedianSortedArrays(asList(nums1), asList(nums2));
    }

    public static double findMedianSortedArrays(List<Integer> nums1, List<Integer> nums2) {

        Median m1 = getMedian(nums1);
        Median m2 = getMedian(nums2);

        if (nums1.size() + nums2.size() <= 2) {
            return (m1.value + m2.value) / (nums1.isEmpty() || nums2.isEmpty() ? 1 : 2);
        }


        boolean m1Smaller = m1.value < m2.value;

        nums1 = getSublist(nums1, m1, m1Smaller);
        nums2 = getSublist(nums2, m2, !m1Smaller);

        nums1 = removeMoreThanLimit(nums1, m2.value, m1Smaller);
        nums2 = removeMoreThanLimit(nums2, m1.value, !m1Smaller);


        return findMedianSortedArrays(nums1, nums2);
    }

    private static List<Integer> getSublist(List<Integer> nums, Median median, boolean numsSmaller) {
        return numsSmaller ? nums.subList(median.index2, nums.size()) : nums.subList(0, median.index1 + 1);
    }

    public static List<Integer> removeMoreThanLimit(List<Integer> nums, double limit, boolean numsSmaller) {

        if (nums.isEmpty()) {
            return new ArrayList<>();
        }

        int left = 0;
        int right = nums.size();
        int middle = 0;
        while (left <= right) {
            middle = left + (right - left) / 2;

            if (middle >= nums.size()) {
                break;
            }

            if (limitReached(middle, nums, numsSmaller, limit)) {
                return numsSmaller ? nums.subList(0, middle + 1) : nums.subList(middle, nums.size());
            } else if (nums.get(middle) < limit) {
                left = middle + 1;
            } else {
                right = middle - 1 ;
            }
        }
        return new ArrayList<>();
    }

    private static boolean limitReached(int middle, List<Integer> nums, boolean numsSmaller, double limit) {
        if (numsSmaller) {
            return nums.get(middle) <= limit && (middle == nums.size() - 1 || nums.get(middle + 1) > limit);
        }
        return nums.get(middle) >= limit && (middle == 0 || nums.get(middle - 1) < limit);
    }

    private static List<Integer> asList(int[] nums) {
        return Arrays.stream(nums).boxed().collect(Collectors.toList());
    }

    public static Median getMedian(List<Integer> nums) {
        int length = nums.size();
        if (length <= 1) {
            return new Median(length == 1 ? nums.get(0) : 0, 0, 0);
        }

        boolean isEven = length % 2 == 0;
        int i1 = length / 2;
        if (isEven) {
            int i2 = length / 2 - 1; // so wrong!!
            return new Median((nums.get(i1) + nums.get(i2)) / 2.0, i2, i1);
        }

        return new Median(nums.get(i1), i1, i1);
    }


}

class Median {
    double value;
    int index1;
    int index2;

    public Median(double value, int index1, int index2) {
        this.value = value;
        this.index1 = index1;
        this.index2 = index2;
    }
}
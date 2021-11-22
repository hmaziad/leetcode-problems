package problems;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/median-of-two-sorted-arrays/
public class MedianofTwoSortedArray {
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        System.out.println(List.of(nums1.st));
        return 0;
    }

//    private static double findMedianSortedArrays(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2) {
//
//        if (nums1.length + nums2.length <= 2) {
//            getMedian(nums1, nums2);
//        }
//
//        Median median1 = getMedian(nums1, start1, end1);
//        Median median2 = getMedian(nums2, start2, end2);
//
//        int limit1 = getLimit(median1, median2, nums1, start1, end1, median1.value < median2.value);
//        int limit2 = getLimit(median2, median1, nums2, start2, end2, median2.value < median1.value);
//
//        int newStart1 = median1.value < median2.value ? median1.index1 : start1;
//        int newEnd1 = median1.value < median2.value ? limit1 : start1;
//
//
//        return findMedianSortedArrays(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1);
//    }
//
//
//    private static int getLimit(Median m1, Median limit, int[] nums, int start, int end, boolean refIsMax) {
//        int left = refIsMax ? m1.index1 : start;
//        int right = refIsMax ? end : m1.index2;
//
//        while (left <= right) {
//            int middle = left + (right - left) / 2;
//            if (limitReached(middle, nums, limit,  refIsMax)) {
//                return middle;
//            } else if (nums[middle] < limit.value) {
//                left = refIsMax ? middle + 1 : left;
//                right = refIsMax ? right : middle - 1;
//            } else {
//                left = refIsMax ? left : middle + 1;
//                right = refIsMax ? middle - 1 : right;
//            }
//        }
//        return 0;
//    }
//
//    private static boolean limitReached(int middle, int[] nums, Median limit, boolean refIsMax) {
//        if (refIsMax) {
//            return nums[middle] <= limit.value && (middle == nums.length - 1 || nums[middle + 1] > limit.value);
//        }
//        return nums[middle] >= limit.value && (middle == 0 || nums[middle - 1] > limit.value);
//    }
//
//    private static double getMedian(int[] nums1, int[] nums2) {
//        double med1 = getMedian(nums1, start1, end1).value;
//        double med2 = getMedian(nums2, start1, end1).value;
//
//        if (med1 == 0 || med2 == 0) {
//            return Math.max(med1, med2);
//        }
//        return (med1 + med2) / 2;
//    }
//
//
//    private static Median getMedian(int[] nums, int start1, int end1) {
//        int length = nums.length;
//        if (length <= 1) {
//            return new Median(length == 1 ? nums[0] : 0, 0, 0, false);
//        }
//
//        boolean isEven = length % 2 == 0;
//        int i1 = length / 2;
//        if (isEven) {
//            int i2 = length / 2 - 1; // so wrong!!
//            return new Median((nums[i1] + nums[i2]) / 2.0, i2, i1, true);
//        }
//
//        return new Median(nums[i1], i1, i1, false);
//    }
//
//    private static class Median {
//        double value;
//        int index1;
//        int index2;
//        boolean isEven;
//
//        public Median(double value, int index1, int index2, boolean isEven) {
//            this.value = value;
//            this.index1 = index1;
//            this.index2 = index2;
//            this.isEven = isEven;
//        }
//    }
}

package problems;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static problems.MedianofTwoSortedArray.findMedianSortedArrays;
import static problems.MedianofTwoSortedArray.getMedian;
import static problems.MedianofTwoSortedArray.removeMoreThanLimit;

public class MedianofTwoSortedArrayTest {


    @Test
    public void median_of_two_own_test_cases() {
        int[] nums1 = {3, 4, 5, 6, 7};
        int[] nums2 = {1, 2, 8, 9, 10, 11, 12};

        assertEquals(6.5, findMedianSortedArrays(nums1, nums2), 0.0001);

    }


    @Test
    public void median_of_two_leet_test_cases() {
        assertEquals(2.5, findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 0.0001);
        assertEquals(2, findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 0.0001);
        assertEquals(0, findMedianSortedArrays(new int[]{0, 0}, new int[]{0}), 0.0001);
        assertEquals(1, findMedianSortedArrays(new int[]{}, new int[]{1}), 0.0001);
        assertEquals(2, findMedianSortedArrays(new int[]{2}, new int[]{}), 0.0001);
        assertEquals(7, findMedianSortedArrays(new int[]{6,7}, new int[]{8}), 0.0001);
    }

    @Test
    public void remove_more_than_limit() {

        assertTrue(removeMoreThanLimit(List.of(1, 2, 3, 4, 5, 6, 7, 8), 2.5, true).equals(List.of(1, 2)));
        assertTrue(removeMoreThanLimit(List.of(1, 2, 3, 4, 5, 6, 7, 8), 2.5, false).equals(List.of(3, 4, 5, 6, 7, 8)));
        assertTrue(removeMoreThanLimit(List.of(7, 8), 2.5, false).equals(List.of(7, 8)));
        assertTrue(removeMoreThanLimit(List.of(7, 8), 2.5, true).equals(List.of()));
        assertTrue(removeMoreThanLimit(List.of(), 2.5, true).equals(List.of()));
        assertTrue(removeMoreThanLimit(List.of(1), 2.5, true).equals(List.of(1)));
        assertTrue(removeMoreThanLimit(List.of(1), 2.5, false).equals(List.of()));
        assertTrue(removeMoreThanLimit(List.of(1, 2, 3, 4, 5), 3, true).equals(List.of(1, 2, 3)));
        assertTrue(removeMoreThanLimit(List.of(1, 2, 3, 4, 5), 3, false).equals(List.of(3, 4, 5)));

    }


    @Test
    public void test_get_median_correct() {

        Median ans = getMedian(List.of());
        assertEquals(0.0, ans.value, 0.01);
        assertEquals(0, ans.index1);
        assertEquals(0, ans.index2);

        ans = getMedian(List.of(1, 2, 3));
        assertEquals(2.0, ans.value, 0.01);
        assertEquals(1, ans.index1);
        assertEquals(1, ans.index2);

        ans = getMedian(List.of(1, 2, 3, 4));
        assertEquals(2.5, ans.value, 0.01);
        assertEquals(1, ans.index1);
        assertEquals(2, ans.index2);


        ans = getMedian(List.of(1, 2));
        assertEquals(1.5, ans.value, 0.01);
        assertEquals(0, ans.index1);
        assertEquals(1, ans.index2);

        ans = getMedian(List.of(5));
        assertEquals(5, ans.value, 0.01);
        assertEquals(0, ans.index1);
        assertEquals(0, ans.index2);
    }
}
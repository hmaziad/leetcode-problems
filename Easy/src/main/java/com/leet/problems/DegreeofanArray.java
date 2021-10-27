package com.leet.problems;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://leetcode.com/problems/degree-of-an-array/
public class DegreeofanArray {
    public static void main(String[] args) {

        /*

        Given: The degree of an array is the highest frequency of one of its elements
        Problem: Find the smallest subarray that has the same degree
        Solution: In one go only, have a hashmap that stores the count of each element + the difference between the first and last index
        When hashmap is full, iterate the hashmap to find the element with highest frequency, if two elements are same in frequency then
        pick the one with shortest diff in indices. if both has same diff, pick any.

        Time Complexity:
            O(n) for first iteration
            O(n) for getting the max by frequency
            O(n) for getting the smallest diff

        Space Complexity:
            O(n) for HashMap

        Total O(n) for time and space

        //
         */

        int[] nums = {1,1};
        System.out.println(findShortestSubArray(nums));

    }


    public static int findShortestSubArray(int[] nums) {

        // if array has 0 or 1 element(s) then returning the length is enough
        int numLength = nums.length;

        if (numLength < 2) {
            return numLength;
        }

        Map<Integer, ItemProperties> properties = new HashMap<>();
        AtomicInteger maxCount =  new AtomicInteger(0);

        for (int i = 0; i < numLength; i++) {
            properties.putIfAbsent(nums[i],new ItemProperties());
            properties.get(nums[i]).update(i);
            maxCount.set(Math.max(maxCount.get(), properties.get(nums[i]).getCount())) ;
        }

       return properties.values().stream()
               .filter(item -> item.getCount() == maxCount.get())
               .mapToInt(ItemProperties::getLength).min().orElse(0);

    }
}

class ItemProperties {
    private int first = Integer.MAX_VALUE;
    private int last = 0;
    private int count = 0;

    public void update(int index) {
        count++;
        first = Math.min(index, first);
        last = Math.max(index, last);
    }

    public int getCount() {
        return count;
    }

    public int getLength() {
        return last - first + 1;
    }
}

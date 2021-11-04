package problems;

import java.util.Arrays;

// https://leetcode.com/problems/h-index/
public class H_Index {
    public static void main(String[] args) {
        System.out.println(hIndex(new int[]{1, 3, 1}));
    }

    public static int hIndex(int[] citations) {
        // 1,1,3
        Arrays.sort(citations);
        int length = citations.length;
        for (int i = 0; i < length; i++) {
            if (citations[i] >= length - i) return length - i;
        }
        return 0;
    }
}

package com.leet.problems2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LuckyNumbersinaMatrix {
    public static void main(String[] args) {
        LuckyNumbersinaMatrix main = new LuckyNumbersinaMatrix();
        System.out.println(main.luckyNumbers(new int[][]{{3, 6}, {7, 1}, {5, 2}, {4, 8}}));
    }

    public List<Integer> luckyNumbers (int[][] matrix) {

        int[] mins = new int[matrix.length];
        Arrays.fill(mins, Integer.MAX_VALUE);
        int[] maxs = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // min per row
                mins[i] = Math.min(mins[i], matrix[i][j]);
                maxs[j] = Math.max(maxs[j], matrix[i][j]);
            }
        }

        List<Integer> luckyNumbers = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int current = matrix[i][j];
                if (current == mins[i] && current == maxs[j]) {
                    luckyNumbers.add(current);
                }
            }
        }

        return luckyNumbers;

    }
}

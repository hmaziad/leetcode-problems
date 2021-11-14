package com.leet.problems;

public class ValidMountainArray {
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }
        int i = 0;
        int j = arr.length - 1;
        while (i+1< arr.length && arr[i+1] > arr[i]) {
            i++;
        }

        while (j-1 >= 0 && arr[j-1] > arr[j]) {
            j--;
        }

        return i == j && i != 0 && j != arr.length - 1;

    }

    public static void main(String[] args) {
        System.out.println(new ValidMountainArray().validMountainArray(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}));
    }
}

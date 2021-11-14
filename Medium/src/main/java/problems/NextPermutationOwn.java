package problems;

import java.util.Arrays;

public class NextPermutationOwn {

    public static void main(String[] args) {

        System.out.println(getMinSwaps("5489355142",4));
    }

    public static int getMinSwaps(String num, int k) {

        char[] nums = num.toCharArray();

        while (k > 0) {
            nextPermutation(nums);
            k--;
        }

        return getMinAdjSwaps(num.toCharArray(), nums);


    }

    private static void nextPermutation(char[] arr) {

        /**
         * Algo:
         *
         * 1) find longest non-increasing suffix and get the pivot
         * 2) swap it with the rightmost next greatest than pivot
         * 3) reverse suffix
         */

        if (arr == null || arr.length < 2) {
            return;
        }

        //1.

        int last = arr.length - 2;

        while (last >= 0) {
            if (arr[last] < arr[last + 1]) {
                break;
            }
            last--;
        }

        if (last == -1) {
            return;
        }

        //2.

        for (int i = arr.length - 1; i > last; i--) {
            if (arr[i] > arr[last]) {
                swap(arr, i, last);
                break;
            }
        }

        reverse(arr, last + 1);

    }

    private static void reverse(char[] arr, int start) {

        int end = arr.length - 1;
        while (start < end) {
            swap(arr, start++, end--);
        }

    }


    private static int getMinAdjSwaps(char[] orig, char[] res) {

        int swaps = 0;

        for (int i = 0; i < orig.length; i++) {
            if (orig[i] == res[i]) {
                continue;
            }

            int j = i;

            while (orig[i] != res[j]) {
                j++;
            }

            while (orig[i] != res[i]) {
                swap(res, j - 1, j--);
                swaps++;
            }
        }

        return swaps;
    }

    private static void swap(char[] arr, int a, int b) {

        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

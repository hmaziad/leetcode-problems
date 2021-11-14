package problems;

public class NextPermutationOwn {

    public static void main(String[] args) {
        int[] orig = {5, 4, 8, 9, 3, 5, 5, 1, 4, 2};
        int[] res = {5, 4, 8, 9, 3, 5, 5, 4, 2, 1};

        System.out.println(getMinAdjSwaps(orig, res));

    }

    private static int getMinAdjSwaps(int[] orig, int[] res) {

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
                swap(res,j - 1, j-- );
                swaps++;
            }
        }

        return swaps;
    }

    private static void swap(int[] res, int a, int b) {

        int temp = res[a];
        res[a] = res[b];
        res[b] = temp;
    }
}

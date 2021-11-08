package problems;

import java.util.Arrays;

// https://leetcode.com/problems/construct-the-lexicographically-largest-valid-sequence/
public class LexicographicallyLargestValidSequence {

    static int[] output;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minValidSequence(5)));

    }

    private static int[] minValidSequence(int n) {
        int len = 2 * n - 1;
        output = new int[len];
        boolean[] visited = new boolean[len];
        constructValidSequence(n, visited);
        return output;
    }

    private static boolean constructValidSequence(int n, boolean[] visited) {
        boolean[] visitedOrig = visited.clone();
        int[] outputOrig = output.clone();

        if (n == 0) {
            return true;
        }

        for (int i = 0; n > 1 ? i + n < output.length : i < output.length; i++) {
            if (invalidPosition(i, n, visited)) {
                continue;
            }
            setValues(n, i, output, visited);

            if (constructValidSequence(n - 1,  visited)) {
                return true;
            }
            visited = visitedOrig.clone();
            output = outputOrig.clone();
        }
        return false;
    }

    private static void setValues(int n, int i, int[] output, boolean[] visited) {
        if (n == 1) {
            output[i] = n;
            visited[i] = true;
            return;
        }
        output[i] = output[i + n] = n;
        visited[i] = visited[i + n] = true;
    }

    private static boolean invalidPosition(int i, int n, boolean[] visited) {
        if (n == 1) {
            return visited[i];
        }
        return visited[i] || visited[i + n];
    }
}

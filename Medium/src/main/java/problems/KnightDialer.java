package problems;

import java.util.Arrays;
import java.util.stream.IntStream;

public class KnightDialer {
    int mod = (int) Math.pow(10, 9) + 7;
    public static void main(String[] args) {

        var dealer = new KnightDialer();
        System.out.println(dealer.knightDialer(3131));

    }

    public int knightDialer(int n) {
        final int MOD = 1_000_000_007;
        final int[][] dp = new int[n + 1][10];
        IntStream.range(0, 10).forEach(num -> dp[1][num] = 1);

        final int[][] paths = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}};

        for (int row = 2; row < dp.length; row++) {
            for (int col = 0; col < dp[0].length; col++) {
                final int currentRow = row;
                for (int path : paths[col]) {
                    dp[row][col] = (dp[row][col] + dp[currentRow - 1][path]) % MOD;
                }
            }
        }

        int sum = 0;
        for (int val : dp[n]) {
            sum = (sum + val) % MOD;
        }

        return sum;

    }
}

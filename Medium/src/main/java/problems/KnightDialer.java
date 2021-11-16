package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KnightDialer {
    int mod = (int) Math.pow(10, 9) + 7;
    public static void main(String[] args) {

        var dealer = new KnightDialer();
        System.out.println(dealer.knightDialer(4964));

    }

    public int knightDialer2(int n) {
        int MOD = 1000000007;
        int paths[][] = {{4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9}, {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}}; // Previous moves of knight-> For instance, if a knight is at 0, it reached from either 4 or 6. Similarly if it is at 1, it is reached from 7 or 9  & so on
        double dp[][] = new double[n + 1][10]; // rows -> no of steps taken to reach row i      cols-> no of digits
        for (int j = 0; j < 10; j++)
            dp[1][j] = 1; //populate the base case for n =1
        for (int i = 2; i < n + 1; i++) { // no of steps taken by knight to reach i
            for (int j = 0; j < 10; j++) { // no of digits
                for (int p : paths[j]) { // Previous move of knight in order to reach digit j
                    dp[i][j] += dp[i - 1][p]; // cumulatively add from the previous knight move. For instance., F(2, 0) -> F(1,4) +  F(1,6) F(2,6) -> F(1,0) + F(1,1) + F(1,7)
                }
                dp[i][j] %= MOD;
            }
        }
        double sum = 0d;
        for (int j = 0; j < 10; j++)
            sum += dp[n][j];
        return (int) (sum % MOD);
    }

    public int knightDialer(int n) {
        int sum = 0;
        var directions = getDirections();
        var storage = new HashMap<Integer, Map<Integer, Integer>>();
        for (int num : directions.keySet()) {
            sum = (sum + knightDialer(num, n, directions, storage)) % mod;
        }
        return sum;
    }

    private int knightDialer(int num, int n, Map<Integer, List<Integer>> directionsPerNum, Map<Integer, Map<Integer, Integer>> storage) {

        if (n == 1) {
            return 1;
        }

        if (storage.containsKey(num) && storage.get(num).containsKey(n)) {
            return storage.get(num).get(n);
        }

        int totalDistinctNumbers = 0;

        for (int direction : directionsPerNum.get(num)) {
            totalDistinctNumbers = (totalDistinctNumbers + knightDialer(direction, n - 1, directionsPerNum, storage)) % mod;
        }

        storage.putIfAbsent(num, new HashMap<>());
        storage.get(num).put(n, totalDistinctNumbers);

        return totalDistinctNumbers;
    }

    private Map<Integer, List<Integer>> getDirections() {
        Map<Integer, List<Integer>> directionsPerMap = new HashMap<>();

        directionsPerMap.put(0, List.of(4, 6));
        directionsPerMap.put(1, List.of(8, 6));
        directionsPerMap.put(2, List.of(7, 9));
        directionsPerMap.put(3, List.of(4, 8));
        directionsPerMap.put(4, List.of(3, 9, 0));
        directionsPerMap.put(5, List.of());
        directionsPerMap.put(6, List.of(1, 7, 0));
        directionsPerMap.put(7, List.of(2, 6));
        directionsPerMap.put(8, List.of(1, 3));
        directionsPerMap.put(9, List.of(4, 2));

        return directionsPerMap;
    }
}

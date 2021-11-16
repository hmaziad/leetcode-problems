package problems;

public class SumofBeautyofAllSubstrings {
    public static void main(String[] args) {
        System.out.println(beautySum("aabcbaa"));
    }

    public static int beautySum(String s) {

        int[] counts = new int[26];
        int beautySum = 0;

        for (int i = 0; i < s.length(); i++) {
            String substr = "";
            for (int j = i; j < s.length(); j++) {
                substr += s.charAt(j);
                counts[s.charAt(j) - 'a']++;
                beautySum += beautySum(counts);
//                System.out.println(substr);
            }
            counts = new int[26];
        }
        return beautySum;
    }

    private static int beautySum(int[] counts) {
        int min = Integer.MAX_VALUE;
        int max = 0;

        for (int count : counts) {
            max = Math.max(max, count);
            min = count == 0 ? min : Math.min(min, count);
        }

        return min == Integer.MAX_VALUE ? 0 : max - min;
    }
}

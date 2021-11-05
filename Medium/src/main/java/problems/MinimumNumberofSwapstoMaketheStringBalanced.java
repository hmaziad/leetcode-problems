package problems;

//https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
public class MinimumNumberofSwapstoMaketheStringBalanced {
    public static void main(String[] args) {

        System.out.println(minSwaps("][]["));
    }

    public static int minSwaps(String s) {
        int mismatches = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '[')
                mismatches++;
            else {
                if (mismatches > 0)
                    mismatches--;
            }
        }
        return (mismatches + 1) / 2;
    }
}

package problems;

import java.math.BigInteger;

public class SwapstoReachtheKthSmallest {

    public static void main(String[] args) {
        System.out.println(getMinSwaps("5489355142", 4));
    }

    public static int getMinSwaps(String num, int k) {
        int totalSwaps = 0;
        Num numObj = new Num(num);
        while (k > 0) {
            totalSwaps += getMinSwaps(numObj);
            k--;
        }
        return totalSwaps;
    }

    public static int getMinSwaps(Num num) {
        int swaps = 0;
        String original = num.num;
        for (int i = num.num.length() - 1; i > 0; i--) {
            swap(i, i - 1, num);
            swaps++;
            if (new BigInteger(num.num).compareTo(new BigInteger(original)) > 0) {
                break;
            }
        }
        return swaps;
    }

    public static void swap(int i1, int i2, Num num) {
        StringBuilder numBuilder = new StringBuilder(num.num);
        char temp = numBuilder.charAt(i1);
        numBuilder.setCharAt(i1, numBuilder.charAt(i2));
        numBuilder.setCharAt(i2, temp);
        num.num = numBuilder.toString();
    }

    private static class Num {
        String num;

        public Num(String num) {
            this.num = num;
        }
    }
}

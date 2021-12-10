package com.leet.problems2;

public class AddDigits {
    public static void main(String[] args) {
        System.out.println(new AddDigits().addDigits(0)); // 17, 8
    }


    public int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return num % 9 == 0 ? 9 : num % 9;
    }


}

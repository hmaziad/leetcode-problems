package com.leet.problems;

public class ReformatTheString {

    public static void main(String[] args) {
        System.out.println(reformat("covid2019"));

    }

    public static String reformat(String s) {

        char[] res = new char[s.length()];

        int i_letter = 0;
        int i_num = 1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Character.isDigit(current)) {
                if (i_num > s.length() - 1)
                    return "";
                res[i_num] = current;
                i_num += 2;
                continue;
            }
            if (i_letter > s.length() - 1)
                return "";
            res[i_letter] = current;
            i_letter += 2;
        }

        return i_num == s.length() && i_letter == s.length() + 1 ? new String(res) : "";
    }

}

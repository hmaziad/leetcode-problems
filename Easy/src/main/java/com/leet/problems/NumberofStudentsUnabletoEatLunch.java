package com.leet.problems;

public class NumberofStudentsUnabletoEatLunch {
    public static void main(String[] args) {

        System.out.println(countStudents(new int[]{1,1,1,0,0,1}, new int[]{
                1,0,0,0,1,1
        }));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int sandwich = 0;
        int remainingStudents = students.length;
        int index = 0, counter = 0;

        while (counter <= remainingStudents) {

            if (students[index] == -1) {
                index = (index + 1) % students.length;
                continue;
            }

            if (sandwiches[sandwich] == students[index]) {
                sandwich++;
                students[index] = -1;
                remainingStudents--;
                counter = 0;
            }

            counter++;
            index = (index + 1) % students.length;

        }

        return remainingStudents;
    }
}

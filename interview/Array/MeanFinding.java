/*
    You are given an array of integers a. Your task is to calculate how many numbers in the array
    are equal to the arthmetic mean of the neighbours.
    In other words, count the number of indices i such that
    a[i-1]+ a[i+1]= 2*a[i]

*/

package interview.Array;

public class MeanFinding {

    public static void main(String[] args) {
        int[] a = { 2, 4, 5, 6, 6, 3 };
        System.out.println(findCound(a));

    }

    public static int findCound(int[] num) {
        int count = 0;
        for (int i = 0; i < num.length; i++) {
            int mean = 0;
            if (i == 0) {
                mean = 0 + num[i + 1];
            } else if (i == num.length - 1) {
                mean = 0 + num[i - 1];
            } else {
                mean = num[i - 1] + num[i + 1];
            }
            if (2 * num[i] == mean) {
                count++;
            }
        }

        return count;
    }

}
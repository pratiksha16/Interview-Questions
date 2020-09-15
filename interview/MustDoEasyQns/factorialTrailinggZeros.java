/*
 Given an integer n, return the number of trailing zeroes in n!.

Example 1:

Input: 3
Output: 0
Explanation: 3! = 6, no trailing zero.
Example 2:

Input: 5
Output: 1
Explanation: 5! = 120, one trailing zero.


Note: should run in logarithmic complexity;

My observation: trailing zeros increases by 1 every 5 nums, an
formula: sum(n/5^k);
where k is the fa
*/

package interview.MustDoEasyQns;

import java.util.*;

public class factorialTrailinggZeros {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));

    }

    public static int trailingZeroes(int num) {
        int k = (int) (Math.log(125.0) / Math.log(5.0));
        int zeroes = 0;
        for (int i = 1; i <= k; i++) {
            int div = (int) Math.pow(5.0, i);
            zeroes += num / div;
        }
        return zeroes;

    }
}
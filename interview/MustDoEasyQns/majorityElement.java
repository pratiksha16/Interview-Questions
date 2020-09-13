/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:

Input: [3,2,3]
Output: 3
Example 2:

Input: [2,2,1,1,1,2,2]
Output: 2
[1,1,1,2,2,2,2,3,3]
Approaches:  HashMap---- Time Complexity: o(n), Space Complexity: o(n);
            

*/

package interview.MustDoEasyQns;

import java.util.*;

public class majorityElement {

    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 2, 2 };
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = nums.length / 2;
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) > count) {
                return nums[i];
            }
        }

        return -1;
    }
}
/*
Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

Example 1:

Input: "III"
Output: 3     ----- if same I + I + I;

Example 2:

Input: "IV" -- 
Output: 4     ----- if i < i+1; ----- ch(i+1) - ch(i);

Example 3:

Input: "IX"
Output: 9  ------
Example 4:

Input: "LVIII"
Output: 58   -------if i > i+1 --- ch(i) + ch(i+1)
Explanation: L = 50, V= 5, III = 3.
Example 5:

Input: "MCMXCIV" ----        total=0 ; total+=1000 
                                
Output: 1994
Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.

U:  IS the input always valid?
    can we use extra space?
    I--- 1
    V----5
    X----10
    L-----50
    C-----100
    D-----500
    M---10000

M: map to get the value;


Plan : Make a hashmap to store all trhe values;
       loop; i=0; i< len;   i=5;    ------ i=6;
             if i >= i+1 --- ch(i) + ch(i+1):
                value= .get     
             else:
                subtarct i from i+1;   --90
                increase the value of i; i++; - i=4

            total= total+value;-- 1990 
            i++;
*/

package interview.MustDoEasyQns;

import java.util.*;

public class romanToInteger {

    public static void main(String[] args) {
        String roman = "";
        int val = changeToInteger(roman);
        System.out.println(val);

    }

    public static int changeToInteger(String roman) {

        /* Build a hashmap */
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        // Edge cases:
        if (roman.length() == 0 || roman == null) {
            return 0;
        }

        // loop through the string; III
        int i = 0;
        int total = 0;
        int value = 0;
        while (i < roman.length()) {
            if (i + 1 < roman.length() && map.get(roman.charAt(i)) >= map.get(roman.charAt(i + 1))) {
                value = map.get(roman.charAt(i));
            } else if (i + 1 < roman.length() && map.get(roman.charAt(i)) < map.get(roman.charAt(i + 1))) {
                value = map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i));
                i++;
            } else {
                value = map.get(roman.charAt(i));
            }
            total += value;
            i++;
        }
        return total;

    }
}

/* 


Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.


Input 2: 
Input:
"cccaaa"

Output:
"cccaaa"

Explanation:
Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
Note that "cacaca" is incorrect, as the same characters must be together.

Input 3 :
"Aabb"

Output:
"bbAa"

Explanation:
"bbaA" is also a valid answer, but "Aabb" is incorrect.
Note that 'A' and 'a' are treated as two different characters.

Match:   HashMap to store the frequency;
         make a min heap; to store the ;
Planning:  
    make a map, and store the character as well as its  frequency;
    Use a min-heap to sort the charcater from the map;
    finally, while the heap is not emoty; poll out the charcter
    //append it to the string------ count;

Implementation:
    Code below;

Review+Evaluate:    Time Complexity:   O(n log n); we made a max-heap;
                                        O(n); heap of size n and map of size n
         



*/

package interview.Strings;

import java.util.*;

class interview {
    public static void main(String[] args) {
        String s = "Aabb";
        System.out.println(sortCharcters(s));
    }

    public static String sortCharcters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder str = new StringBuilder();

        if (s.length() == 0 || s == null) {
            return "";
        }
        /*
         * t------ 1; r-------1; e--------2;
         * 
         * Heap: ert;
         */

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Character> queue = new PriorityQueue<Character>((a, b) -> map.get(b) - map.get(a));
        for (char ch : map.keySet()) {
            queue.add(ch);
        }
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            System.out.println(ch);
            for (int i = 0; i < map.get(ch); i++) {
                str.append(ch);
            }

        }
        return str.toString();

    }

}
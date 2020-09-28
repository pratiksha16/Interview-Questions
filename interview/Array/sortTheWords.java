/*
Order a list of words apperaing in a file by number of letters but maintain original order of words with the same length;
Input : list = ["rohan", "amy", "sapna", "muhammad",
                "aakash", "raunak", "chinmoy"]
Output : ['amy', 'rohan', 'sapna', 'aakash', 'raunak', 
         'chinmoy', 'muhammad']

*/

package interview.Array;

import java.util.*;
import java.util.Arrays;
import java.util.Comparator;

public class sortTheWords {
    public static void main(String[] args) {

        String[] list = { "apple", "banan", "sapna", "muhammad", "aakash", "raunak", "chinmoy" };
        sort(list);
    }

    public static void sort(String[] words) {
        Arrays.sort(words, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();

            }

        });
        System.out.println(Arrays.toString(words));
    }

}
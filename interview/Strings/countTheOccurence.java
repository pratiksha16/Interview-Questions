package interview.Strings;

import java.util.Arrays;

public class countTheOccurence {

    public static void main(String[] args) {
        String[] words = { "ab", "babc", "bca" };
        String seq = "ababcbabc";
        int[] res = findOccurence(words, seq);
        System.out.println(Arrays.toString(res));
    }

    public static int[] findOccurence(String[] words, String seq) {
        int[] result = new int[words.length];
        int index = 0;
        for (String word : words) {
            if (seq.contains(word)) {
                int count = 0;
                String s = word;
                while (seq.contains(s)) {
                    count++;
                    s += word;
                }
                result[index] = count;
            }
            index++;

        }
        return result;
    }
}

/*

Given an arbitrary ransom note string and another string containing letters from 
all the magazines, write a function that will return true if the ransom note can
 be constructed from the magazines ; otherwise, it will return false.
Each letter in the magazine string can only be used once in your ransom note.

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
*/

package interview.Strings;

public class ransomNote {

    public static void main(String[] args) {
        System.out.println(canBeMade("ab", "aab"));

    }

    public static boolean canBeMade(String ransomNote, String magazine) {
        if (ransomNote.length() == magazine.length() && !ransomNote.equals(magazine)) {
            return false;

        }
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        if (ransomNote.equals(magazine)) {
            return true;
        }

        int i = 0;
        int j = 0;
        while (i < magazine.length() && j < ransomNote.length()) {
            if (ransomNote.charAt(j) == magazine.charAt(i)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        return j == ransomNote.length();

    }

}
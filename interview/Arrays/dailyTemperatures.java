
/*
Given a list of daily temperatures T, return a list such that, for each day in the input, 
tells you how many days you would have to wait until a warmer temperature.
 If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
                                                                                            
                                                                          
  Naive approach:

Two-pointers; i, j;                                                                         
i=0; j=i;                                          ------------|                            
loop till it finds the temperature higher than it self;
count= j-i;
Time Complexity: O(n^2);
Space Complexity: if we don't consider output array as extra space then O(1);
Code:
     List<Integer> myList = new ArrayList<>();
        for (int i = 0; i < temp.size() - 1; i++) {
            int j = i + 1;
            while (j < temp.size() && temp.get(i) > temp.get(j)) {
                j++;

            }
            if (j > temp.size() - 1) {
                myList.add(0);
            } else {
                myList.add(j - i);
            }

        }
        if (myList.size() != temp.size()) {
            myList.add(0);
        }
        return myList;

    }

    Optimized approach: Using Stacks: push the index into the array;

            loop from the end; 
            while the stack is not empty and temp at stack.peek() is greater than the current temp; 
                    // pop out from the stack;
            add (stack.peek()- i intop the output array if stack not empty // else add 0;)
            push(i);
            Time Complexity: o(n);
            Space Complexity: O(n); since we are making a stack of size n;
            

*/

package interview.Arrays;

import java.util.*;

public class dailyTemperatures {

    public static void main(String[] args) {
        int[] temp = { 73, 74, 75, 71, 69, 72, 76, 73 };

        int[] output = findTemperature(temp);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }

    }

    public static int[] findTemperature(int[] temp) {
        Stack<Integer> indexStack = new Stack();
        int[] myList = new int[temp.length];
        for (int i = temp.length - 1; i >= 0; i--) {
            while (!indexStack.isEmpty() && temp[i] >= temp[indexStack.peek()]) {
                indexStack.pop();
            }
            myList[i] = indexStack.isEmpty() ? 0 : indexStack.peek() - i;
            indexStack.push(i);

        }
        return myList;

    }
}
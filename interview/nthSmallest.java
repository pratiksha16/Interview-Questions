/* Find the kth smallest element in a given array;
*/
/* Different approaches:
Approach 1: Sort the given array. Find the element at nth place:
Time Complexity: O(n log n); since we are sorting an array;
Space Complexity: O (1)


Approach 2: Build a max-heap, and poll out the element;
Time Complexity:  O(k log n);
Space Complexity: O(k); since we are building a heap of k elements;
Code:

class Arrays {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 5, 6, 4 };
        int k = 3;
        System.out.println(findKthSmallest(array, k));
    }

    public static int findKthSmallest(int[] array, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int num : array) {
            queue.add(num);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.poll();
    }
 */

/* Approach 3: Randomized quick select;
Time-Complexity: O(n);
Space-complexity: O(1);

*/
package interview;

import java.util.*;

class Arrays {
    public static void main(String[] args) {
        int[] array = { 3, 2, 1, 5, 6, 4 };
        int k = 3;
        System.out.println(findKthSmallest(array, k, 0, array.length - 1));
    }

    public static int findKthSmallest(int[] array, int k, int start, int end) {
        if (start == end) {
            return array[start];
        }

        Random random = new Random();
        int partition = start + random.nextInt(end - start);
        partition = partition(array, start, end, partition);

        if (partition == k) {
            return array[k];
        } else if (partition > k) {
            return findKthSmallest(array, k, start, partition - 1);
        }
        return findKthSmallest(array, k, partition + 1, end);

    }

    public static int partition(int[] array, int start, int end, int pivot_index) {

        int pivot_element = array[pivot_index];
        swap(pivot_index, end, array);
        int j = start;
        for (int i = start; i <= end; i++) {
            if (array[i] < pivot_element) {
                swap(i, j, array);
                j++;
            }
        }
        swap(pivot_index, j, array);
        return j;

    }

    public static void swap(int a, int b, int[] array) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

}

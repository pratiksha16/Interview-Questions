package interview.Array;

import java.util.*;
import java.util.Arrays;

public class restoreArray {

    public static void main(String[] args) {
        int[][] pairs = { { 3, 5 }, { 1, 4 }, { 2, 4 }, { 1, 5 } };
        Integer[] restored = restroeArray(pairs);
        System.out.println(Arrays.toString(restored));
    }

    public static Integer[] restroeArray(int[][] pairs) {
        if (pairs.length == 0)
            return new Integer[] {};
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] pair : pairs) {
            if (!map.containsKey(pair[0])) {
                List<Integer> li = new ArrayList<>();
                li.add(pair[1]);
                map.put(pair[0], li);
            } else {
                List<Integer> li = map.get(pair[0]);
                li.add(pair[1]);
                map.put(pair[0], li);
            }
            if (!map.containsKey(pair[1])) {
                List<Integer> li = new ArrayList<>();
                li.add(pair[0]);
                map.put(pair[1], li);
            } else {
                List<Integer> li = map.get(pair[1]);
                li.add(pair[0]);
                map.put(pair[1], li);
            }
        }
        int start = pairs[0][0];
        for (int i : map.keySet()) {
            if (map.get(i).size() == 1) {
                start = i;
                break;
            }
        }

        List<Integer> ret = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();

        DFS(start, visited, map, ret);

        Integer[] _ret = new Integer[ret.size()];
        ret.toArray(_ret);
        return _ret;
    }

    private static void DFS(int i, Set<Integer> visited, Map<Integer, List<Integer>> adjlist, List<Integer> ret) {
        if (visited.contains(i))
            return;
        visited.add(i);
        ret.add(i);
        for (int j : adjlist.get(i)) {
            DFS(j, visited, adjlist, ret);
        }
    }

}
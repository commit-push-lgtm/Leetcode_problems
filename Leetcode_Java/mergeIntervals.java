import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            int[] lastInterval = result.get(result.size() - 1);
            int[] current = intervals[i];

            if (current[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], current[1]);
            } else {
                result.add(current);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
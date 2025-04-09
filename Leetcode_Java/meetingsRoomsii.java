import java.util.*;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for (int i = 0; i < n; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int start = 0, end = 0;
        int noOfRooms = 0, noOfMeetings = 0;

        while (start < n) {
            if (startTimes[start] < endTimes[end]) {
                start++;
                noOfMeetings++;
            } else {
                end++;
                noOfMeetings--;
            }

            noOfRooms = Math.max(noOfRooms, noOfMeetings);
        }

        return noOfRooms;
    }
}

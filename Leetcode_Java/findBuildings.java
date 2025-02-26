package Leetcode_Java;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] findBuildings(int[] heights) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            while (!result.isEmpty() && heights[result.get(result.size() - 1)] <= heights[i]) {
                result.remove(result.size() - 1);
            }
            result.add(i);
        }

        int[] resultArray = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            resultArray[i] = result.get(i);
        }

        return resultArray;
    }
}

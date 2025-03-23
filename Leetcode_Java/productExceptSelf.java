package Leetcode_Java;

import java.util.Arrays;

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];
        Arrays.fill(answer, 1);

        int prefix = 1;

        for (int i = 0; i < nums.length; i++) {
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;

        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] *= suffix;
            suffix *= nums[i];
        }

        return answer;
    }
}

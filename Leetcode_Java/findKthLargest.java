package Leetcode_Java;

import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.offer(num);
        }
        
        while (k > 1) {
            maxHeap.poll();
            k--;
        }
        
        return maxHeap.poll();
    }
}

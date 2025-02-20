package Leetcode_Java;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

// This is the solution for the problem. Ignore the above code snippets as you will not be asked to implement that in the interview. 

class Solution {
    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();

        Map<Integer, List<Integer>> result = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        
        queue.offer(new Pair<>(root, 0));
        int minColumn = 0, maxColumn = 0;

        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> pair = queue.poll();
            TreeNode node = pair.getKey();
            int column = pair.getValue();

            result.computeIfAbsent(column, k -> new ArrayList<>()).add(node.val);

            minColumn = Math.min(minColumn, column);
            maxColumn = Math.max(maxColumn, column);

            if (node.left != null) {
                queue.offer(new Pair<>(node.left, column - 1));
            }
            if (node.right != null) {
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }

        List<List<Integer>> output = new ArrayList<>();
        for (int i = minColumn; i <= maxColumn; i++) {
            output.add(result.get(i));
        }

        return output;
    }
}
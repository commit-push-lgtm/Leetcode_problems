package Leetcode_Java;

class Solution {
    public String minRemoveToMakeValid(String s) {

        int count = 0;
        StringBuilder initialResult = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                initialResult.append(c);
                count++;
            } else if (c == ')' && count > 0) {
                initialResult.append(c);
                count--;
            } else if (c != ')') {
                initialResult.append(c);
            }
        }

        StringBuilder finalResult = new StringBuilder();
        int openCount = count; 

        for (int i = initialResult.length() - 1; i >= 0; i--) {
            char c = initialResult.charAt(i);
            if (c == '(' && openCount > 0) {
                openCount--;
            } else {
                finalResult.append(c);
            }
        }

        return finalResult.reverse().toString();
    }
}
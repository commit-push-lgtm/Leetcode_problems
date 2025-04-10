import java.util.*;

class Solution {
    public boolean isValid(String s) {
        
        Map<Character, Character> parenthesesMap = Map.of(
            ')', '(', 
            ']', '[', 
            '}', '{'
        );

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (parenthesesMap.containsKey(c)) {
                
                if (!stack.isEmpty() && stack.peek() == parenthesesMap.get(c)) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}
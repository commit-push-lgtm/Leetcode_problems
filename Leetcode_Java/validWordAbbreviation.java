package Leetcode_Java;

class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int wordPtr = 0;
        int abbrPtr = 0;
        
        while (wordPtr < word.length() && abbrPtr < abbr.length()) {
            if (Character.isDigit(abbr.charAt(abbrPtr))) {
                if (abbr.charAt(abbrPtr) == '0') {
                    return false; 
                }
                
                int steps = 0;
                while (abbrPtr < abbr.length() && Character.isDigit(abbr.charAt(abbrPtr))) {
                    steps = steps * 10 + (abbr.charAt(abbrPtr) - '0');
                    abbrPtr++;
                }
                
                wordPtr += steps;
            } else {
                if (wordPtr >= word.length() || word.charAt(wordPtr) != abbr.charAt(abbrPtr)) {
                    return false;
                }
                
                wordPtr++;
                abbrPtr++;
            }
        }
        
        return wordPtr == word.length() && abbrPtr == abbr.length();
    }
}

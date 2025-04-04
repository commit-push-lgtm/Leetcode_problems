class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        charMap = {}
        left = 0
        maxLength = 0

        for right in range(len(s)):
            if s[right] in charMap:
                left = max(left, charMap[s[right]] + 1)
            charMap[s[right]] = right
            maxLength = max(maxLength, right - left + 1)

        return maxLength

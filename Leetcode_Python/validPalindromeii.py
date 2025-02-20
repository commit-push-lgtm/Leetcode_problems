class Solution:
    def checkPalindrome(s , i , j):
            while i < j:
                if s[i] != s[j]:
                    return False
                i += 1
                j -= 1

            return True


    def validPalindrome(self, s: str) -> bool:
        i = 0
        j = len(s) - 1

        while i < j:
            if s[i] != s[j]:
                return Solution.checkPalindrome(s, i , j - 1) or Solution.checkPalindrome(s, i + 1, j)

            i += 1
            j -= 1

        return True
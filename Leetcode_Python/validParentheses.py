class Solution:
    def isValid(self, s: str) -> bool:
        parenthesesMap = { ')' : '(', ']' : '[', '}' : '{'}
        parenthesesStack = []

        for c in s:
            if c in parenthesesMap:
                if parenthesesStack and parenthesesStack[-1] == parenthesesMap[c]:
                    parenthesesStack.pop()
                else:
                    return False
            else:
                parenthesesStack.append(c)

        return True if not parenthesesStack else False

        
class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        count = 0
        initialResult = []

        for c in s:
            if c == "(":
                initialResult.append(c)
                count += 1
            elif c == ")" and count > 0:
                initialResult.append(c)
                count -= 1
            elif c != ")":
                initialResult.append(c)

        finalResult = []

        for c in initialResult[::-1]:
            if c == "(" and count > 0:
                count -= 1
            else:
                finalResult.append(c)

        return "".join(finalResult[::-1])
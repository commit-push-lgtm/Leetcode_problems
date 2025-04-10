class Solution:
    def merge(self, intervals: List[List[int]]) -> List[List[int]]:

        intervals.sort(key = lambda pair: pair[0])
        result = [intervals[0]]

        for start,end in intervals[1:]:
            lastIntervalEnd = result[-1][1]

            if start <= lastIntervalEnd:
                result[-1][1] = max(lastIntervalEnd, end)
            else:
                result.append([start,end])
            
        return result
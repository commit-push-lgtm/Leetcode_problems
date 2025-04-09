class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        startTimes = sorted([i[0] for i in intervals])
        endTimes = sorted([i[1] for i in intervals])

        start, end = 0, 0

        noOfRooms = 0
        noOfMeetings = 0

        while start < len(intervals):
            if startTimes[start] < endTimes[end]:
                start += 1
                noOfMeetings += 1
            else:
                end += 1
                noOfMeetings -= 1

            noOfRooms = max(noOfRooms, noOfMeetings)

        return noOfRooms
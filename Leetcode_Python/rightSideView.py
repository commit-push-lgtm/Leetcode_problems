# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
from typing import List, Optional


class Solution:
    def rightSideView(self, root: Optional[TreeNode]) -> List[int]:
        result = []
        rightSideView = []

        queue = deque()

        if root:
            queue.append(root)

        while queue:
            level = []

            for i in range(len(queue)):

                current = queue.popleft()
                level.append(current.val)

                if(current.left):
                    queue.append(current.left)
                if(current.right):
                    queue.append(current.right)

            result.append(level)

        for i in range(len(result)):
            rightSideView.append(result[i][-1])

        return rightSideView   

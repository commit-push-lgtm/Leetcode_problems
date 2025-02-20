from collections import defaultdict, deque
from typing import List, Optional


class TreeNode:
    def __init__(self, val = 0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def verticalOrder(self, root: Optional[TreeNode]) -> List[List[int]]: 
        
        queue = deque([root, 0])
        result = defaultdict(list)
        
        while queue:
            node, column = queue.popleft()
            if node is not None:
                result[column].append(node.val)
                
                if node.left:
                    queue.append([node.left, column - 1])
                if node.right:
                    queue.append([node.right, column + 1])
                    
        return [result[key] for key in sorted(result.keys())]

          
if __name__ == "__main__":
    pass
class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        rows = len(grid)
        cols = len(grid[0])

        directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

        def bfs(row, col):
            queue = deque()
            grid[row][col] = '0'
            queue.append((row,col))

            while queue:
                row, col = queue.popleft()
                for r, c in directions:
                    newRow = row + r
                    newCol = col + c

                    if(newRow < 0 or newRow >= rows or newCol < 0 or newCol >= cols or grid[newRow][newCol] == '0'):
                        continue
                    
                    queue.append((newRow, newCol))
                    grid[newRow][newCol] = '0'

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    bfs(row, col)
                    islands += 1

        return islands
        
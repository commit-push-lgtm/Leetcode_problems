class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        islands = 0
        rows = len(grid)
        cols = len(grid[0])

        directions = [[1,0], [-1, 0], [0, 1], [0, -1]]

        def dfs(row, col):
            if(row < 0 or row >= rows or col < 0 or col >= cols or grid[row][col] == '0'):
                return
            
            grid[row][col] = '0'
            for r, c in directions:
                dfs(row + r, col + c)
            

        for row in range(rows):
            for col in range(cols):
                if grid[row][col] == '1':
                    dfs(row, col)
                    islands += 1

        return islands
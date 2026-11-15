class Solution {
    boolean[][] visited;
    int row;
    int col;
    public int numIslands(char[][] grid) {
        row = grid.length;
        col = grid[0].length;
        visited = new boolean[row][col];
        int islands = 0;
        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(!visited[r][c]){
                    if(grid[r][c] == '1'){
                        islands++;
                    }

                    countIsland(grid, r, c);
                }
            }
        }
        return islands;

    }



    private void countIsland(char[][] grid, int r, int c){
        if(r < 0 || r >= row || c < 0 || c >= col){
            return;
        }

        else if(visited[r][c]){
            return;
        }
        else{
            visited[r][c] = true;
            if(grid[r][c] == '0'){
                return;
            }
            else{
                countIsland(grid, r - 1, c);
                countIsland(grid, r + 1, c);
                countIsland(grid, r, c - 1);
                countIsland(grid, r, c + 1);
    
            }
        }
    }
}

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] seen = new boolean[row][col];
        int[][] time = new int[row][col];
        int[][] dirs = {{1,0}, {-1, 0}, {0, 1}, {0, -1}};


        Queue <int[]> queue = new LinkedList<>();
        for(int[] r: time){
            Arrays.fill(r, -1);
        }
        int totalSpace = 0;


        for(int r = 0; r < row; r++){
            for(int c = 0; c < col; c++){
                if(grid[r][c] == 2){
                    queue.add(new int[]{r, c});
                    seen[r][c] = true;
                }
                else if(grid[r][c] == 0){
                    totalSpace++;
                }
            }
        }


        if(totalSpace == row*col){
            return 0;
        }


        int count = 0;
        while(!queue.isEmpty()){
            for(int len = queue.size(); len > 0; len --){
                int[] pos = queue.poll();
                time[pos[0]][pos[1]] = count;

                for(int[] dir: dirs){
                    int newR = pos[0] + dir[0];
                    int newC = pos[1] + dir[1];

                    if(!(newR < 0 || newR >= row || newC < 0|| newC >= col)){
                        if(!seen[newR][newC] && grid[newR][newC] != 0){
                            seen[newR][newC] = true;
                            queue.add(new int[]{newR, newC});
                        }
                    }
                }
            }

            count++;
        }

        int max = -1;
        int totalFruit = 0;
        for(int[] resRow: time){
            for(int num: resRow){
                if(num != -1){
                    totalFruit++;
                }
                max = Math.max(max, num);
            }
        }

        if(totalFruit + totalSpace != row*col){
            return -1;
        }

        return max;
        
    }
}
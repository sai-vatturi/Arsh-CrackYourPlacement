import java.util.LinkedList;
import java.util.Queue;

class RottenOrange {
    int timeFrame;
    int posX;
    int posY;
    
    public RottenOrange(int timeFrame, int posX, int posY) {
        this.timeFrame = timeFrame;
        this.posX = posX;
        this.posY = posY;
    }
}

class Solution {
    /*
        BFS with Queue:
        ===============
        1. Initially, create a class for rotten orange, representing position of the rotten orange along with timeFrame
        2. Add all rotten oranges to the queue
        3. while queue is not empty
            --- poll an element from the queue and check for all 4 directions for any good orange
            --- if good orange is found, rotten it and add it to the queue and repeat same process
        4. At the end if the fresh oranges are 0, return maxTime, else return -1
    */
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<RottenOrange> q = new LinkedList<>();
        int freshOranges = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new RottenOrange(0, i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }
        
        if (freshOranges == 0) return 0; 
        
        int[] dx = {-1, 0, 0, 1};
        int[] dy = {0, -1, 1, 0};
        int maxTimeFrame = 0;
        
        while (!q.isEmpty()) {
            RottenOrange orange = q.remove();
            int xPos = orange.posX;
            int yPos = orange.posY;
            int curTime = orange.timeFrame;
            
            for (int i = 0; i < 4; i++) {
                int xIndex = xPos + dx[i];
                int yIndex = yPos + dy[i];
                if (xIndex >= 0 && yIndex >= 0 && xIndex < n && yIndex < m) {
                    if (grid[xIndex][yIndex] == 1) {
                        grid[xIndex][yIndex] = 2;
                        q.offer(new RottenOrange(curTime + 1, xIndex, yIndex));
                        maxTimeFrame = curTime + 1;
                        freshOranges--;  
                    }
                }
            }
        }
        
        return freshOranges == 0 ? maxTimeFrame : -1; 
    }
}
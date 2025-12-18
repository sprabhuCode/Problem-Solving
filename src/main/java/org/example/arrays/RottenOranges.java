package org.example.arrays;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[] row= {0, -1, 0, 1};
        int[] col = {-1, 0, 1, 0};

        int result = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++) {
                if(grid[i][j]==2){
                    queue.add(new int[] {i,j});
                }
            }
        }

        while(!queue.isEmpty()) {
            int size = queue.size();
            boolean rottedThisMinute = false;
            while(size>0) {
                int[] data = queue.poll();

                for (int k = 0; k < 4; k++) {
                    int r = row[k] + data[0];
                    int c = col[k] + data[1];
                    if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1 ) {
                        queue.add(new int[]{r, c});
                        grid[r][c] = 2;
                        rottedThisMinute = true;
                    }
                }
                size--;
            }
            if(rottedThisMinute)
                result++;
        }

        for (int[] ints : grid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    return -1;
                }
            }
        }
        return result;
    }

    public static void main(){
        int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(RottenOranges.orangesRotting(grid));
    }
}

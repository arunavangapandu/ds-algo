
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Set;

// Coding challenge robot grid
// Chapter 8 --- The complete coding interview guide in java
public class ComputePath {

    // Direction vectors for right and down movements

    private static final int[] DIRS = {0,1,1,0}; // Right (0, 1) and down (1,0)
    // Method to find if there is a path from top-left to bottom -right
    public static boolean computePath(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

       // if the starting point or ending point is blocked, return false
        if(grid[0][0] == 1 || grid[rows-1][cols-1] == 1) {
            return false;
        }
        // BFS queue using ArrayDeque
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols] ;

        // start BFS from the top-left corner
        queue.offer(new int[]{0,0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // If we have reached the bottom right corner, return true
            if( x == rows-1 && y == cols-1) {
                return true;
            }

            // Explore the next possible moves right and down
            for(int i =0; i < 2; i++){
                int newX = x + DIRS[i * 2];
                int newY = y + DIRS[i * 2 + 1];

            // check if the new position is within bounds, not visited and not blocked
            if(newX >= 0 && newX < rows && newY >= 0 && newY < cols
                && grid[newX][newY] == 0 && !visited[newX][newY]) {
                queue.offer(new int[] {newX, newY});
                visited[newX][newY] =true;
            }
            }
        }
        return false;

    }
    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        boolean result = computePath(grid);
        if (result) {
            System.out.println("A path exists from top-left to bottom-right.");
        } else {
            System.out.println("No path exists.");
        }
    }
}


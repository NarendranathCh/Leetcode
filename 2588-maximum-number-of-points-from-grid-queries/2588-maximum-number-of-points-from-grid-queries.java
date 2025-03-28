import java.util.*;

class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        int m = grid.length, n = grid[0].length;
        int[] result = new int[queries.length];
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        
        // Pairing the queries with their original indices
        int[][] qIndex = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            qIndex[i][0] = queries[i];
            qIndex[i][1] = i;
        }
        Arrays.sort(qIndex, Comparator.comparingInt(a -> a[0]));
        
        // Min-heap for processing cells in order of values
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{grid[0][0], 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        
        int count = 0, index = 0;
        while (index < queries.length) {
            int query = qIndex[index][0];
            
            // Process all cells in the heap with values < query
            while (!pq.isEmpty() && pq.peek()[0] < query) {
                int[] cell = pq.poll();
                int val = cell[0], r = cell[1], c = cell[2];
                count++;
                
                for (int[] dir : directions) {
                    int nr = r + dir[0], nc = c + dir[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && !visited[nr][nc]) {
                        pq.offer(new int[]{grid[nr][nc], nr, nc});
                        visited[nr][nc] = true;
                    }
                }
            }
            
            // Store the result for all queries with the same value
            while (index < queries.length && qIndex[index][0] == query) {
                result[qIndex[index][1]] = count;
                index++;
            }
        }
        
        return result;
    }
}

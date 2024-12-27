package dfs;

import segment_tree.Pair;

import javax.management.Query;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        int[][] arr = new int[][] {
                {0, 1},
                {1, 0},
                {1, 1},
                {1, 0}
        };
        int count = noOfIslands(arr);
        System.out.println("No of Islands is: " + count);
    }

    public static int noOfIslands(int[][] arr) {
        if (arr.length < 0)
            return 0;
        int count = 0;
        int rows = arr.length;
        int cols = arr[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (arr[i][j] == 1) {
                    count++;
                    dfs(arr, i, j);
                }
            }
        }
        return count;
    }

    public static void bfs(int[][] arr , int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;

        Queue<int[]> queue = new LinkedList();
        queue.add(new int[]{i, j});
        arr[i][j] = 0;

        int[][] directions = new int[][] {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1},
                {-1, -1},
                {-1, 1},
                {1, -1},
                {1, 1}
        };
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currRow = current[0];
            int currCol = current[1];

            for (int[] dir: directions) {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];

                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && arr[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    arr[newRow][newCol] = 0;
                }
            }
        }
    }

    public static void dfs(int[][] arr, int i, int j) {
        int rows = arr.length;
        int cols = arr[0].length;

        if (i < 0 || j < 0 || i >= rows || j >= cols || arr[i][j] == 0) {
            return;
        }

        arr[i][j] = 0;

        dfs(arr, i-1, j);
        dfs(arr, i+1, j);
        dfs(arr, i, j-1);
        dfs(arr, i, j+1);
        dfs(arr, i-1, j-1);
        dfs(arr, i-1, j+1);
        dfs(arr, i+1, j+1);
        dfs(arr, i+1, j-1);
    }



}

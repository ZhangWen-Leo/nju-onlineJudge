package com.wen.contest5.problem1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[][] grid = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution.getResult(grid));
        }
    }

    private int[][] result;
    private boolean[][] check;
    private int[][] grid;
    private int len;
    Queue<int[]> queue;
    static final int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int getResult(int[][] grid) {
        len = grid.length;
        result = new int[len][len];
        check = new boolean[len][len];
        this.grid = grid;
        for (int i = 0; i < len; i++) {
            Arrays.fill(result[i], Integer.MAX_VALUE);
        }
        queue = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);

        result[0][0] = grid[0][0];
        queue.offer(new int[]{grid[0][0], 0, 0});

        return getResultHelp();
    }
    private int getResultHelp() {
        int[] point;
        while (true) {
            do {
                point = queue.poll();
            } while (getCheck(point[1], point[2]));
            int x = point[1], y = point[2];
            if (x == len - 1 && y == len - 1) {
                return result[x][y];
            }
            check[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int xAdd = direction[i][0], yAdd = direction[i][1];
                if (!getCheck(x + xAdd, y + yAdd)) {
                    int cur = result[x][y] + grid[x + xAdd][y+ yAdd];
                    if (cur < result[x + xAdd][y+ yAdd]) {
                        result[x + xAdd][y+ yAdd] = cur;
                        queue.offer(new int[]{cur, x + xAdd, y+ yAdd});
                    }
                }
            }
        }
    }
    private boolean getCheck(int x, int y) {
        return x < 0 || x >= len || y < 0 || y >= len || check[x][y];
    }
}

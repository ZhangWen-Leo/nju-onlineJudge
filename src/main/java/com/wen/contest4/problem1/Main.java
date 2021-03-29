package com.wen.contest4.problem1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int R = scanner.nextInt();
            int C = scanner.nextInt();
            int[][] grid = new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution.getResult(grid));
        }
    }

    private int[][] resultDp;
    private int[][] grid;
    private int getResult(int[][] grid) {
        int r = grid.length;
        if (r == 0) {
            return 0;
        }
        int c = grid[0].length;
        if (c == 0) {
            return 0;
        }
        resultDp = new int[r][c];
        resultDp[r-1][c-1] = grid[r-1][c-1] >= 0 ? 1 : 1 - grid[r-1][c-1];
        this.grid = grid;

        return getResultDp(0, 0);
    }
    private int getResultDp(int x, int y) {
        if (resultDp[x][y] > 0) {
            return resultDp[x][y];
        }
        int r = grid.length, c = grid[0].length;
        resultDp[x][y] = Integer.MAX_VALUE;
        if (x < r - 1) {
            resultDp[x][y] = Math.min(resultDp[x][y], getResultDp(x + 1, y));
        }
        if (y < c - 1) {
            resultDp[x][y] = Math.min(resultDp[x][y], getResultDp(x, y + 1));
        }

        resultDp[x][y] -= grid[x][y];
        if (resultDp[x][y] <= 0) {
            resultDp[x][y] = 1;
        }
        return resultDp[x][y];
    }
}

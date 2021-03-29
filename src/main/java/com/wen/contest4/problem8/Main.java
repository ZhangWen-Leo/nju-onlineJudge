package com.wen.contest4.problem8;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int[][] arrays = new int[n][2];
            for (int i = 0; i < n; i++) {
                arrays[i][0] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                arrays[i][1] = scanner.nextInt();
            }

            System.out.println(solution.getResult(arrays, x, y));
        }
    }

    private int len;
    private int[][][] resultDp;
    private int getResult(int[][] arrays, int x, int y) {
        len = arrays.length;
        resultDp = new int[len][x+1][y+1];
        return getResult(arrays, 0, x, y);
    }
    private int getResult(int[][] arrays, int start, int x, int y) {
        if (start >= len) {
            return 0;
        }
        if (resultDp[start][x][y] > 0) {
            return resultDp[start][x][y];
        }

        resultDp[start][x][y] = 0;
        if (x == 0) {
            for (int i = start; i < len; i++) {
                resultDp[start][x][y] += arrays[i][1];
            }
        }
        else if (y == 0) {
            for (int i = start; i < len; i++) {
                resultDp[start][x][y] += arrays[i][0];
            }
        }
        else {
            resultDp[start][x][y] = Math.max(arrays[start][0] + getResult(arrays, start + 1, x - 1, y),
                    arrays[start][1] + getResult(arrays, start + 1, x, y - 1));
        }

        return resultDp[start][x][y];
    }
}

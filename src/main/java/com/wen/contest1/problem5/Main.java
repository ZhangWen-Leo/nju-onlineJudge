package com.wen.contest1.problem5;

import java.util.Scanner;

public class Main {

    private int[][] timeDp;
    private int[] boards;

    public int paintBoards(int n, int[] boards) {
        int len = boards.length;
        if (len == 0) {
            return 0;
        }
        timeDp = new int[len][n];
        this.boards = boards;
        timeDp[len-1][0] = boards[len-1];
        for (int i = len - 2; i >= 0; i--) {
            timeDp[i][0] = timeDp[i+1][0] + boards[i];
        }

        return getTime(0, n);
    }
    private int getTime(int start, int n) {
        int len = boards.length;

        if (start >= len) {
            return 0;
        }
        if (timeDp[start][n-1] > 0) {
            return timeDp[start][n-1];
        }
        if (n == 1) {
            return timeDp[start][n-1];
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = start; i < len; i++) {
            sum += boards[i];
            min = Math.min(min, Math.max(sum, getTime(i+1, n-1)));
        }

        timeDp[start][n-1] = min;
        return timeDp[start][n-1];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] boards = new int[k];
            for (int i = 0; i < k; i++) {
                boards[i] = scanner.nextInt();
            }

            Main problem = new Main();
            System.out.println(problem.paintBoards(n, boards));
        }
    }
}

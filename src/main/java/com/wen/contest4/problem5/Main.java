package com.wen.contest4.problem5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[][] sellers = new int[n][3];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    sellers[i][j] = scanner.nextInt();
                }
            }

            System.out.println(solution.getResult(sellers));
        }
    }

    private int getResult(int[][] sellers) {
        int[] last = new int[3];
        int[] cur = {sellers[0][0], sellers[0][1], sellers[0][2]};
        int len = sellers.length;

        for (int i = 1; i < len; i++) {
            System.arraycopy(cur, 0, last, 0, 3);

            cur[0] = Math.min(last[1], last[2]) + sellers[i][0];
            cur[1] = Math.min(last[0], last[2]) + sellers[i][1];
            cur[2] = Math.min(last[0], last[1]) + sellers[i][2];
        }

        return Math.min(cur[0], Math.min(cur[1], cur[2]));
    }
}

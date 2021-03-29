package com.wen.contest4.problem4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int h = scanner.nextInt();
            int p = scanner.nextInt();
            int[][] question = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    question[i][j] = scanner.nextInt();
                }
            }

            int res = solution.getResult(h, p, question);
            if (res >= 0) {
                System.out.println("YES " + res);
            }
            else {
                System.out.println("NO");
            }
        }
    }

    private int len;
    private int[][] question;
    private int getResult(int h, int p, int[][] question) {
        len = question.length;
        this.question = question;
        return getResult(0, h, p);
    }
    private int getResult(int start, int h, int p) {
        if (start >= len) {
            return p > 0 ? -1 : 0;
        }
        if (p <= 0) {
            return 0;
        }

        int res = getResult(start + 1, h, p);

        if (res == -1) {
            if (question[start][0] > h) {
                return -1;
            }
            else {
                int subRes = getResult(start + 1, h - question[start][0], p - question[start][1]);
                if (subRes != -1) {
                    res = question[start][0] + subRes;
                }
            }
        }
        else {
            if (question[start][0] <= h) {
                int subRes = getResult(start + 1, h - question[start][0], p - question[start][1]);
                if (subRes != -1) {
                    res = Math.min(res, question[start][0] + subRes);
                }
            }
        }

        return res;
    }
}

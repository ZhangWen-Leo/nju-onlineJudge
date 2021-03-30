package com.wen.contest5.problem6;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int p = scanner.nextInt();
            int[][] pipes = new int[p][3];
            for (int i = 0; i < p; i++) {
                for (int j = 0; j < 3; j++) {
                    pipes[i][j] = scanner.nextInt();
                }
            }

            int[][] res = solution.getResult(pipes, n);
            System.out.println(res.length);
            for (int[] pairs: res) {
                System.out.println(pairs[0] + " " + pairs[1] + " " + pairs[2]);
            }
        }
    }

    private int[][] getResult(int[][] pipes, int n) {
        int[][] matrix = new int[n + 1][4];

        for (int[] pipe: pipes) {
            matrix[pipe[0]][0] = pipe[1];
            matrix[pipe[0]][2] = pipe[2];
            matrix[pipe[1]][1] = pipe[0];
            matrix[pipe[1]][3] = pipe[2];
        }
        List<int[]> res = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (matrix[i][1] == 0) {
                if (matrix[i][0] == 0) {
                    continue;
                }
                int[] pair = new int[3];
                pair[0] = i;
                pair[1] = i;
                pair[2] = matrix[pair[1]][2];
                while (matrix[pair[1]][0] != 0) {
                    pair[1] = matrix[pair[1]][0];
                    pair[2] = Math.min(pair[2], matrix[pair[1]][3]);
                }
                res.add(pair);
            }
        }

        return res.toArray(new int[0][]);
    }
}

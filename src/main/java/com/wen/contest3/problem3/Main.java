package com.wen.contest3.problem3;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int m = scanner.nextInt(), n = scanner.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }

            Main solution = new Main();
            System.out.println(solution.getResult(matrix));
        }
    }

    private int getResult(int[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;

        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            res = Math.max(res, getLineResult(matrix[i]));
        }

        return res;
    }

    private int getLineResult(int[] arr) {
        LinkedList<int[]> list = new LinkedList<>();
        list.add(new int[]{0, -1});
        int res = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            if (arr[i] > list.getFirst()[0]) {
                list.addFirst(new int[]{arr[i], i});
            }
            else if (arr[i] <= list.getFirst()[0]) {
                while (list.size() > 1 && list.get(1)[0] >= arr[i]) {
                    list.removeFirst();
                }
                if (list.size() == 1) {
                    list.addFirst(new int[]{arr[i], i});
                }
                else {
                    list.getFirst()[0] = arr[i];
                }
            }
            for (int[] next : list) {
                res = Math.max(res, (i - next[1] + 1) * next[0]);
            }
        }
        return res;
    }
}

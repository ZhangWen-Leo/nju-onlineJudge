package com.wen.contest3.problem10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int[] arr = new int[N];
            int[] queries = new int[M];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < M; i++) {
                queries[i] = scanner.nextInt();
            }

            Main solution = new Main();
            int[] res = solution.getResult(arr, queries);

            boolean first = true;
            for (int num: res) {
                if (first) {
                    System.out.print(num);
                    first = false;
                }
                else {
                    System.out.print(" " + num);
                }
            }
            System.out.println();
        }
    }

    private int[] getResult(int[] arr, int[] queries) {
        int m = queries.length;
        int[] res = new int[m];

        for (int i = 0; i < m; i++) {
            for (int k : arr) {
                if (k % queries[i] == 0) {
                    res[i]++;
                }
            }
        }
        return res;
    }
}

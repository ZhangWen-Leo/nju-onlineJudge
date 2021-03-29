package com.wen.contest4.problem6;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }

            System.out.println(solution.getResult(arr));
        }
    }

    private int len;
    private int[] resultDp;
    private int[] arr;
    private int getResult(int[] arr) {
        len = arr.length;
        resultDp = new int[len];
        this.arr = arr;
        Arrays.sort(arr);

        return getResult(0);
    }
    private int getResult(int start) {
        if (start >= len) {
            return 0;
        }
        if (resultDp[start] > 0) {
            return resultDp[start];
        }

        int next = start;
        while (next < len && arr[next] == arr[start]) {
            next++;
        }
        resultDp[start] = getResult(next);
        int count = next - start;

        while (next < len && arr[next] == arr[start] + 1) {
            next++;
        }
        resultDp[start] = Math.max(resultDp[start], arr[start] * count + getResult(next));
        return resultDp[start];
    }
}

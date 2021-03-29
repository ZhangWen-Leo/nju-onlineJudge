package com.wen.contest4.problem3;

import java.util.*;

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

    private boolean[][] digitCheck;
    private boolean[] digitUsed;
    private int[] arr;
    private int len;
    private int getResult(int[] arr) {
        len = arr.length;
        digitCheck = new boolean[len][10];
        digitUsed = new boolean[10];
        this.arr = arr;
        for (int i = 0; i < len; i++) {
            int num = arr[i];
            if (num == 0) {
                digitCheck[i][0] = true;
            }
            else {
                while (num != 0) {
                    digitCheck[i][num % 10] = true;
                    num /= 10;
                }
            }
        }

        return getResultHelp(0);
    }
    private int getResultHelp(int start) {
        if (start >= len) {
            return 0;
        }
        int res = getResultHelp(start + 1);
        if (canUse(start)) {
            List<Integer> changed = new ArrayList<>(10);
            for (int i = 0; i < 10; i++) {
                if (!digitUsed[i] && digitCheck[start][i]) {
                    digitUsed[i] = true;
                    changed.add(i);
                }
            }

            res = Math.max(res, arr[start] + getResultHelp(start + 1));

            for (int index: changed) {
                digitUsed[index] = false;
            }
        }

        return res;
    }
    private boolean canUse(int index) {
        for (int i = 0; i < 10; i++) {
            if (digitUsed[i] && digitCheck[index][i]) {
                return false;
            }
        }

        return true;
    }
}

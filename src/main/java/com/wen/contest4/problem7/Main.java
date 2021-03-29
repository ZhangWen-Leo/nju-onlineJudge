package com.wen.contest4.problem7;

import java.util.Scanner;

public class Main {
    /**
     * 未通过
     */
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

    private int getResult(int[] arr) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int[] leftSum = new int[len], rightSum = new int[len];
        leftSum[0] = arr[0];
        rightSum[len - 1] = arr[len - 1];
        for (int i = 1; i < len; i++) {
            leftSum[i] = leftSum[i - 1] + arr[i];
        }
        for (int i = len - 2; i >= 0; i--) {
            rightSum[i] = rightSum[i + 1] + arr[i];
        }

        int[] leftDp = new int[len], rightDp = new int[len];
        int max = Integer.MIN_VALUE;
        int maxIndex = len - 1;
        for (int i = len - 1; i >= 0; i--) {
            if (leftSum[i] >= max) {
                max = leftSum[i];
                maxIndex = i;
            }
            rightDp[i] = leftSum[maxIndex] - leftSum[i];
        }
        max = Integer.MIN_VALUE;
        maxIndex = 0;
        for (int i = 0; i < len; i++) {
            if (rightSum[i] >= max) {
                max = rightSum[i];
                maxIndex = i;
            }
            leftDp[i] = rightSum[maxIndex] - rightSum[i];
        }

        int res = leftSum[len - 1];
        for (int i = 0; i < len; i++) {
            res = Math.max(res, leftDp[i] + rightDp[i]);
        }

        return res;
    }
}

package com.wen.contest3.problem11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            char[] numsStr = scanner.nextLine().toCharArray();
            int[] arr = new int[numsStr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = numsStr[i] - '0';
            }

            Main solution = new Main();
            System.out.println(solution.getResult(arr));
        }
    }

    private int getResult(int[] arr) {
        int len = arr.length;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + arr[i];
        }

        int res;
        if (len % 2 == 0) {
            res = len;
        }
        else {
            res = len - 1;
        }
        while (res > 0) {
            for (int i = 0; i + res <= len; i++) {
                int middle = i + res / 2;
                if (sum[middle] - sum[i] == sum[i + res] - sum[middle]) {
                    return res;
                }
            }
            res -= 2;
        }

        return 0;
    }
}

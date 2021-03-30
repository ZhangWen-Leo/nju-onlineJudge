package com.wen.contest5.problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] road1 = new int[n], road2 = new int[m];
            for (int i = 0; i < n; i++) {
                road1[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                road2[i] = scanner.nextInt();
            }

            System.out.println(solution.getResult(road1, road2));
        }
    }

    private int getResult(int[] road1, int[] road2) {
        return getResult(road1, 0, road2, 0);
    }
    private int getResult(int[] road1, int start1, int[] road2, int start2) {
        int len1 = road1.length, len2 = road2.length;
        if (start1 >= len1) {
            return getSum(road2, start2);
        }
        if (start2 >= len2) {
            return getSum(road1, start1);
        }

        int sum1 = road1[start1], sum2 = road2[start2];
        while ((start1 < len1 - 1 || start2 < len2 - 1) && road1[start1] != road2[start2]) {
            if (start1 < len1 - 1 && start2 < len2 - 1) {
                if (road1[start1] < road2[start2]) {
                    sum1 += road1[++start1];
                }
                else {
                    sum2 += road2[++start2];
                }
            }
            else if (start1 < len1 - 1) {
                sum1 += road1[++start1];
            }
            else {
                sum2 += road2[++start2];
            }
        }
        if (road1[start1] == road2[start2]) {
            return Math.max(sum1, sum2) + getResult(road1, start1 + 1, road2, start2 + 1);
        }
        else {
            return Math.max(sum1, sum2);
        }
    }
    private int getSum(int[] arr, int start) {
        int sum = 0;
        int len = arr.length;
        for (int i = start; i < len; i++) {
            sum += arr[i];
        }

        return sum;
    }

}

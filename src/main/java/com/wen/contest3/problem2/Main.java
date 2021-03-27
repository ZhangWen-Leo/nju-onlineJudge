package com.wen.contest3.problem2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /**
     * 未通过，题目意思不明
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] numsStr = scanner.nextLine().split(" ");
            int[] arr = new int[numsStr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numsStr[i]);
            }
            numsStr = scanner.nextLine().split(" ");
            int left = Integer.parseInt(numsStr[0]), right = Integer.parseInt(numsStr[1]);
            int k = Integer.parseInt(scanner.nextLine());

            Main solution = new Main();
            System.out.println(solution.getResult(arr, left, right, k));
        }
    }

    private int getResult(int[] arr, int left, int right, int k) {
        int len = arr.length;
        Arrays.sort(arr);
        int start = 0;
        while (start < len && arr[start] < left) {
            start++;
        }

        while (k > 1 && start < len) {
            while (start < len - 1 && arr[start] == arr[start + 1]) {
                start++;
            }
            start++;
            k--;
        }

        return arr[start];
    }
}

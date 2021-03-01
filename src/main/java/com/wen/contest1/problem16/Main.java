package com.wen.contest1.problem16;

import java.util.Scanner;

public class Main {

    public void insertionSort(int[] arr) {
        int len = arr.length;
        int cur = 0;

        while (cur < len) {
            int i = 0;
            int num = arr[cur];
            while (i < cur && num > arr[i]) {
                i++;
            }
            arrayMoveOneStep(arr, i, cur);
            arr[i] = num;

            cur++;
        }
    }
    public void arrayMoveOneStep(int[] arr, int from, int to) {
        if (from == to) {
            return;
        }

        for (int i = to; i > from; i--) {
            arr[i] = arr[i-1];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] nums = scanner.nextLine().split(" ");
            int N = nums.length;
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(nums[j]);
            }

            Main problem = new Main();
            problem.insertionSort(A);
            if (A.length > 0) {
                System.out.print(A[0]);
                for (int j = 1; j < A.length; j++) {
                    System.out.print(" " + A[j]);
                }
            }
            System.out.println("");
        }
    }

}

package com.wen.contest1.problem17;

import java.util.Scanner;

public class Main {

    public int[] bubbleSort(int[] arr) {
        int len = arr.length;

        for (int tail = len; tail > 1; tail--) {
            for (int i = 0; i < tail - 1; i++) {
                if (arr[i] > arr[i+1]) {
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            String[] nums = scanner.nextLine().split(" ");
            int N = nums.length;
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(nums[j]);
            }

            Main problem = new Main();
            arr = problem.bubbleSort(arr);
            if (arr.length > 0) {
                System.out.print(arr[0]);
                for (int j = 1; j < arr.length; j++) {
                    System.out.print(" " + arr[j]);
                }
            }
            System.out.println("");
        }
    }
}

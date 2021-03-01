package com.wen.contest1.problem22;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public void shellSort(int[] arr, int step) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = arr.length;

        for (int i = 0; i < len && i < step; i++) {
            for (int j = i; j < len; j += step) {
                queue.offer(arr[j]);
            }
            for (int j = i; j < len; j += step) {
                arr[j] = queue.poll();
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] nums = scanner.nextLine().split(" ");
            int N = nums.length;
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(nums[i]);
            }
            String[] indexes = scanner.nextLine().split(" ");
            int M = indexes.length;
            int[] steps = new int[M];
            for (int i = 0; i < M; i++) {
                steps[i] = Integer.parseInt(indexes[i]);
            }

            Main problem = new Main();
            for (int i = 0; i < M; i++) {
                problem.shellSort(arr, steps[i]);
            }

            if (N > 0) {
                System.out.print(arr[0]);
                for (int i = 1; i < N; i++) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println("");
        }
    }
}

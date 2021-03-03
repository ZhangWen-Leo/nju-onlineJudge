package com.wen.contest1.problem25;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public void sort(int[] arr) {
        int len = arr.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o2[0] - o1[0];
                }
                else {
                    return o1[1] - o2[1];
                }
            }
        });

        for (int i = 0; i < len; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Integer num : map.keySet()) {
            queue.offer(new int[]{map.get(num), num});
        }

        int c = 0;
        while (!queue.isEmpty()) {
            int[] num = queue.poll();
            for (int i = 0; i < num[0]; i++) {
                arr[c++] = num[1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            Main problem = new Main();
            problem.sort(arr);
            if (arr.length > 0) {
                System.out.print(arr[0]);
                for (int i = 1; i < arr.length; i++) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println("");
        }
    }
}

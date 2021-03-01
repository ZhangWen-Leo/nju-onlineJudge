package com.wen.contest1.problem14;

import java.util.*;

public class Main {

    public int[] mergeKArrays(int[][] arrays) {
        int K = arrays.length;
        int len = arrays[0].length;
        int[] res = new int[K * len];

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) {
                    return -1;
                }
                else if (o1[0] > o2[0]) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
        });

        for (int i = 0; i < K; i++) {
            queue.offer(new int[]{arrays[i][0], i, 0});
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int[] min = queue.poll();
            res[i++] = min[0];

            if (min[2] < len-1) {
                min[0] = arrays[min[1]][min[2]+1];
                min[2]++;
                queue.offer(min);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] nums = scanner.nextLine().split(" ");
            int[][] arrays = new int[N][nums.length / N];
            int c = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < nums.length / N; k++) {
                    arrays[j][k] = Integer.parseInt(nums[c++]);
                }
            }
            Main problem = new Main();
            int[] res = problem.mergeKArrays(arrays);
            if (res.length > 0) {
                System.out.print(res[0]);
                for (int j = 1; j < res.length; j++) {
                    System.out.print(" " + res[j]);
                }
            }
            System.out.println("");
        }
    }
}

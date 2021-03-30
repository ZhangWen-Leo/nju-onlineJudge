package com.wen.contest5.problem5;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] arriveTimes = new int[n], departTimes = new int[n];
            for (int i = 0; i < n; i++) {
                arriveTimes[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                departTimes[i] = scanner.nextInt();
            }

            System.out.println(solution.getResult(arriveTimes, departTimes));
        }
    }

    private int getResult(int[] arriveTimes, int[] departTimes) {
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o1[0] - o2[0]));

        for (int num: arriveTimes) {
            queue.offer(new int[]{num, 0});
        }
        for (int num: departTimes) {
            queue.offer(new int[]{num, 1});
        }

        int cur = 0;
        int max = 0;
        while (!queue.isEmpty()) {
            if (queue.poll()[1] == 0) {
                cur++;
                max = Math.max(max, cur);
            }
            else {
                cur--;
            }
        }

        return max;
    }
}

package com.wen.contest5.problem4;

import java.util.Arrays;
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
            int[][] jobs = new int[n][2];
            for (int i = 0; i < n; i++) {
                scanner.nextInt();
                jobs[i][0] = scanner.nextInt();
                jobs[i][1] = scanner.nextInt();
            }

            int[] res = solution.getResult(jobs);
            System.out.println(res[0] + " " + res[1]);
        }
    }

    private int[] getResult(int[][] jobs) {
        Arrays.sort(jobs, ((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            }
            else {
                return o2[0] - o1[0];
            }
        }));

        int len = jobs.length;
        int[] res = new int[2];
        Queue<int[]> queue = new PriorityQueue<>(((o1, o2) -> o2[1] - o1[1]));

        int cur = 0;
        while (cur < len) {
            int i = cur;
            while (i < len && jobs[i][0] == jobs[cur][0]) {
                queue.offer(jobs[i]);
                i++;
            }

            int curDeadLine = jobs[cur][0];
            int nextDeadLine = i < len ? jobs[i][0] : 0;
            for (int j = 0; j < curDeadLine - nextDeadLine; j++) {
                if (!queue.isEmpty()) {
                    res[0]++;
                    res[1] += queue.poll()[1];
                }
                else {
                    break;
                }
            }

            cur = i;
        }

        return res;
    }
}

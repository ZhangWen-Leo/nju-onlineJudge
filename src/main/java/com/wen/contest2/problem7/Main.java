package com.wen.contest2.problem7;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public int[] searching3(LinkedList<int[]> intervals, int[] queries) {
        int len = queries.length;
        int[] res = new int[len];
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for (int i = 0; i < len; i++) {
            queue.offer(new int[]{queries[i], i});
        }

        int pre = 0;
        while (!queue.isEmpty()) {
            int[] query = queue.poll();
            query[0] -= pre;

            int gap = intervals.get(0)[1] - intervals.get(0)[0] + 1;
            while (gap < query[0]) {
                query[0] -= gap;
                pre += gap;
                intervals.removeFirst();
                gap = intervals.get(0)[1] - intervals.get(0)[0] + 1;
            }
            res[query[1]] = intervals.get(0)[0] + query[0] - 1;
            pre += query[0] - 1;
            intervals.get(0)[0] = res[query[1]];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int Q = scanner.nextInt();
            LinkedList<int[]> intervals = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                int[] interval = new int[2];
                interval[0] = scanner.nextInt();
                interval[1] = scanner.nextInt();
                intervals.addLast(interval);
            }
            int[] queries = new int[Q];
            for (int i = 0; i < Q; i++) {
                queries[i] = scanner.nextInt();
            }

            Main problem = new Main();
            int[] res = problem.searching3(intervals, queries);
            if (res.length > 0) {
                System.out.print(res[0]);
                for (int i = 1; i < res.length; i++) {
                    System.out.print(" " + res[i]);
                }
            }
            System.out.println();
        }
    }
}

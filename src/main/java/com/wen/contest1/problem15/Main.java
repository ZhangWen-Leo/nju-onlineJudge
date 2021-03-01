package com.wen.contest1.problem15;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    public int numOfSwaps(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int len = arr.length, res = 0;

        for (int i = 0; i < len; i++) {
            map.put(arr[i], i);
            queue.offer(arr[i]);
        }

        for (int i = 0; i < len; i++) {
            if (arr[i] != queue.peek()) {
                map.replace(arr[i], map.get(queue.peek()));
                arr[map.get(queue.peek())] = arr[i];
                res++;
            }
            queue.poll();
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] A = new int[N];
            for (int j = 0; j < N; j++) {
                A[j] = scanner.nextInt();
            }

            Main problem = new Main();

            System.out.println(problem.numOfSwaps(A));
        }
    }

}

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
                int j = map.get(queue.peek());
                int num = arr[j];
                arr[j] = arr[i];
                map.put(arr[j], j);
                arr[i] = num;
                map.put(arr[i], i);
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

            System.out.print(problem.numOfSwaps(A));
            if (i == T-1) {
                System.out.println("");
            }
            else {
                System.out.println(" ");
            }
        }
    }

}

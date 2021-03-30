package com.wen.contest5.problem10;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] numsStr = scanner.nextLine().split(" ");
            int[] arr = new int[numsStr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numsStr[i]);
            }
            int w = Integer.parseInt(scanner.nextLine());

            System.out.println(solution.getResult(arr, w));
        }
    }

    private int getResult(int[] arr, int w) {
        int len = arr.length;
        int cur = -1;
        LinkedList<Integer> list = new LinkedList<>();
        while (cur < w - 2 && cur < len - 1) {
            cur++;
            while (!list.isEmpty() && arr[cur] > list.getLast()) {
                list.removeLast();
            }
            list.addLast(arr[cur]);
        }
        int left = 0;
        int sum = 0;
        while (cur < len - 1) {
            cur++;
            while (!list.isEmpty() && arr[cur] > list.getLast()) {
                list.removeLast();
            }
            list.addLast(arr[cur]);

            sum += list.getFirst();

            if (arr[left] == list.getFirst()) {
                list.removeFirst();
            }
            left++;
        }

        return sum;
    }
}

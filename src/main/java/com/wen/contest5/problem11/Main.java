package com.wen.contest5.problem11;

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
            int sub = Integer.parseInt(scanner.nextLine());

            System.out.println(solution.getResult(arr, sub));
        }
    }

    private int getResult(int[] arr, int sub) {
        int len = arr.length;
        if (len == 0) {
            return 0;
        }
        int left = 0, right = -1;
        LinkedList<Integer> maxList = new LinkedList<>();
        LinkedList<Integer> minList = new LinkedList<>();
        int res = 0;

        while (right < len - 1) {
            right++;
            while (!maxList.isEmpty() && arr[right] > maxList.getLast()) {
                maxList.removeLast();
            }
            maxList.addLast(arr[right]);
            while (!minList.isEmpty() && arr[right] < minList.getLast()) {
                minList.removeLast();
            }
            minList.addLast(arr[right]);

            int max = maxList.getFirst();
            int min = minList.getFirst();

            if (max - min > sub) {
                do {
                    res += len - right;
                    if (arr[left] == maxList.getFirst()) {
                        maxList.removeFirst();
                    }
                    if (arr[left] == minList.getFirst()) {
                        minList.removeFirst();
                    }
                    left++;
                    max = maxList.getFirst();
                    min = minList.getFirst();
                } while (max - min > sub);
            }
        }

        return res;
    }
}

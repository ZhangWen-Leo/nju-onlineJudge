package com.wen.contest3.problem2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] numsStr = scanner.nextLine().split(" ");
            int[] arr = new int[numsStr.length];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(numsStr[i]);
            }
            numsStr = scanner.nextLine().split(" ");
            int left = Integer.parseInt(numsStr[0]), right = Integer.parseInt(numsStr[1]);
            int k = Integer.parseInt(scanner.nextLine());

            Main solution = new Main();
            System.out.println(solution.getResult(arr, left, right, k));
        }
    }

    private int getResult(int[] arr, int left, int right, int k) {

        List<Integer> list = new ArrayList<>(right - left + 1);
        for (int i = left - 1; i <= right - 1; i++) {
            list.add(arr[i]);
        }
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        return list.get(k - 1);
    }
}

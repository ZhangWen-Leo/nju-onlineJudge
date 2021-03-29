package com.wen.contest3.problem5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] numsStr = scanner.nextLine().split("");
            if (numsStr[0].equals("0")) {
                System.out.println("Not Possible");
                continue;
            }
            Integer[] arr;
            boolean minus;
            if (numsStr[0].equals("-")) {
                arr = new Integer[numsStr.length - 1];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(numsStr[i + 1]);
                }
                minus = true;
            }
            else {
                arr = new Integer[numsStr.length];
                for (int i = 0; i < arr.length; i++) {
                    arr[i] = Integer.parseInt(numsStr[i]);
                }
                minus = false;
            }

            Main solution = new Main();
            int res = solution.getResult(arr);
            if (res < 0) {
                System.out.println("Not Possible");
            }
            else {
                System.out.println(minus ? -res : res);
            }
        }
    }

    private int getResult(Integer[] arr) {
        int len = arr.length;
        boolean[] used = new boolean[len];
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        return getResult(arr, used, 0, len);
    }
    private int getResult(Integer[] arr, boolean[] used, int num, int offset) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                int newNum = num * 10 + arr[i];
                if (offset == 1) {
                    if (newNum % 17 == 0) {
                        return newNum;
                    }
                }
                else {
                    int subRes = getResult(arr, used, newNum, offset - 1);
                    if (subRes >= 0) {
                        return subRes;
                    }
                }
                used[i] = false;
            }
        }
        return -1;
    }
}

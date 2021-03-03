package com.wen.contest2.problem6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public void sortWithAnotherArr(int[] arr, int[] arr2) {
        int len = arr.length, len2 = arr2.length;
        int[] arrCopy = Arrays.copyOf(arr, len);
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: arr2) {
            map.put(num, 0);
        }
        int end = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            }
            else {
                arrCopy[end++] = arr[i];
            }
        }
        arrCopy = Arrays.copyOf(arrCopy, end);
        Arrays.sort(arrCopy);

        int k = 0;
        for (int i = 0; i < len2; i++) {
            int num = map.get(arr2[i]);
            for (int j = 0; j < num; j++) {
                arr[k++] = arr2[i];
            }
        }
        System.arraycopy(arrCopy, 0, arr, k, arrCopy.length);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N1 = scanner.nextInt();
            int N2 = scanner.nextInt();
            int[] arr = new int[N1];
            int[] arr2 = new int[N2];
            for (int i = 0; i < N1; i++) {
                arr[i] = scanner.nextInt();
            }
            for (int i = 0; i < N2; i++) {
                arr2[i] = scanner.nextInt();
            }

            Main problem = new Main();
            problem.sortWithAnotherArr(arr, arr2);
            if (N1 > 0) {
                System.out.print(arr[0]);
                for (int i = 1; i < N1; i++) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println("");
        }
    }
}

package com.wen.contest1.problem7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<List<Integer>> solve(int[] arr) {
        int start = 0, len = arr.length, end;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; start < len; i++) {
            end = Math.min(len, start + (int) Math.pow(2, i));

            int[] subArr = new int[end - start];
            subArr = Arrays.copyOfRange(arr, start, end);
            Arrays.sort(subArr);

            List<Integer> list = new ArrayList<>(subArr.length);
            for (int j = 0; j < subArr.length; j++) {
                list.add(subArr[j]);
                while (j < subArr.length - 1 && subArr[j] == subArr[j+1]) {
                    j++;
                }
            }
            res.add(list);
            start = end;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = scanner.nextInt();
            }

            Main problem = new Main();
            List<List<Integer>> res = problem.solve(arr);
            for (int i = 0; i < res.size(); i++) {
                List<Integer> list = res.get(i);
                System.out.print(list.get(0));
                for (int j = 1; j < list.size(); j++) {
                    System.out.print(" " + list.get(j));
                }
                System.out.println("");
            }
        }
    }
}

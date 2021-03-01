package com.wen.contest1.problem18;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public int[] sort(int[] array) {
        int len = array.length;
        int[][] count = new int[len][2];

        for (int i = 0; i < len; i++) {
            count[i][0] = 0;
            count[i][1] = i;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (array[j] > array[i]) {
                    count[j][0]++;
                }
            }
        }

        Arrays.sort(count, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[] res = new int[len];
        for (int i = 0; i < len; i++) {
            res[i] = array[count[i][1]];
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        Main problem = new Main();
        array = problem.sort(array);
        if (n < 1) {
            return;
        }
        else {
            System.out.print(array[0]);
            for (int i = 1; i < n; i++) {
                System.out.print(" " + array[i]);
            }
            System.out.println();
        }
    }
}

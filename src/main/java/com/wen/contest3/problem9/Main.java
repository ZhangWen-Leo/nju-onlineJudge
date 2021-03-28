package com.wen.contest3.problem9;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] strings = scanner.nextLine().split(",");

            List<Integer> res = solution.match(strings[0], strings[1]);
            boolean first = true;
            for (int index: res) {
                if (first) {
                    System.out.print(index);
                    first = false;
                }
                else {
                    System.out.print(" " + index);
                }
            }
            System.out.println();
        }
    }

    private List<Integer> match(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] next = getNext(p);
        int sLen = s.length(), pLen = p.length();

        int i = 0, j = 0;
        while (i < sLen) {
            if (j == -1 || s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            else {
                j = next[j];
            }

            if (j == pLen) {
                res.add(i - j);
                j = next[j];
            }
        }

        return res;
    }

    private int[] getNext(String p) {
        int len = p.length();
        if (len == 0) {
            return new int[0];
        }
        int[] res = new int[len + 1];

        res[0] = -1;
        int k = -1, j = 0;
        while (j < len) {
            if (k == -1 || p.charAt(j) == p.charAt(k)) {
                res[++j] = ++k;
            }
            else {
                k = res[k];
            }
        }
        return res;
    }
}

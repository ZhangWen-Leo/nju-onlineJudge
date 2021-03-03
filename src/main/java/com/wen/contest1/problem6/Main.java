package com.wen.contest1.problem6;

import java.util.Scanner;

public class Main {
    public int numCanKill(long power) {
        for (int i = 1; true; i++) {
            if ((power -= Math.pow(i, 2)) < 0) {
                return i - 1;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            long P = scanner.nextLong();

            Main problem = new Main();
            System.out.println(problem.numCanKill(P));
        }
    }
}

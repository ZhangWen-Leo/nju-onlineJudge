package com.wen.contest1.problem8;

import java.util.Scanner;

public class Main {

    private int calculate(int a, int b, int c) {
        if (a > c) {
            return calculate(a % c, b, c);
        }

        if (b == 1) {
            return a % c;
        }
        else if (b == 0) {
            return 1;
        }
        else if (b % 2 == 0) {
            long aa = (long) a * a;
            return calculate((int) (aa % c), b / 2, c);
        }
        else {
            return (calculate(a, 1, c) * calculate(a, b - 1, c)) % c;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int a, b, c;
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();

            Main problem = new Main();
            System.out.println(problem.calculate(a, b, c));
        }
    }
}

package com.wen.contest4.problem2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();

            System.out.println(solution.getResult(n));
        }
    }

    private static boolean[] resultOddDp = {false, false, true, true, true, false, true};
    private int getResult(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (getResultOddDp((int) Math.pow(i * i, 3))) {
                count++;
            }
            for (int j = i + 1; j <= n; j++) {
                if (getResultOddDp((int) Math.pow(i * j, 3))) {
                    count += 2;
                }
            }
        }

        return count;
    }
    private boolean getResultOddDp(int i) {
        return resultOddDp[i % 7];
    }
}

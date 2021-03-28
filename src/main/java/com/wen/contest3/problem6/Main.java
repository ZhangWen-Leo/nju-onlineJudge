package com.wen.contest3.problem6;

import java.util.Scanner;

public class Main {
    /**
     * 未通过，RuntimeError，原因未知
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();

            System.out.println(solution.getResult(n));
        }
    }

    private static final int mod = 1000000007;
    private int getResult(int n) {
        if (n == 1) {
            return 1;
        }
        int beforeLast;
        int last = 0;
        int cur = 1;
        int left = n - 1;
        if (n > 1000000000) {
            last = 999999973;
            cur = 21;
            left = n - 1000000000;
        }
        else if (n > 900000000) {
            last = 780396802;
            cur = 662356693;
            left = n - 900000000;
        }
        else if (n > 800000000) {
            last = 445100786;
            cur = 530142919;
            left = n - 800000000;
        }
        else if (n > 700000000) {
            last = 457037277;
            cur = 393241336;
            left = n - 700000000;
        }
        else if (n > 600000000) {
            last = 534952325;
            cur = 4660654;
            left = n - 600000000;
        }
        else if (n > 500000000) {
            last = 355333862;
            cur = 864787550;
            left = n - 500000000;
        }
        else if (n > 400000000) {
            last = 555285113;
            cur = 392460984;
            left = n - 400000000;
        }
        else if (n > 300000000) {
            last = 832459368;
            cur = 967988087;
            left = n - 300000000;
        }
        else if (n > 200000000) {
            last = 708713046;
            cur = 371975563;
            left = n - 200000000;
        }
        else if (n > 100000000) {
            last = 36891058;
            cur = 908460138;
            left = n - 100000000;
        }
        for (int i = 0; i < left; i++) {
            beforeLast = last;
            last = cur;
            cur = (beforeLast + last) % mod;
        }
        return (cur + last) % mod;
    }
}

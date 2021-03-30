package com.wen.contest5.problem3;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = scanner.nextInt();
            }

            Arrays.sort(coins);
            System.out.println(solution.getResult(coins, target));
        }
    }

    private int getResult(int[] coins, int target) {
        if (target == 0) {
            return 0;
        }
        int len = coins.length;

        for (int i = len - 1; i >= 0; i--) {
            if (coins[i] > target) {
                continue;
            }
            else if (coins[i] == target) {
                return 1;
            }
            else {
                int subRes = getResult(coins, target - coins[i]);
                if (subRes >= 0) {
                    return subRes + 1;
                }
            }
        }

        return -1;
    }
}

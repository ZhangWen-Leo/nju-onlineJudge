package com.wen.contest1.problem23;

import java.util.Scanner;

public class Main {
    public int[][] coverChessboard(int n, int[] point, int[] target) {
        int[][] res = new int[2][2];
        int sub = (int) Math.pow(2, n-1);
        int pointSrc = getSrc(sub, point[0], point[1]);
        int targetSrc = getSrc(sub, target[0], target[1]);

        int[] newPoint = new int[2], newTarget = new int[2];
        if (pointSrc == targetSrc) {
            newPoint[0] = pointSrc / 2 > 0 ? point[0] - sub : point[0];
            newPoint[1] = pointSrc % 2 > 0 ? point[1] - sub : point[1];
        }
        else {
            if ((target[0] == sub-1 || target[0] == sub) && (target[1] == sub-1 || target[1] == sub)) {
                int k = 0;
                for (int i = 0; i < 4; i++) {
                    if (k < 2 && i != pointSrc && i != targetSrc) {
                        res[k][0] = i / 2 > 0 ? sub : sub - 1;
                        res[k][1] = i % 2 > 0 ? sub : sub - 1;
                        k++;
                    }
                }
                return res;
            }
            newPoint[0] = targetSrc / 2 > 0 ? 0 : sub - 1;
            newPoint[1] = targetSrc % 2 > 0 ? 0 : sub - 1;
        }
        newTarget[0] = targetSrc / 2 > 0 ? target[0] - sub : target[0];
        newTarget[1] = targetSrc % 2 > 0 ? target[1] - sub : target[1];
        res = coverChessboard(n-1, newPoint, newTarget);
        if (targetSrc / 2 > 0) {
            res[0][0] += sub;
            res[1][0] += sub;
        }
        if (targetSrc % 2 > 0) {
            res[0][1] += sub;
            res[1][1] += sub;
        }
        return res;
    }
    private int getSrc(int sub, int i, int j) {
        return 2 * (i / sub) + (j / sub);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int n = scanner.nextInt();
            int[] point = new int[2], target = new int[2];
            point[0] = scanner.nextInt();
            point[1] = scanner.nextInt();
            target[0] = scanner.nextInt();
            target[1] = scanner.nextInt();

            Main problem = new Main();

            int[][] res = problem.coverChessboard(n, point, target);
            System.out.println(res[0][0] + " " + res[0][1] + "," + res[1][0] + " " + res[1][1]);
        }
    }
}

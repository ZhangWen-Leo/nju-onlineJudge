package com.wen.contest3.problem8;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main solution = new Main();

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] points = new int[N][2];
            for (int n = 0; n < N; n++) {
                String[] pointStr = scanner.nextLine().split(" ");
                points[n][0] = Integer.parseInt(pointStr[0]);
                points[n][1] = Integer.parseInt(pointStr[1]);
            }

            System.out.println(solution.getResult(points));
        }
    }

    private int getResult(int[][] points) {
        int count = 0;
        HashMap<Integer, Integer> xMap = new HashMap<>(), yMap = new HashMap<>();
        for (int[] point: points) {
            if (!xMap.containsKey(point[0])) {
                xMap.put(point[0], 0);
            }
            count += xMap.get(point[0]);
            xMap.put(point[0], xMap.get(point[0]) + 1);

            if (!yMap.containsKey(point[1])) {
                yMap.put(point[1], 0);
            }
            count += yMap.get(point[1]);
            yMap.put(point[1], yMap.get(point[1]) + 1);
        }

        return count;
    }
}

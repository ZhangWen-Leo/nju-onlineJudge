package com.wen.contest2.problem5;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public List<Double> searching4(int[] points) {
        int len = points.length - 1;
        List<Double> res = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            while (i < len && points[i] == points[i+1]) {
                i++;
            }
            if (i >= len) {
                break;
            }
            if (calculate(points, points[i]) == 0) {
                res.add(points[i] + 0.0000000001);
            }
            double left = points[i] + 0.001, right = points[i+1] - 0.001;
            double accuracy = 1;
            boolean leftIsBigger = calculate(points, left) > 0;
            while (accuracy >= 0.00001) {
                double middle = (left + right) / 2;
                double current = calculate(points, middle);
                if (leftIsBigger) {
                    if (current > 0) {
                        left = middle;
                    }
                    else if (current < 0) {
                        right = middle;
                    }
                    else {
                        left = middle;
                        right = middle;
                    }
                }
                else {
                    if (current > 0) {
                        right = middle;
                    }
                    else if (current < 0) {
                        left = middle;
                    }
                    else {
                        left = middle;
                        right = middle;
                    }
                }

                if (right - left < accuracy) {
                    accuracy /= 10;
                }
            }
            res.add((left + right) / 2);
        }
        if (calculate(points, points[len]) == 0) {
            res.add(points[len] + 0.0000000001);
        }
        return res;
    }
    private double calculate(int[] points, double point) {
        double res = 0;
        for (int i = 0; i < points.length; i++) {
            if (point != points[i]) {
                res += 1 / (point - points[i]);
            }
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
            List<Double> res = problem.searching4(arr);
            if (res.size() > 0) {
                System.out.print(String.format("%.2f", res.get(0)));
                for (int i = 1; i < res.size(); i++) {
                    System.out.print(" " + String.format("%.2f", res.get(i)));
                }
            }
            System.out.println();
        }
    }
}

package com.wen.contest1.problem9;

import java.util.*;

public class Main {

    public HashSet<Integer> findConvex(int[][] points) {
        HashSet<Integer> res = new HashSet<>();
        int len = points.length;
        if (len <= 1) {
            return res;
        }

        int maxY = 0, minY = 0;
        for (int i = 0; i < len; i++) {
            if (points[i][1] > points[maxY][1]) {
                maxY = i;
            }
            if (points[i][1] < points[minY][1]) {
                minY = i;
            }
        }
        if (points[maxY][1] == points[minY][1]) {
            return res;
        }

        double max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int maxX = 0, minX = 0;
        for (int i = 0; i < len; i++) {
            double distance = pointOnLine(points[i], points[maxY], points[minY]);
            if (max < distance) {
                max = distance;
                maxX = i;
            }
            if (min > distance) {
                min = distance;
                minX = i;
            }
        }

        Stack<int[]> triStack = new Stack<>();
        if (max == 0 && min == 0) {
            return res;
        }
        if (max > 0) {
            triStack.push(new int[]{maxY, minY, maxX});
        }
        else {
            for (int i = 0; i < len; i++) {
                if (!res.contains(i) && pointOnLine(points[i], points[maxY], points[minY]) == 0) {
                    res.add(i);
                }
            }
        }
        if (min < 0) {
            triStack.push(new int[]{maxY, minY, minX});
        }
        else {
            for (int i = 0; i < len; i++) {
                if (!res.contains(i) && pointOnLine(points[i], points[maxY], points[minY]) == 0) {
                    res.add(i);
                }
            }
        }

        while (!triStack.isEmpty()) {
            int[] triangle = triStack.pop();
            double maxDis0 = 0, maxDis1 = 0;
            int maxPoint0 = 0, maxPoint1 = 0;
            for (int i = 0; i < len; i++) {
                if (i != triangle[0] && i != triangle[1] && i != triangle[2]) {
                    if (diffSide(points[triangle[0]], points[i], points[triangle[1]], points[triangle[2]])) {
                        double curDis = Math.abs(pointOnLine(points[i], points[triangle[1]], points[triangle[2]]));
                        if (curDis > maxDis0) {
                            maxDis0 = curDis;
                            maxPoint0 = i;
                        }
                    }
                    if (diffSide(points[triangle[1]], points[i], points[triangle[0]], points[triangle[2]])) {
                        double curDis = Math.abs(pointOnLine(points[i], points[triangle[0]], points[triangle[2]]));
                        if (curDis > maxDis1) {
                            maxDis1 = curDis;
                            maxPoint1 = i;
                        }
                    }
                }
            }
            if (maxDis0 > 0) {
                triStack.push(new int[]{triangle[1], triangle[2], maxPoint0});
            }
            else {
                for (int i = 0; i < len; i++) {
                    if (!res.contains(i) && pointOnLine(points[i], points[triangle[1]], points[triangle[2]]) == 0) {
                        res.add(i);
                    }
                }
            }
            if (maxDis1 > 0) {
                triStack.push(new int[]{triangle[0], triangle[2], maxPoint1});
            }
            else {
                for (int i = 0; i < len; i++) {
                    if (!res.contains(i) && pointOnLine(points[i], points[triangle[0]], points[triangle[2]]) == 0) {
                        res.add(i);
                    }
                }
            }
        }

        return res;
    }

    private boolean diffSide(int[] p1, int[] p2, int[] l1, int[] l2) {
        if (l1[0] == l2[0]) {
            return (p1[0] < l1[0] && p2[0] > l1[0]) || (p1[0] > l1[0] && p2[0] < l1[0]);
        }
        double[] line = getLine(l1, l2);
        double k = line[0];
        double b = line[1];

        double n1 = pointOnLine(p1, k, b);
        double n2 = pointOnLine(p2, k, b);

        if (n1 == 0 || n2 == 0) {
            return false;
        }
        else if ((n1 > 0 && n2 > 0) || (n1 < 0 && n2 < 0)) {
            return false;
        }
        else {
            return true;
        }
    }

    private double pointOnLine(int[] p, double k, double b) {
        return p[1] - k * p[0] - b;
    }
    private double pointOnLine(int[] p, int[] l1, int[] l2) {
        if (l1[0] == l2[0]) {
            return p[0] - l1[0];
        }
        else {
            double[] line = getLine(l1, l2);
            return pointOnLine(p, line[0], line[1]);
        }
    }
    private double[] getLine(int[] p1, int[] p2) {
        double[] res = new double[2];
        res[0] = ((double) p1[1] - p2[1]) / (p1[0] - p2[0]);
        res[1] = p1[1] - res[0] * p1[0];

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int[][] points = new int[N][2];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 2; j++) {
                    points[i][j] = scanner.nextInt();
                }
            }

            Main problem = new Main();
            HashSet<Integer> res = problem.findConvex(points);
            if (res.size() < 3) {
                System.out.println(-1);
            }
            else {
                PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[0] != o2[0]) {
                            return o1[0] - o2[0];
                        }
                        else {
                            return o1[1] - o2[1];
                        }
                    }
                });
                for (Integer point: res) {
                    queue.offer(points[point]);
                }

                int[] point = queue.poll();
                System.out.print(point[0] + " " + point[1]);
                while (!queue.isEmpty()) {
                    point = queue.poll();
                    System.out.print(", " + point[0] + " " + point[1]);
                }
                System.out.println("");
            }
        }
    }

}

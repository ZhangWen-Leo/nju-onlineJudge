package com.wen.contest2.problem1;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private boolean[][] matrix;
    private int[] numOfIn;
    private int res;
    private boolean[] nullArr;

    public int numOfSort(boolean[][] matrix) {
        int len = matrix.length;
        this.matrix = matrix;
        numOfIn = new int[len];
        nullArr = new boolean[len];
        res = 0;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                numOfIn[i] += matrix[j][i] ? 1 : 0;
            }
        }

        flashBack(1);

        return res;
    }
    private void flashBack(int depth) {
        int len = numOfIn.length;
        for (int i = 0; i < len; i++) {
            if (numOfIn[i] == 0) {
                boolean[] edges = matrix[i];
                for (int j = 0; j < len; j++) {
                    numOfIn[j] -= edges[j] ? 1 : 0;
                }
                matrix[i] = nullArr;
                numOfIn[i] = -1;

                if (depth == len) {
                    for (int j = 0; j < len; j++) {
                        if (numOfIn[i] != -1) {
                            return;
                        }
                    }
                    res++;
                }
                else {
                    flashBack(depth + 1);
                }

                numOfIn[i] = 0;
                matrix[i] = edges;
                for (int j = 0; j < len; j++) {
                    numOfIn[j] += edges[j] ? 1 : 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] edgesStr = scanner.nextLine().split(",");
            int edgeLen = edgesStr.length;
            String[][] edgesMatrixStr = new String[edgeLen][];
            HashMap<String, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < edgeLen; i++) {
                String[] edgeStr = edgesStr[i].split(" ");
                if (edgeStr.length < 2) {
                    System.out.println(0);
                    return;
                }
                for (int j = 0; j < 2; j++) {
                    if (!map.containsKey(edgeStr[j])) {
                        map.put(edgeStr[j], count++);
                    }
                }
                edgesMatrixStr[i] = edgeStr;
            }
            int pointLen = map.size();
            String[] points = new String[pointLen];
            for (String point: map.keySet()) {
                points[map.get(point)] = point;
            }
            boolean[][] matrix = new boolean[pointLen][pointLen];
            for (int i = 0; i < edgeLen; i++) {
                int row = map.get(edgesMatrixStr[i][0]);
                int col = map.get(edgesMatrixStr[i][1]);
                matrix[row][col] = true;
            }

            Main problem = new Main();
            System.out.println(problem.numOfSort(matrix));
        }
    }
}

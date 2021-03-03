package com.wen.contest2.problem3;

import java.util.*;

public class Main {

    private HashSet<Integer> hashSet;
    private Stack<Integer> stack;
    private boolean[][] matrix;
    private int depth;
    private int maxDepth;

    public int depthFirstSearch(boolean[][] matrix, int start) {
        int len = matrix.length;
        this.matrix = matrix;
        hashSet = new HashSet<>(len);
        stack = new Stack<>();
        hashSet.add(start);
        stack.push(start);
        depth = 0;
        maxDepth = 0;

        flashBack();

        return maxDepth;
    }
    private void flashBack() {
        depth++;
        maxDepth = Math.max(maxDepth, depth);
        int node = stack.peek();
        int len = matrix.length;

        for (int i = 0; i < len; i++) {
            if (!hashSet.contains(i) && matrix[i][node]) {
                hashSet.add(i);
                stack.push(i);
                flashBack();
            }
        }

        depth--;
        stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] first = scanner.nextLine().split(" ");
            int N = Integer.parseInt(first[0]);
            String[] nodes = scanner.nextLine().split(" ");
            int start = -1;
            for (int i = 0; i < N; i++) {
                if (nodes[i].equals(first[1])) {
                    start = i;
                    break;
                }
            }
            boolean[][] matrix = new boolean[N][N];
            for (int i = 0; i < N; i++) {
                String[] row = scanner.nextLine().split(" ");
                for (int j = 0; j < N; j++) {
                    matrix[i][j] = Integer.parseInt(row[j+1]) == 1;
                }
            }

            Main problem = new Main();
            System.out.println(problem.depthFirstSearch(matrix, start));
        }
    }
}

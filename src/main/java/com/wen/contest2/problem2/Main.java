package com.wen.contest2.problem2;

import java.util.*;

public class Main {

    public List<Integer> breadthFirstSearch(boolean[][] matrix, int start) {
        int len = matrix.length;
        List<Integer> res = new ArrayList<>(len);
        HashSet<Integer> hashSet = new HashSet<>(len);
        Queue<Integer> queue = new LinkedList<>();
        res.add(start);
        hashSet.add(start);
        queue.offer(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int i = 0; i < len; i++) {
                if (!hashSet.contains(i) && matrix[node][i]) {
                    res.add(i);
                    hashSet.add(i);
                    queue.offer(i);
                }
            }
        }

        return res;
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
            List<Integer> res = problem.breadthFirstSearch(matrix, start);

            if (res.size() > 0) {
                System.out.print(nodes[res.get(0)]);
                for (int i = 1; i < N; i++) {
                    System.out.print(" " + nodes[res.get(i)]);
                }
            }
            System.out.println("");
        }
    }
}

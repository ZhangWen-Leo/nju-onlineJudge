package com.wen.contest1.problem10;

import java.util.Scanner;

public class Main {
    private int[][] allocateBooksDp;
    private int[] books;
    private int[] sumFromEndDp;
    public int allocateBooks(int[] books, int m) {
        int length = books.length;
        if (length < m) {
            return -1;
        }

        allocateBooksDp = new int[length][m];
        this.books = books;
        sumFromEndDp = new int[length];

        return getAllocateBooks(0, m-1);
    }
    private int getAllocateBooks(int start, int m) {
        if (allocateBooksDp[start][m] > 0) {
            return allocateBooksDp[start][m];
        }
        if (m == 0) {
            allocateBooksDp[start][m] = getSumFromEnd(start);
            return allocateBooksDp[start][m];
        }

        allocateBooksDp[start][m] = Integer.MAX_VALUE;
        for (int i = start; i < books.length - m; i++) {
            allocateBooksDp[start][m] = Math.min(
                    allocateBooksDp[start][m],
                    Math.max(getSumFromEnd(start) - getSumFromEnd(i+1), getAllocateBooks(i+1, m-1))
            );
        }

        return allocateBooksDp[start][m];
    }
    private int getSumFromEnd(int index) {
        if (index >= books.length) {
            return 0;
        }
        if (sumFromEndDp[index] == 0) {
            sumFromEndDp[index] = books[index] + getSumFromEnd(index+1);
        }

        return sumFromEndDp[index];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] result = new int[T];
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[] books = new int[n];
            for (int j = 0; j < n; j++) {
                books[j] = sc.nextInt();
            }
            int m = sc.nextInt();

            Main problem = new Main();

            result[i] = problem.allocateBooks(books, m);
        }
        for (int i = 0; i < T; i++) {
            System.out.println(result[i]);
        }
    }
}

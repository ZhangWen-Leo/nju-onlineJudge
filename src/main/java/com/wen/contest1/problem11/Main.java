package com.wen.contest1.problem11;

import java.util.Scanner;

public class Main {
    public void sortMarks(int[][] marks) {
        sortMarks(marks, 0, marks.length);
    }
    private void sortMarks(int[][] marks, int start, int end) {
        if (start >= end) {
            return;
        }

        int index = start, i = end - 1;
        while (true) {
            while (index < i && compareMarks(marks[index], marks[i]) < 0) {
                i--;
            }
            if (index >= i) {
                break;
            }

            swapMarks(marks, index, i);
            index = index + i;
            i = index - i;
            index = index - i;

            while (index > i && compareMarks(marks[i], marks[index]) < 0) {
                i++;
            }
            if (index <= i) {
                break;
            }

            swapMarks(marks, index, i);
            index = index + i;
            i = index - i;
            index = index - i;
        }

        sortMarks(marks, start, index);
        sortMarks(marks, index+1, end);
    }
    private int compareMarks(int[] mark1, int[] mark2) {
        if (mark1[0] == mark2[0]) {
            if (mark1[1] == mark2[1]) {
                return mark1[2] - mark2[2];
            }
            else {
                return mark1[1] - mark2[1];
            }
        }
        else {
            return mark1[0] - mark2[0];
        }
    }
    private void swapMarks(int[][] marks, int i, int j) {
        int[] temp = new int[3];

        temp[0] = marks[i][0];
        temp[1] = marks[i][1];
        temp[2] = marks[i][2];

        marks[i][0] = marks[j][0];
        marks[i][1] = marks[j][1];
        marks[i][2] = marks[j][2];

        marks[j][0] = temp[0];
        marks[j][1] = temp[1];
        marks[j][2] = temp[2];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            int[][] marks = new int[n][3];
            for (int j = 0; j < n; j++) {
                marks[j][0] = sc.nextInt();
                marks[j][1] = sc.nextInt();
                marks[j][2] = sc.nextInt();
            }
            Main problem = new Main();
            problem.sortMarks(marks);
            for (int j = 0; j < n; j++) {
                System.out.println(marks[j][0] + " " + marks[j][1] + " " + marks[j][2]);
            }
        }
    }
}

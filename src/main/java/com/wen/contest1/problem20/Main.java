package com.wen.contest1.problem20;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public void mergeSort(int[] arr) {
        int len = arr.length;

        if (len <= 1) {
            return;
        }
        else if (len == 2) {
            if (arr[0] > arr[1]) {
                int temp = arr[0];
                arr[0] = arr[1];
                arr[1] = temp;
            }
            return;
        }

        int middle = len / 2;
        int[] left = new int[middle];
        int[] right = new int[len - middle];
        left = Arrays.copyOfRange(arr, 0, middle);
        right = Arrays.copyOfRange(arr, middle, len);

        mergeSort(left);
        mergeSort(right);

        for (int i = 0, j = 0, k = 0; k < len;) {
            if (i < middle && j < len - middle) {
                if (left[i] < right[j]) {
                    arr[k++] = left[i++];
                }
                else {
                    arr[k++] = right[j++];
                }
            }
            else if (i < middle) {
                System.arraycopy(left, i, arr, k, middle - i);
                break;
            }
            else {
                System.arraycopy(right, j, arr, k, len - middle - j);
                break;
            }
        }

        return;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String[] nums = scanner.nextLine().split(" ");
            int N = Integer.parseInt(nums[0]);
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(nums[i+1]);
            }

            Main problem = new Main();
            problem.mergeSort(arr);
            if (arr.length > 0) {
                System.out.print(arr[0]);
                for (int i = 1; i < arr.length; i++) {
                    System.out.print(" " + arr[i]);
                }
            }
            System.out.println("");
        }
    }
}

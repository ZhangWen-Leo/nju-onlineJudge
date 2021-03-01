package com.wen.contest1.problem19;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    public int[] quickSortWithoutRecursion(int[] arr) {
        int len = arr.length;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[]{0, len});

        while (!stack.isEmpty()) {
            int[] section = stack.pop();
            if (section[0] + 1 >= section[1]) {
                continue;
            }

            int left = section[0], right = section[1] - 1;
            while (left < right) {
                while (left < right && arr[left] <= arr[right]) {
                    right--;
                }
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
                while (left < right && arr[left] <= arr[right]) {
                    left++;
                }
                if (left < right) {
                    int temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                }
            }

            stack.push(new int[]{section[0], left});
            stack.push(new int[]{left+1, section[1]});
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        int T = Integer.parseInt(scanner.nextLine());
//        for (int i = 0; i < T; i++) {
        while (scanner.hasNextLine()) {
            String[] nums = scanner.nextLine().split(" ");
            int N = nums.length;
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(nums[j]);
            }

            Main problem = new Main();
            arr = problem.quickSortWithoutRecursion(arr);
            if (arr.length > 0) {
                System.out.print(arr[0]);
                for (int j = 1; j < arr.length; j++) {
                    System.out.print(" " + arr[j]);
                }
            }
            System.out.println("");
        }
    }

}

package com.wen.contest1.problem13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public List<int[]> sumOfFour(int[] nums, int target) {
        List<int[]> res = new ArrayList<>();

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len-3; i++) {
            if (nums[i] + nums[i+1] + nums[i+2] + nums[i+3] > target) {
                break;
            }
            if (nums[i] + nums[len-3] + nums[len-2] + nums[len-1] < target) {
                while (i < len-3 && nums[i] == nums[i+1]) {
                    i++;
                }
                continue;
            }
            for (int j = i+1; j < len-2; j++) {
                if (nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len-2] + nums[len-1] < target) {
                    while (j < len-2 && nums[j] == nums[j+1]) {
                        j++;
                    }
                    continue;
                }
                int subSum = nums[i] + nums[j];
                int left = j+1, right = len-1;
                while (left < right) {
                    int sum = subSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(new int[]{nums[i], nums[j], nums[left], nums[right]});
                        while (left < right && nums[left] == nums[left+1]) {
                            left++;
                        }
                        left++;
                        while (left < right && nums[right] == nums[right-1]) {
                            right--;
                        }
                        right--;
                    }
                    else if (sum > target) {
                        right--;
                    }
                    else {
                        left++;
                    }
                }
                while (j < len - 2 && nums[j] == nums[j+1]) {
                    j++;
                }
            }
            while (i < len - 1 && nums[i] == nums[i+1]) {
                i++;
            }
        }

        return res;
    }

    public static String listToString(List<int[]> list) {
        StringBuilder res = new StringBuilder();
        for (int[] arr: list) {
            for (int i = 0; i < arr.length; i++) {
                res.append(arr[i] + " ");
            }
            res.append('$');
        }

        return res.toString();
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            int target = scanner.nextInt();
            int[] nums = new int[n];
            for (int j = 0; j < n; j++) {
                nums[j] = scanner.nextInt();
            }

            Main problem = new Main();

            List<int[]> res = problem.sumOfFour(nums, target);
            System.out.println(listToString(res));
        }
    }
}

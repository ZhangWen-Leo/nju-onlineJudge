package com.wen.contest1.problem21;

import java.util.Scanner;

public class Main {
    class SegTree {
        class TreeNode{
            int val;
            int count;
            int leftTotal;
            int rightTotal;
            TreeNode left;
            TreeNode right;

            TreeNode(){
                this(0);
            }
            TreeNode(int val) {
                this.val = val;
                count = 1;
                leftTotal = 0;
                rightTotal = 0;
            }
        }

        TreeNode root;

        SegTree() {
            root = null;
        }

        int offer(int val) {
            if (root == null) {
                root = new TreeNode(val);
                return 0;
            }

            TreeNode cur = root;
            int count = 0;
            while (cur.val != val) {
                if (cur.val < val) {
                    count += cur.leftTotal + cur.count;
                    cur.rightTotal++;
                    if (cur.right != null) {
                        cur = cur.right;
                    }
                    else {
                        cur.right = new TreeNode(val);
                        return count;
                    }
                }
                else {
                    cur.leftTotal++;
                    if (cur.left != null) {
                        cur = cur.left;
                    }
                    else {
                        cur.left = new TreeNode(val);
                        return count;
                    }
                }
            }

            cur.count++;
            count += cur.leftTotal;
            return count;
        }
    }

    public int numOfSwaps(int[] arr) {
        int len = arr.length;
        int res = 0;
        SegTree segTree = new SegTree();

        for (int i = len - 1; i >= 0; i--) {
            res += segTree.offer(arr[i]);
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scanner.nextInt();
            int[] arr = new int[N];
            for (int j = 0; j < N; j++) {
                arr[j] = scanner.nextInt();
            }

            Main problem = new Main();
            System.out.println(problem.numOfSwaps(arr));
        }
    }
}

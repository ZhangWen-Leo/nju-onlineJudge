package com.wen.contest3.problem4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            String[] arr = scanner.nextLine().split(" ");

            Main solution = new Main();
            System.out.println(solution.canFormACircle(arr) ? 1 : 0);
        }
    }

    private boolean canFormACircle(String[] arr) {
        HashMap<Character, LinkedList<String>> map = new HashMap<>();
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            if (map.containsKey(arr[i].charAt(0))) {
                map.get(arr[i].charAt(0)).offer(arr[i]);
            }
            else {
                LinkedList<String> list = new LinkedList<>();
                list.offer(arr[i]);
                map.put(arr[i].charAt(0), list);
            }
        }

        char head = arr[0].charAt(0);
        char cur = arr[0].charAt(arr[0].length() - 1);

        for (int i = 1; i < len; i++) {
            if (!map.containsKey(cur) || map.get(cur).isEmpty()) {
                return false;
            }
            else {
                String curS = map.get(cur).poll();
                cur = curS.charAt(curS.length() - 1);
            }
        }

        if (cur == head) {
            return true;
        }
        else {
            return false;
        }
    }
}

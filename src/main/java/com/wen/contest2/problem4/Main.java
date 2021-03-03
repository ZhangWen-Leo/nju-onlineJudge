package com.wen.contest2.problem4;

import java.util.*;

public class Main {

    private int[][] cost;
    boolean[] assigned;
    private int len;
    private int minCost;
    private int curCost;
    private int[] assign;
    private List<int[]> bestAssign;

    public List<int[]> distribute(int[][] cost) {
        this.cost = cost;
        len = cost.length;
        assign = new int[len];
        bestAssign = new ArrayList<>();
        if (len == 0) {
            return bestAssign;
        }
        assigned = new boolean[len];
        minCost = Integer.MAX_VALUE;
        curCost = 0;

        distributeFor(0);

        return bestAssign;
    }
    private void distributeFor(int person) {
        for (int i = 0; i < len; i++) {
            if (!assigned[i]) {
                curCost += cost[person][i];
                assigned[i] = true;
                assign[person] = i;
                if (person == len - 1) {
                    if (curCost < minCost) {
                        minCost = curCost;
                        bestAssign.clear();
                        bestAssign.add(Arrays.copyOf(assign, len));
                    }
                    else if (curCost == minCost) {
                        bestAssign.add(Arrays.copyOf(assign, len));
                    }
                }
                else {
                    distributeFor(person + 1);
                }
                assigned[i] = false;
                curCost -= cost[person][i];
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(scanner.nextLine());
            int[][] cost = new int[N][N];
            String[] costStrings = scanner.nextLine().split(",");
            for (String costStr: costStrings) {
                String[] singleCostStr = costStr.split(" ");
                int[] singleCost = new int[3];
                for (int i = 0; i < 3; i++) {
                    singleCost[i] = Integer.parseInt(singleCostStr[i]);
                }
                cost[singleCost[0]-1][singleCost[1]-1] = singleCost[2];
            }

            Main problem = new Main();
            List<int[]> res = problem.distribute(cost);
            res.sort(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    int end = o1.length - 1;
                    for (int i = 0; i < end; i++) {
                        if (o1[i] != o2[i]) {
                            return o2[i] - o1[i];
                        }
                    }
                    return o2[end] - o1[end];
                }
            });
            int[] assign = res.get(0);
            System.out.print(assignToString(assign));
            for (int i = 1; i < res.size(); i++) {
                assign = res.get(i);
                System.out.print("," + assignToString(assign));
            }
            System.out.println("");
        }
    }
    private static String assignToString(int[] assign) {
        StringBuilder stringBuilder = new StringBuilder();
        if (assign.length > 0) {
            stringBuilder.append(assign[0] + 1);
            for (int i = 1; i < assign.length; i++) {
                stringBuilder.append(" " + (assign[i] + 1));
            }
        }

        return stringBuilder.toString();
    }
}

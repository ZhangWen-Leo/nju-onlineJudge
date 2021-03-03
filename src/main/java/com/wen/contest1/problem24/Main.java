package com.wen.contest1.problem24;

import java.util.*;

public class Main {

    public List<double[][]> nearestPoint(double[][] points) {
        Arrays.sort(points, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                int first = doubleComp(o1[0], o2[0]);
                if (first == 0) {
                    return doubleComp(o1[1], o2[1]);
                }
                else {
                    return first;
                }
            }
        });
        return nearestPoint(points, 0, points.length);
    }
    private List<double[][]> nearestPoint(double[][] points, int start, int end) {
        List<double[][]> res = new ArrayList<>();
        if (end - start <= 1) {
            return res;
        }

        int middle = (start + end) / 2;

        List<double[][]> leftRes = nearestPoint(points, start, middle),
                rightRes = nearestPoint(points, middle, end);
        double minDis = Integer.MAX_VALUE;
        double leftDis = leftRes.size() > 0 ? calcDis(leftRes.get(0)[0], leftRes.get(0)[1]): Integer.MAX_VALUE;
        double rightDis = rightRes.size() > 0 ? calcDis(rightRes.get(0)[0], rightRes.get(0)[1]): Integer.MAX_VALUE;
        if (leftDis == rightDis) {
            if (leftDis != Integer.MAX_VALUE) {
                res.addAll(leftRes);
                res.addAll(rightRes);
            }
        }
        else if (leftDis < rightDis) {
            minDis = leftDis;
            res.addAll(leftRes);
        }
        else {
            minDis = rightDis;
            res.addAll(rightRes);
        }

        int left = middle, right = middle;
        while (left > start && points[middle][0] - points[left-1][0] <= minDis) {
            left--;
        }
        while (right < end -1 && points[right+1][0] - points[middle][0] <= minDis) {
            right++;
        }

        int subLen = right - middle + 1;
        double[][] rightPoints = new double[subLen][2];
        for (int i = 0; i < subLen; i++) {
            rightPoints[i][0] = points[middle+i][0];
            rightPoints[i][1] = points[middle+i][1];
        }
        Arrays.sort(rightPoints, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                return doubleComp(o1[1], o2[1]);
            }
        });

        Comparator<double[]> comparator = new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if (o1[0] != o2[0]) {
                    return doubleComp(o1[0], o2[0]);
                }
                else {
                    return doubleComp(o1[1], o2[1]);
                }
            }
        };
        for (int i = left; i < middle; i++) {
            for (int j = 0; j < subLen; j++) {
                if (points[i][1] - rightPoints[j][1] > minDis) {
                    continue;
                }
                else if (points[i][1] - rightPoints[j][1] < -minDis) {
                    break;
                }
                else {
                    double dis = calcDis(points[i], rightPoints[j]);
                    if (dis < minDis) {
                        minDis = dis;
                        res.clear();
                        res.add(new double[][]{points[i], rightPoints[j]});
                    }
                    else if (dis == minDis) {
                        res.add(new double[][]{points[i], rightPoints[j]});
                    }
                }
            }
        }

        res.sort(new Comparator<double[][]>() {
            @Override
            public int compare(double[][] o1, double[][] o2) {
                int first = comparator.compare(o1[0], o2[0]);
                if (first == 0) {
                    return comparator.compare(o1[1], o2[1]);
                }
                else {
                    return first;
                }
            }
        });

        return res;
    }

    private double calcDis(double[] p1, double[] p2) {
        return Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2);
    }
    private int doubleComp(double d1, double d2) {
        if (d1 < d2) {
            return -1;
        }
        else if (d1 == d2) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String[] pointsS = scanner.nextLine().split(",");
            int len = pointsS.length;
            if (len <= 1) {
                System.out.println("");
                continue;
            }
            double[][] points = new double[len][2];
            for (int i = 0; i < len; i++) {
                String[] pointS = pointsS[i].split(" ");
                points[i][0] = Double.parseDouble(pointS[0]);
                points[i][1] = Double.parseDouble(pointS[1]);
            }

            Main problem = new Main();
            List<double[][]> res = problem.nearestPoint(points);
            if (res.size() > 0) {
                double[][] pointPair = res.get(0);
                System.out.print(doubleToString(pointPair[0][0])+" "+doubleToString(pointPair[0][1])+","+
                        doubleToString(pointPair[1][0])+" "+doubleToString(pointPair[1][1]));

                for (int i = 1; i < res.size(); i++) {
                    pointPair = res.get(i);
                    System.out.print(","+doubleToString(pointPair[0][0])+" "+doubleToString(pointPair[0][1])+","+
                            doubleToString(pointPair[1][0])+" "+doubleToString(pointPair[1][1]));
                }
            }
            System.out.println("");
        }
    }

    private static String doubleToString(double a) {
        if (a % 1 == 0) {
            return String.valueOf((int) a);
        }
        else {
            return String.valueOf(a);
        }
    }

}

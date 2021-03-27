package com.wen.contest3.problem1;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = Integer.parseInt(scanner.nextLine());
        for (int t = 0; t < T; t++) {
            String s1 = scanner.nextLine();
            String s2 = scanner.nextLine();

            Main solution = new Main();
            List<String> res = solution.getCommonSubsequence(s1, s2);
            res.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    for (int i = 0; i < o1.length(); i++) {
                        if (o1.charAt(i) != o2.charAt(i)) {
                            return o1.charAt(i) - o2.charAt(i);
                        }
                    }
                    return 0;
                }
            });
            for (String re : res) {
                System.out.println(re);
            }
        }
    }

    private List<String>[][] resultDp;
    private List<String> getCommonSubsequence(String s1, String s2) {
        resultDp = new List[s1.length() + 1][s2.length() + 1];
        return getCommonSubsequence(s1, 0, s2, 0);
    }
    private List<String> getCommonSubsequence(String s1, int start1, String s2, int start2) {
        if (resultDp[start1][start2] != null) {
            return resultDp[start1][start2];
        }
        int len1 = s1.length(), len2 = s2.length();
        if (start1 >= len1 || start2 >= len2) {
            resultDp[start1][start2] = new ArrayList<>();
            return resultDp[start1][start2];
        }

        int match1 = s2.indexOf(s1.charAt(start1), start2);
        int match2 = s1.indexOf(s2.charAt(start2), start1);
        if (match1 < 0) {
            resultDp[start1][start2] = getCommonSubsequence(s1, start1 + 1, s2, start2);
        }
        else if (match2 < 0) {
            resultDp[start1][start2] = getCommonSubsequence(s1, start1, s2, start2 + 1);
        }
        else if (s1.charAt(start1) == s2.charAt(start2)) {
            resultDp[start1][start2] = new ArrayList<>();
            resultDp[start1][start2].addAll(getCommonSubsequence(s1, start1 + 1, s2, start2 + 1));

            if (resultDp[start1][start2].size() == 0) {
                resultDp[start1][start2].add(String.valueOf(s1.charAt(start1)));
            }
            else {
                for (int i = 0; i < resultDp[start1][start2].size(); i++) {
                    resultDp[start1][start2].set(i, s1.charAt(start1) + resultDp[start1][start2].get(i));
                }
            }
        }
        else {
            List<String> leftRes = getCommonSubsequence(s1, start1 + 1, s2, match1 + 1);
            List<String> rightRes = getCommonSubsequence(s1, match2 + 1, s2, start2 + 1);
            resultDp[start1][start2] = new ArrayList<>();
            if (leftRes.size() == 0 && rightRes.size() == 0) {
                resultDp[start1][start2].add(String.valueOf(s1.charAt(start1)));
                resultDp[start1][start2].add(String.valueOf(s2.charAt(start2)));
            }
            else if (leftRes.size() == 0 || rightRes.size() == 0) {
                if (leftRes.size() != 0) {
                    for (String leftRe : leftRes) {
                        resultDp[start1][start2].add(s1.charAt(start1) + leftRe);
                    }
                }
                else {
                    for (String rightRe : rightRes) {
                        resultDp[start1][start2].add(s2.charAt(start2) + rightRe);
                    }
                }
            }
            else {
                if (leftRes.get(0).length() > rightRes.get(0).length()) {
                    for (String leftRe : leftRes) {
                        resultDp[start1][start2].add(s1.charAt(start1) + leftRe);
                    }
                }
                else if (leftRes.get(0).length() < rightRes.get(0).length()) {
                    for (String rightRe : rightRes) {
                        resultDp[start1][start2].add(s2.charAt(start2) + rightRe);
                    }
                }
                else {
                    for (String leftRe : leftRes) {
                        resultDp[start1][start2].add(s1.charAt(start1) + leftRe);
                    }
                    for (String rightRe : rightRes) {
                        resultDp[start1][start2].add(s2.charAt(start2) + rightRe);
                    }
                }
            }
        }
        return resultDp[start1][start2];
    }

}

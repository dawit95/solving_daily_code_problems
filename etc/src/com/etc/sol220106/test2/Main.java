package com.etc.sol220106.test2;

public class Main {
    static int k = 1;
    static int ans = -1;

    public static void main(String[] args) {
        int[] stones = {4, 2, 2, 1, 4};
        int len = stones.length;
        for (int i = len - 1; i > -1; i--) {
            StringBuilder sb = new StringBuilder();
            sb.append(i);
            okPermu(i, len, stones, sb);
            if (ans != -1)
                break;
        }
        System.out.println(ans);
    }

    private static void okPermu(int idx, int len, int[] stones, StringBuilder sb) {
        // 마지막 성공했을때,
        if (ans != -1) return;
        //copy
        int[] copyOfStones = new int[len];
        System.arraycopy(stones, 0, copyOfStones, 0, len);
        //ending
        int target = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            if (i == idx) {
                copyOfStones[i]++;
            } else {
                copyOfStones[i]--;
            }
            sum += copyOfStones[i];
            if (copyOfStones[i] != 0)
                target = i;
            // 하나이상 0보다 작아질때,
            if (copyOfStones[i] < 0)
                return;
        }
        // 하나가 k이고 나머지가 0일때,
        if (copyOfStones[target] == k && sum == k) {
            ans = Integer.parseInt(sb.toString());
            return;
        }

        //idx 정하기
        for (int i = len - 1; i > -1; i--) {
            sb.append(i);
            okPermu(i, len, copyOfStones, sb);
            sb.setLength(sb.length() - 1);
        }
    }
}

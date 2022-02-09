package com.baekjoon.sol1633;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int whiteCnt = 0, blackCnt = 0;
        int[][] arr = new int[1000][2];
        int idx = 0;
        while (sc.hasNextInt()) {
            arr[idx][0] = sc.nextInt();
            arr[idx][1] = sc.nextInt();
            idx++;
        }
        // max sort
        Arrays.sort(arr, (o1, o2) -> {
            int a = Math.max(o1[0], o1[1]);
            int b = Math.max(o2[0], o2[1]);
            return Integer.compare(b, a);
        });

        int ans = 0;
        for (int i = 0; i < 30; i++) {
            if (30 == whiteCnt + blackCnt) break;
            if (arr[i][0] > arr[i][1]) {
                if (whiteCnt == 15) continue;
                whiteCnt++;
                ans += arr[i][0];
            } else {
                if (blackCnt == 15) continue;
                blackCnt++;
                ans += arr[i][1];
            }
            arr[i] = new int[2];
        }

        if (blackCnt != 15) {
            Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[1], o1[1]));
            int idxBlack =0;
            while(blackCnt != 15){
                ans += arr[idxBlack][1];
                idxBlack++;
                blackCnt++;
            }
        }

        if (whiteCnt != 15) {
            Arrays.sort(arr, (o1, o2) -> Integer.compare(o2[0], o1[0]));
            int idxWhite =0;
            while(whiteCnt != 15){
                ans += arr[idxWhite][0];
                idxWhite++;
                whiteCnt++;
            }
        }

        System.out.println(ans);
    }
}

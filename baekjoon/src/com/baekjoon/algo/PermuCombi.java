package com.baekjoon.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * FileName : PermuCombi
 * Author : David
 * Date : 2022-03-23
 * Description :
 */
public class PermuCombi {

    static int n, m;
    static int[] arr,tmp;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[m];
        tmp = new int[n];

        input = br.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            tmp[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(tmp);

        permu(0,0);
        combi(0, 0);
        okPermu(0);
        okCombi(0, 0);
        System.out.println(sb.toString());
    }

    private static void permu(int idx, int flag) {
        if(idx == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append("\n");
            return;
        }


        for (int i = 1; i <= n; i++) {
            if((flag & 1<<i)==0) {
                arr[idx] = i;
                permu(idx+1,flag|1<<i);
            }
        }
    }

    private static void combi(int idx, int start) {
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            arr[idx] = i + 1;
            combi(idx + 1, i + 1);
        }
    }

    private static void okPermu(int idx) {
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            arr[idx] = i;
            okPermu(idx + 1);
        }
    }

    private static void okCombi(int idx, int start) {
        if (idx == m) {
            for (int i : arr) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            arr[idx] = i + 1;
            okCombi(idx + 1, i);
        }
    }

}

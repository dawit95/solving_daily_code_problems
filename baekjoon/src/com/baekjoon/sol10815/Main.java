package com.baekjoon.sol10815;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String[] input = br.readLine().trim().split(" ");
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < n; i++) {
            set.add(input[i]);
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine().trim());
        String[] input2 = br.readLine().trim().split(" ");
        for (int i = 0; i < m; i++) {
            if(set.contains(input2[i])) {
                sb.append("1 ");
            }else {
                sb.append("0 ");
            }
        }
        System.out.println(sb.toString());
    }
}

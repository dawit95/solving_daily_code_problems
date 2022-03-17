package com.baekjoon.sol11047;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-17
 * Description : 11047 problem
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }
        sc.nextLine();
        sc.close();

        Arrays.sort(coin);

        int cnt = 0, idx = n - 1;
        while (k > 0 && idx >= 0) {
            if (k / coin[idx] > 0) {
                cnt += k / coin[idx];
                k %= coin[idx];
            }
            idx--;
        }
        System.out.println(cnt);
    }
}

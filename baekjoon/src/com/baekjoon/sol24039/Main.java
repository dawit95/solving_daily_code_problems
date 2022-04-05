package com.baekjoon.sol24039;

import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-05
 * Description :
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 1000;
        boolean[] prime = new boolean[len];
        prime[0] = prime[1] = true;
        int tmp = 0;

        for (int idx = 2, size = (int) Math.sqrt(n); idx < len; idx++) {
            if (prime[idx]) continue;
            //에라토스테네스의 체
            if (idx <= size)
                for (int i = idx * idx; i < len; i += idx) {
                    prime[i] = true;
                }
            // answer
            if (tmp == 0) {
                tmp = idx;
                continue;
            }
            if (tmp * idx > n) {
                System.out.println(tmp * idx);
                break;
            } else {
                tmp = idx;
            }
        }
    }


}

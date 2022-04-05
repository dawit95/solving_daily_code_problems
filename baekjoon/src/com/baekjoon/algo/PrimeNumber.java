package com.baekjoon.algo;

import java.util.Scanner;

/**
 * FileName : Prime
 * Author : David
 * Date : 2022-04-05
 * Description :
 */
public class PrimeNumber {
    static boolean[] prime;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        make_prime(n);

    }

    private static void make_prime(int n) {
        prime = new boolean[n+1];
        prime[0] = prime[1] = true;

        for (int idx = 2,size = (int)Math.sqrt(n); idx <= size; idx++) {
            if(prime[idx]) continue;
            //에라토스테네스의 체
            for (int i = idx*idx; i < prime.length; i+=idx) {
                prime[i] = true;
            }
        }
    }
}

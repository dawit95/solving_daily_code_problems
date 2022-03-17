package com.baekjoon.sol1789;

import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        sc.close();
        long num =1, sum = 0, cnt = 0;
        while (sum<n){
            sum += num++;
            cnt++;
            if(sum > n){
                cnt--;
            }
        }
        System.out.println(cnt);
    }
}

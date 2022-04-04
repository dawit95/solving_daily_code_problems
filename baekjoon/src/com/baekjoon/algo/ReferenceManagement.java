package com.baekjoon.algo;

/**
 * FileName : ReferenceManagement
 * Author : David
 * Date : 2022-04-04
 * Description :
 */
public class ReferenceManagement {
    public static void main(String[] args) {
        int[][] arr1 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                arr1[i][j] = 5;
            }
        }
        int[] tmp = new int[5];
        for (int i = 0; i < 5; i++) {
            tmp[i] = i;
        }
        arr1[2] = tmp;
        System.out.println(arr1[2][0]);
        tmp[0] = 99;
        System.out.println(arr1[2][0]);
    }
}

package com.baekjoon.sol7795;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < testcase; i++) {
            String[] input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[] arr1 = new int[n];
            int[] arr2 = new int[m];

            input = br.readLine().trim().split(" ");
            for (int j = 0; j < n; j++) {
                arr1[j] = Integer.parseInt(input[j]);
            }
            input = br.readLine().trim().split(" ");
            for (int j = 0; j < m; j++) {
                arr2[j] = Integer.parseInt(input[j]);
            }
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            int ans = 0, idxN=n-1,idxM=m-1;
            while (idxN > -1 && idxM >-1){
                if (arr1[idxN] > arr2[idxM]){
                    ans+= idxM+1;
                    idxN--;
                }else{
                    idxM--;
                }
            }
            System.out.println(ans);
        }

    }
}

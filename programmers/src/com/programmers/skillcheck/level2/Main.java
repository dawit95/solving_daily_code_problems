package com.programmers.skillcheck.level2;

import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-10
 * Description : 스킬체크 레벨 2
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        long n = sc.nextInt();
//        System.out.println(solution_1(n));
//
//        String str = sc.nextLine();
//        System.out.println(solution_2(str));

    }

    public int solution_1(int n) {
        int ans = 0;
        while(n>0){
            if(n%2==0){
                n/=2;
            }else{
                ans+=n%2;
                n-=n%2;
            }
        }
        return ans;
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int r1 = arr1.length, c1 = arr1[0].length, c2 = arr2[0].length;
        int[][] answer = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}

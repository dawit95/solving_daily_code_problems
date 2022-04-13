package com.etc.sol220412.codility4;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-12
 * Description :
 */
public class Main {
    public int[] solution(int N, int[] A){
        int len = A.length;
        int[] ans = new  int[N];
        int max = 0;
        int counter = 0;
        for (int i = 0; i < len; i++) {
            if(A[i]<=N){
                if(ans[A[i]-1]<counter){
                    ans[A[i]-1] = counter+1;
                }else{
                    ans[A[i]-1]++;
                }
                    max = Math.max(max,ans[A[i]-1]);
            }else if(A[i]>N){
                counter = max;
            }
        }
        for (int i = 0; i < N; i++) {
            if(ans[i]<counter){
                ans[i] = counter;
            }
        }
        return ans;
    }
}

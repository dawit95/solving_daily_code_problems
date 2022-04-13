package com.etc.sol220412.codility3;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-12
 * Description :
 */
public class Main {
    public int solution(int[] A){
        if(A.length==0) return -1;
        int ans =Integer.MAX_VALUE;
        int len = A.length-1;
        int total = 0, tmp =0;
        for (int target : A) {
            total += target;
        }
        for (int i = 0; i < len; i++) {
            tmp += A[i];
            ans = Math.min(ans, Math.abs(total-(tmp*2)));
        }
        return ans;
    }
}

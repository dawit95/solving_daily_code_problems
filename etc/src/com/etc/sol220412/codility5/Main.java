package com.etc.sol220412.codility5;

import java.util.Arrays;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-12
 * Description :
 */
public class Main {
    public int solution(int[] A) {
        Arrays.sort(A);
        int value = 1, len = A.length, idx = -1;
        for (int i = 0; i < len; i++) {
            if(A[i]<=0) continue;
            idx = i;
            break;
        }
        if(idx == -1 || A[idx] != 1)
            return 1;
        for (int i = idx; i < len-1; i++) {
            if(A[i] == value && A[i+1] == value+1){
                value++;
            }
        }
        return value+1;
    }
}

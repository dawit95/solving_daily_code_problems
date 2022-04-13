package com.etc.sol220412.codility1;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {
//        System.out.println(15 % 0);
    }

    public int[] solution(int[] A, int K ){
        int len = A.length;
        int[] ans = new int[len];
        int idx = len==0?0:len - (K%len);
        int zeroIdx = 0;

        for (int i = 0; i < len; i++) {
            if(idx<len){
                ans[i] = A[idx];
                idx++;
            }else{
                ans[i] = A[zeroIdx];
                zeroIdx++;
            }
        }

        return ans;
    }
}

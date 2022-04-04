package com.etc.sol220326.test4;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-26
 * Description :
 */
public class Main {
    public static void main(String[] args) {

    }
    public int solution(int[] arr, int[] brr) {
        int answer = 0;
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            if(arr[i] == brr[i]) continue;

            int diff = brr[i]-arr[i];
            arr[i] += diff;
            arr[i+1] -= diff;
            answer++;
        }
        return answer;
    }
}

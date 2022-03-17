package com.programmers.level2;

import java.util.Arrays;

/**
 * FileName : 체육복
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int ans = n;
        int[] student = new int[n];
        for (int i = 0; i < lost.length; i++) {
            student[lost[i]-1]--;
        }
        for (int i = 0; i < reserve.length; i++) {
            student[reserve[i]-1]++;
        }

        for (int i = 0; i < n; i++) {
            if(student[i] == -1){
                if(i-1>=0&& student[i-1] ==1){
                    student[i]++;
                    student[i-1]--;
                }else if(i+1<n && student[i+1] == 1){
                    student[i]++;
                    student[i+1]--;
                }else{
                    ans--;
                }
            }
        }

        return ans;
    }

    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n + 2];
        Arrays.fill(arr, 1);
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i]]++;
        }
        for (int i = 0; i < lost.length; i++) {
            arr[lost[i]]--;
        }
        for (int i = 0; i < arr.length; i++) {
            answer += arr[i] > 0 ? 1 : 0;
        }
        Arrays.sort(reserve);
        // 채우기
        for (int i = 0; i < reserve.length / 2 + 1; i++) {
            int front = reserve[i];
            int end = reserve[reserve.length - 1 - i];

            if (arr[front] == 2 && arr[front - 1] == 0) {
                arr[front - 1]++;
                arr[front]--;
                answer++;
            } else if (arr[front] == 2 && arr[front + 1] == 0) {
                arr[front + 1]++;
                arr[front]--;
                answer++;
            }
            if (arr[end] == 2 && arr[end + 1] == 0) {
                arr[end + 1]++;
                arr[end]--;
                answer++;
            } else if (arr[end] == 2 && arr[end - 1] == 0) {
                arr[end - 1]++;
                arr[end]--;
                answer++;
            }
        }
        return answer - 2;
    }
}

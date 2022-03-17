package com.programmers.level2;

import java.util.Arrays;

/**
 * FileName : 조이스틱
 * Author : David
 * Date : 2022-03-17
 * Description : 조이스틱 problem
 */
public class 조이스틱 {
    public int solution(String name) {
        int len = name.length();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
        }
        int answer = Arrays.stream(arr).sum();

        int min  = len-1;
        for (int i = 0; i < len; i++) {
            int next = i+1;
            while (next<len && arr[next] == 0)
                next++;
            min = Math.min(Math.min(min, (len - next) * 2 + i), i+i+(len-next));
        }
        return answer+min;
    }
}

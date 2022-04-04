package com.etc.sol220326.test5;

import java.util.Arrays;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-26
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        int[] a = {7, 6, 8, 9, 10};
        System.out.println(solution(a, 1));
    }

    public static long solution(int[] abilities, int k) {
        long answer = 0;
        Arrays.sort(abilities);
        int len = abilities.length;
        int diff = -1;
        for (int i = len - 1; i > 0; i -= 2) {
            if (abilities[i] != abilities[i - 1] && k > 0) {
                k--;
                answer += abilities[i];
                diff = abilities[i] - abilities[i - 1];
            } else {
                answer += abilities[i - 1];
            }
        }
        if (len % 2 == 1) {
            if (k > 0)
                answer += abilities[0];
            else if (diff < abilities[0]) {
                answer += abilities[0] - diff;
            }
        }
        return answer;
    }
}

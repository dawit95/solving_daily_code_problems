package com.etc.sol220215.test2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


    }

    public int solution(int[] s) {
        int answer = 0;
        int tog = 1;
        for (int i = 0; i < s.length - 1; i++) {
            if (tog == 1) {
                if (s[i] >= s[i + 1]) {
                    answer += 1;
                    tog*=-1;
                }
            } else {
                if (s[i] <= s[i + 1]) {
                    answer += 1;
                    tog*=-1;
                }
            }
            tog*=-1;
        }
        return answer;
    }
}

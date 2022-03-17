package com.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * FileName : 단속카메라
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class 단속카메라 {
    public int solution(int[][] routes) {
        int answer = 1;
        Arrays.sort(routes, (o1, o2) -> o1[0] - o2[0] != 0 ? o1[0] - o2[0] : o1[1] - o2[1]);
        int min = routes[routes.length - 1][0];
        for (int i = routes.length - 1; i >= 0; i--) {
            if (routes[i][0] > min || routes[i][1] < min) {
                min = routes[i][0];
                answer++;
            }
        }
        return answer;
    }
}

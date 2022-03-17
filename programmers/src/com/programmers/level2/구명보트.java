package com.programmers.level2;

import java.util.*;

/**
 * FileName : 구명보트
 * Author : David
 * Date : 2022-03-17
 * Description : 구명보트 problem
 */
public class 구명보트 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int min = 0;
        int max = people.length - 1;
        while (min<=max) {
            if (people[min] + people[max] <= limit) {
                min++;
            }
            max--;
            answer++;
        }
        return answer;
    }
}

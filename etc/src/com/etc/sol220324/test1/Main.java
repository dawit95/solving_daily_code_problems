package com.etc.sol220324.test1;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-24
 * Description :
 */
public class Main {
    public static void main(String[] args) {

    }

    public int solution(int k, int m, String[] names, int[] amounts) {
        int answer = 0;
        List<String> arr = Arrays.stream(names).map(String::toLowerCase).collect(Collectors.toList());
        String past = names[0];
        int cnt = 0;
        for (int i = 0,len=names.length; i < len; i++) {
            if(past.equals(arr.get(i))){
                cnt++;
            }else{
                past = arr.get(i);
                cnt = 1;
            }

            if(cnt>=k){
                answer++;
                continue;
            }

            if(amounts[i] >= m){
                answer++;
            }
        }
        return answer;
    }
}

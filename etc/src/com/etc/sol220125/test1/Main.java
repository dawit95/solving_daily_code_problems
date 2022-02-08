package com.etc.sol220125.test1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] a = {2, 3, 1, 4};
        System.out.println(solution(a,3));
    }
    public static int solution(int[] play_list, int listen_time) {
        int answer = 0;
        int len = play_list.length;
        for (int j = 0; j < len; j++) {

            int tmpTime = listen_time;

            //갯수 만들기
            int cnt =0;
            for (int i = 0; i < len; i++) {
                if (tmpTime > 0) {
                    tmpTime -= play_list[i];
                    cnt++;
                    if(i==0){
                        tmpTime+=play_list[0]-1;
                    }
                } else {
                    break;
                }
            }

            //비교
            answer = Math.max(answer,cnt);

            //다음 배열
            int tmp = play_list[0];
            for (int i = 0; i < len-1; i++) {
                play_list[i] = play_list[i+1];
            }
            play_list[len-1] = tmp;
        }
        return answer;
    }
}

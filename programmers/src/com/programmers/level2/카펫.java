package com.programmers.level2;

public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        for (int i = 1; i <= yellow/2+1; i++) {
            if(yellow%i==0){
                int mok = yellow/i;
                if((mok+i)*2+4==brown){
                    answer[0] = mok+2;
                    answer[1] = i+2;
                    break;
                }
            }
        }
        return answer;
    }
}

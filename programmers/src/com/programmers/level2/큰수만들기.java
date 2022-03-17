package com.programmers.level2;

import java.util.Stack;

/**
 * FileName : 큰수만들기
 * Author : David
 * Date : 2022-03-17
 * Description : 큰 수 만들기 problem
 */
public class 큰수만들기 {
    public String solution1(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int len = number.length();
        for (int i = 0; i < len; i++) {
            int max = -1;
            int idx = 0;
            for (int j = i; j < i+k+1 && j < len; j++) {
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    idx = j;
                }
                if(max == '9')
                    break;
            }
            k -= idx-i;
            answer.append(number.charAt(idx));
            i = idx;
        }
        //예외
        if(k==1){
            answer.setLength(answer.length()-1);
        }
        return answer.toString();
    }

    public String solution2(String number, int k) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int len = number.length();
        for (int i=0; i<len; i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }

        int size = stack.size()-Math.max(k, 0);
        for (int i=0; i<size; i++) {
            ans.append(stack.get(i));
        }
        return ans.toString();
    }
}

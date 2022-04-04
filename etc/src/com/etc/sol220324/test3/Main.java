package com.etc.sol220324.test3;

import java.util.Stack;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-24
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        String[] ledgers = {"01/01 4 50000", "01/11 6 3555", "02/01 0 -23555", "02/25 5 5000", "03/25 0 -15000", "06/09 8 43951", "12/30 9 99999"};
        System.out.println(solution(ledgers));
    }

    static int[] dayOfCnt = {0,31,28,31,30,31,30,31,31,30,31,30,31};
    public static int solution(String[] ledgers) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();
        for (int i = 0,len = ledgers.length; i < len; i++) {
            String[] input = ledgers[i].trim().split(" ");
            int days = cnt(input[0]);
            int rate = Integer.parseInt(input[1]);
            int amount = Integer.parseInt(input[2]);
            if(amount>0){
                stack.push(new int[]{days,rate,amount});
            }else{
                    amount *=-1;
                while (amount!=0){
                    int[] arr = stack.pop();
                    if(amount < arr[2]){
                        arr[2] -= amount;
                        double tmp = (amount * (arr[1]*0.01)) * (double)(days-arr[0])/365;
                        answer += (int)tmp;
                        stack.push(arr);
                        amount = 0;
                    }else{
                        amount -= arr[2];
                        double tmp = (arr[2] * (arr[1]*0.01)) * (double)(days-arr[0])/365;
                        answer += (int)tmp;
                    }
                }
            }
        }
        while (!stack.isEmpty()){
            int days = 365;
            int[] arr = stack.pop();
            double tmp = (arr[2] * (arr[1]*0.01)) * (double)(days-arr[0])/365;
            answer += (int)tmp;
        }

        return answer;
    }

    private static int cnt(String str) {
        int num = 0;
        String[] input = str.split("/");
        int idx = Integer.parseInt(input[0]);
        for (int i = 0; i < idx; i++) {
            num += dayOfCnt[i];
        }
        num += Integer.parseInt(input[1]);
        return num;
    }
}

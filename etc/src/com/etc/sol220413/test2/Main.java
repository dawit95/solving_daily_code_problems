package com.etc.sol220413.test2;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-13
 * Description : 50%
 */
public class Main {
    public static void main(String[] args) {

        String str = "1231231231231321321321321231239";
        System.out.println(str);
        System.out.println(solution(str));
    }

    public static String solution(String S) {
        char[] charArr = S.trim().toCharArray();
        int[] number = new int[10];
        for (int i = 0, len = charArr.length; i < len; i++) {
            number[charArr[i] - '0']++;
        }
        StringBuilder front = new StringBuilder();
        StringBuilder end = new StringBuilder();
        for (int i = 9; i > 0; i--) {
            if (number[i] > 1) {
                int cnt = number[i] / 2;
                number[i] = number[i] % 2;
                for (int j = 0; j < cnt; j++) {
                    String value = i + "";
                    front.append(value);
                    end.insert(0, value);
                }
            }
        }
        int cnt = number[0] / 2;
        if(front.length()>0){
            for (int j = 0; j < cnt; j++) {
                String value = "0";
                front.append(value);
                end.insert(0, value);
            }
        }
        for (int i = 9; i >= 0; i--) {
            if (number[i] > 0) {
                front.append(i+"");
                break;
            }
        }
        front.append(end.toString());
        return front.toString();
    }
}

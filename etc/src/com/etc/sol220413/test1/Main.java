package com.etc.sol220413.test1;

import java.util.Arrays;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-13
 * Description : 100%
 */
public class Main {
    public static void main(String[] args) {
        String a = "99899998";
//        long tmpl = Long.parseLong(a);
        int tmpInt = Integer.parseInt(a);
        System.out.println(solution(tmpInt));
    }
    public static int solution(int N) {
        String str = N+"";
        char[] charArr = str.trim().toCharArray();
        Arrays.sort(charArr);
        StringBuilder sb= new StringBuilder();
        for (int i = charArr.length-1; i >= 0 ; i--) {
            sb.append(charArr[i]);
        }
        long check = Long.parseLong(sb.toString());
        check = check>100000000?-1:check;
        return (int) check;
    }
}

package com.programmers.skillcheck.level1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-10
 * Description : 스킬체크 레벨 1
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextInt();
        System.out.println(solution_1(n));

        String str = sc.nextLine();
        System.out.println(solution_2(str));

    }
    public static long solution_1(long n) {
        long answer = 0;
        BigInteger bigInteger = new BigInteger(n+"");
        BigInteger check = bigInteger.sqrt();
        BigInteger newCheck = check.multiply(check);
        if(newCheck.equals(bigInteger)){
            check = check.add(new BigInteger("1"));
            newCheck = check.multiply(check);
            answer = newCheck.longValue();
        }else{
            answer = -1;
        }
        return answer;
    }
    public static String solution_2(String phone_number) {
        int len = phone_number.length();
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < len-4; i++) {
            answer.append("*");
        }
        answer.append(phone_number.substring(len-4,len));
        return answer.toString();
    }
}

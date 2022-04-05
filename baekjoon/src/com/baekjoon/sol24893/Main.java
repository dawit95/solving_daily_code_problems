package com.baekjoon.sol24893;

import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-04
 * Description :
 */
public class Main {
    static int[] enemy;
    static long minAns;
    static int n;
    static long a, b, e;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = sc.nextLong();
        b = sc.nextLong();
        e = sc.nextLong();
        enemy = new int[n];
        int maxHuman = 0;
        for (int i = 0; i < n; i++) {
            enemy[i] = sc.nextInt();
            maxHuman += enemy[i];

        }
        maxHuman = maxHuman - e < 0 ?1:maxHuman;
        minAns = check(0, n) ? -1000000000 * b : Long.MAX_VALUE;

//        divisionTime(maxHuman,n,0);
        for (int time = n; time > 0; time--) {
            long tmp = minAns;
            division(maxHuman,0,time);
            if(tmp != Long.MAX_VALUE && tmp == minAns){
                break;
            }
        }
        System.out.println(minAns);
    }

//    private static boolean divisionTime(int maxHuman, int maxT, int minT){
//        if((maxT+minT)/2 >= maxT) return false;
//
//        long tmp = minAns;
//        division(maxHuman,0,maxT);
//        if(minAns != Long.MAX_VALUE && tmp != minAns){
//            return true;
//        }
//
//        //최적을 찾기 위해 재장전 시간 낮춤
//        if(divisionTime(maxHuman,(maxT+minT)/2,minT)){
//            divisionTime(maxHuman,maxT,(maxT+minT)/2);
//        }
//        return false;
//    }

    private static boolean division(int maxH, int minH, int time) {
        if((maxH+minH)/2<=minH){
            if (check(maxH, time)) {
                if (time == n) {
                    minAns = Math.min(maxH * a - 1000000000 * b, minAns);
                } else {
                    minAns = Math.min(maxH * a - time * b, minAns);
                }
            }
            if (check(minH, time)) {
                if (time == n) {
                    minAns = Math.min(minH * a - 1000000000 * b, minAns);
                } else {
                    minAns = Math.min(minH * a - time * b, minAns);
                }
            }
            return false;
        }
        if (check(minH, time)) {
            if (time == n) {
                minAns = Math.min(minH * a - 1000000000 * b, minAns);
            } else {
                minAns = Math.min(minH * a - time * b, minAns);
            }
            return true;
        }

        //최적을 찾기 위해 군인수를 늘림
        if(division(maxH,(maxH+minH)/2,time)){
            division((maxH+minH)/2,minH,time);
        }

        return false;
    }

    private static boolean check(int human, int time) {
        int[] damage = new int[n];
        System.arraycopy(enemy, 0, damage, 0, n);
        int[] nowHuman = new int[n];
        int index = 0;
        while (index < n) {
            nowHuman[index] = human;
            index += time;
        }

        long energy = e;

        for (int i = 0; i < n; i++) {
            if (damage[i] <= nowHuman[i]) {
                if (i + 1 < n) {
                    nowHuman[i + 1] += nowHuman[i] - damage[i];
                }
                damage[i] = 0;
            } else {
                damage[i] -= nowHuman[i];
            }
            energy -= damage[i];
            if (energy <= 0) return false;
        }
        return true;
    }


}

package com.baekjoon.sol24892;

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
        int maxHuman = 0, minHuman = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            enemy[i] = sc.nextInt();
            maxHuman += enemy[i];
            minHuman = Math.min(minHuman, enemy[i]);
        }

        minAns = check(0, n) ? -1000000000 * b : Long.MAX_VALUE;

        for (int human = minHuman; human <= maxHuman; human++) {
            for (int time = n; time > 0; time--) {
                if (check(human, time)) {
                    if (time == n) {
                        minAns = Math.min(human * a - 1000000000 * b, minAns);
                    } else {
                        minAns = Math.min(human * a - time * b, minAns);
                    }

                    break;
                }
            }
        }
        System.out.println(minAns);
    }

//    private static void division(int maxH, int minH, int maxT, int minT) {
//        if(check(minH,maxT)){
//            //더욱 깊게 들어가보자
//
//            return;
//        }
//        if()
//    }

    private static boolean check(int human, int time) {
        int[] tmp = new int[n];
        System.arraycopy(enemy, 0, tmp, 0, n);
        int[] nowHuman = new int[n];
        int index = 0;
        while (index < n) {
            nowHuman[index] = human;
            index += time;
        }

        long energy = e;

        for (int i = 0; i < n; i++) {
            int idx = i + time;
            if (tmp[i] <= nowHuman[i]) {
                if (i + 1 < n) {
                    nowHuman[i + 1] += nowHuman[i] - tmp[i];
                }
                tmp[i] = 0;
            } else {
                tmp[i] -= nowHuman[i];
            }
            energy -= tmp[i];
            if (energy <= 0) return false;
        }
        return true;
    }


}

package com.etc.sol220413.test3;

import java.util.Arrays;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-13
 * Description : 87%
 */
public class Main {
    public static void main(String[] args) {

    }

    private int h, m, s;
    private int[] num;

    public int solution(String S, String T) {
        num = new int[10];
        String[] start = S.trim().split(":");
        h = Integer.parseInt(start[0]);
        m = Integer.parseInt(start[1]);
        s = Integer.parseInt(start[2]);
        String[] end = T.trim().split(":");
        int endH = Integer.parseInt(end[0]);
        int endM = Integer.parseInt(end[1]);
        int endS = Integer.parseInt(end[2]);

        int cnt = 0;
        //시작 체크
        Arrays.fill(num, 0);
        for (int i = 0; i < 3; i++) {
            num[start[i].charAt(0) - '0']++;
            num[start[i].charAt(1) - '0']++;
        }
        if (check()) cnt++;

        //기간 체크
        while (s != endS || m != endM || h != endH) {
            if (next()) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean next() {
        //sec
        minus(s);
        s++;
        if (9 < s && s < 60) {
            num[s % 10]++;
            num[(s / 10) % 10]++;
        } else if (s <= 9) {
            num[0]++;
            num[s]++;
        } else {
            s = 0;
            num[0] += 2;
            //min
            minus(m);
            m++;
            if (9 < m && m < 60) {
                num[m % 10]++;
                num[(m / 10) % 10]++;
            } else if (m <= 9) {
                num[0]++;
                num[m]++;
            } else {
                m = 0;
                num[0] += 2;
                //hour
                minus(h);
                h++;
                if (9 < h && h < 23) {
                    num[h % 10]++;
                    num[(h / 10) % 10]++;
                } else if (h <= 9) {
                    num[0]++;
                    num[h]++;
                } else {
                    h = 0;
                    num[0] += 2;
                }
            }

        }
        return check();
    }

    private void minus(int time) {
        if (time < 10) {
            num[0]--;
            num[time]--;
        } else {
            num[time % 10]--;
            num[(time / 10) % 10]--;
        }
    }

    private boolean check() {
        int cntOfNum = 0;
        for (int i = 0; i < 10; i++) {
            if (num[i] > 0) cntOfNum++;
        }
        if (cntOfNum < 3) return true;
        return false;
    }
}

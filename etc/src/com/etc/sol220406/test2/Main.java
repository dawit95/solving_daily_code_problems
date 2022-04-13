package com.etc.sol220406.test2;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-06
 * Description :
 */
public class Main {
    public static void main(String[] args) {

    }

    public int[] solution(String s, String[] times) {
        int[] answer = new int[2];
        String[] dayStr = s.trim().split(":");
        int[] day = new int[6];
        for (int i = 0; i < 6; i++) {
            day[i] = Integer.parseInt(dayStr[i]);
        }
        int[] startDay = day;
        boolean flag = true;

        for (int i = 0, len = times.length; i < len; i++) {
            int[] next = addDay(day, times[i].trim().split(":"));
            //작은날은 안봄 다음날만 봄
            if (day[0] == next[0] && day[1] == next[1] && !(day[2] + 1 == next[2] || day[2] == next[2]) && flag) {
                flag = false;
            }
            day = next;
        }

        answer[0] = flag ? 1 : 0;
        answer[1] = cntDay(startDay, day);
        return answer;
    }

    private int cntDay(int[] startDay, int[] lastDay) {
        int cnt = (lastDay[0] - startDay[0]) * 360;
        cnt += (lastDay[1] - startDay[1]) * 30;
        cnt += lastDay[2] - startDay[2];
        return cnt + 1;
    }

    private static int[] addDay(int[] day, String[] time) {
        int[] next = new int[6];
        System.arraycopy(day, 0, next, 0, 6);
        int[] arr = new int[6];
        for (int i = 2; i < 6; i++) {
            arr[i] = Integer.parseInt(time[i - 2]);
        }
        for (int i = 5; i > 1; i--) {
            int tmp = next[i] + arr[i];
            if (tmp >= 60 && i > 3) {
                next[i - 1]++;
                tmp -= 60;
            } else if (tmp >= 24 && i == 3) {
                next[i - 1]++;
                tmp -= 24;
            } else if (tmp > 30 && i == 2) {
                next[i - 1]++;
                tmp -= 30;
            }
            next[i] = tmp;
        }
        if (next[1] > 12) {
            next[0]++;
            next[1] -= 12;
        }
        return next;
    }
}

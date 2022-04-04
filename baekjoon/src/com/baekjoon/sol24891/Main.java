package com.baekjoon.sol24891;

import java.util.Arrays;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-04
 * Description :
 */
public class Main {
    static char[][] map;
    static boolean flag;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int l = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();
        String[] word = new String[n];
        for (int i = 0; i < n; i++) {
            word[i] = sc.nextLine();
        }
        Arrays.sort(word);
        map = new char[l][l];
        for (int i = 0; i < l; i++) {
            Arrays.fill(map[i], ' ');
        }
        flag = false;

        permu(0, 0, l, n, word);
        if (!flag)
            System.out.println("NONE");
    }

    private static void permu(int idx, int check, int end, int n, String[] word) {
        if (idx == end) {
            flag = true;
            for (int i = 0; i < end; i++) {
                System.out.println(new String(map[i]));
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            //permu의 선택 여부 && 가능한지 확인
            if ((check & 1 << i) == 0 && input(word[i - 1], idx) && !flag) {
                permu(idx + 1, check | 1 << i, end, n, word);
                output(word[i - 1], idx);
            }

        }
    }

    private static void output(String word, int idx) {
        for (int i = idx; i < word.length(); i++) {
            map[idx][i] = map[i][idx] = ' ';
        }
    }

    private static boolean input(String word, int idx) {
        for (int i = 0; i < word.length(); i++) {
            if (' ' != map[idx][i] && map[idx][i] != word.charAt(i)) {
                return false;
            }
            if (' ' != map[i][idx] && map[i][idx] != word.charAt(i)) {
                return false;
            }
        }
        for (int i = 0; i < word.length(); i++) {
            map[idx][i] = map[i][idx] = word.charAt(i);
        }
        return true;
    }
}

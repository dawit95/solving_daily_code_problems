package com.baekjoon.sol2573;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-07
 * Description : BaekJoon Problem 2573 : https://www.acmicpc.net/problem/2573
 */
public class Main {
    static ArrayList<int[]> list;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static int R, C;

    public static void main(String[] args) {
        list = new ArrayList<>();
        int day = 0;
        // input
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        int[][] map = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] > 0)
                    list.add(new int[]{i, j, map[i][j]});
            }
        }
        sc.close();
        // while
        boolean flag = true;
        while (flag) {
            // One year later
            map = OneYearLater(map);
            day++;
            if (list.size() == 0) {
                day = 0;
                break;
            }
            // Check if it's split
            flag = CheckIfSplit(map);
        }
        System.out.println(day);
    }

    private static boolean CheckIfSplit(int[][] map) {
        boolean[][] visited = new boolean[R][C];
        int[] start = list.get(0);
        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.offer(start);
        while (!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int tr = now[0] + dr[i];
                int tc = now[1] + dc[i];
                if(tr<0||tc<0||tr>R-1||tc>C-1) continue;
                if(visited[tr][tc]) continue;
                if(map[tr][tc] > 0){
                    visited[tr][tc] = true;
                    q.offer(new int[] {tr,tc});
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] > 0 && !visited[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    private static int[][] OneYearLater(int[][] map) {
        int[][] newMap = new int[R][C];
        int size = list.size();
        for (int idx = 0; idx < size; idx++) {
            int[] target = list.get(idx);
            int minus = 0;
            for (int i = 0; i < 4; i++) {
                int tr = target[0] + dr[i];
                int tc = target[1] + dc[i];
                if (tr < 0 || tc < 0 || tr > R - 1 || tc > C - 1) continue;
                if (map[tr][tc] == 0) minus++;
            }
            if (target[2] - minus > 0) {
                newMap[target[0]][target[1]] = target[2] - minus;
                list.add(new int[]{target[0], target[1], newMap[target[0]][target[1]]});
            }
        }
        if (size > 0) {
            list.subList(0, size).clear();
        }
        return newMap;
    }
}

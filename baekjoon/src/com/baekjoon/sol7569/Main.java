package com.baekjoon.sol7569;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-04
 * Description : BaekJoon Problem 7569
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int r = sc.nextInt();
        int h = sc.nextInt();
        int day = 0, cnt =0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[h][r][c];
        int[][][] box = new int[h][r][c];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    box[i][j][k] = sc.nextInt();
                    if (box[i][j][k] == 1) {
                        visited[i][j][k] = true;
                        q.offer(new int[]{i, j, k});
                    }else if(box[i][j][k] == 0){
                        cnt++;
                    }
                }
            }
        }


        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while (!q.isEmpty() && cnt!=0) {
            int qSize = q.size();
            day++;
            for (int qSearch = 0; qSearch < qSize; qSearch++) {
                int[] now = q.poll();
                //around
                for (int i = 0; i < 4; i++) {
                    int tr = now[1] + dr[i];
                    int tc = now[2] + dc[i];
                    if (tr < 0 || tc < 0 || tr > r - 1 || tc > c - 1) continue;
                    if (visited[now[0]][tr][tc]) continue;
                    visited[now[0]][tr][tc] = true;
                    if (box[now[0]][tr][tc] == 0) {
                        q.offer(new int[]{now[0], tr, tc});
                        cnt--;
                    }
                }
                //up & down
                for (int i = -1; i < 2; i += 2) {
                    int th = now[0] + i;
                    if (th < 0 || th > h - 1) continue;
                    if (visited[th][now[1]][now[2]]) continue;
                    visited[th][now[1]][now[2]] = true;
                    if (box[th][now[1]][now[2]] == 0) {
                        q.offer(new int[]{th, now[1], now[2]});
                        cnt--;
                    }
                }
            }
        }

        System.out.println(cnt==0?day:-1);
    }
}

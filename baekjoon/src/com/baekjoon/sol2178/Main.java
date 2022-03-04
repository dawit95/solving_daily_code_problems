package com.baekjoon.sol2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-04
 * Description : BaekJoon Problem 2178
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = 0, c = 0, ans = 0;
        r = sc.nextInt();
        c = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] row = sc.nextLine().trim().split("");
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        sc.close();

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        q.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (now[0] == r-1 && now[1] == c-1) {
                ans = now[2];
                break;
            }
            for (int i = 0; i < 4; i++) {
                int tr = now[0] +dr[i];
                int tc = now[1] +dc[i];
                if(tr<0||tc<0||tr>r-1||tc>c-1) continue;
                if(visited[tr][tc]) continue;
                visited[tr][tc] = true;
                if(map[tr][tc] == 0) continue;
                q.offer(new int[] {tr,tc,now[2]+1});
            }
        }
        System.out.println(ans);
    }
}

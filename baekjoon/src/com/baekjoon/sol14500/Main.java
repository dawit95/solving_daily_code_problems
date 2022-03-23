package com.baekjoon.sol14500;

import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-24
 * Description :
 */
public class Main {
    private static int n, m, ans;
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};
    private static int[][] map;
    private static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ans = 0;
        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, map[i][j], visited);
                visited[i][j] = false;
                type(i, j);
            }
        }
        System.out.println(ans);
    }

    private static void type(int r, int c) {
        if (check(r, c + 1) && check(r, c - 1) && check(r - 1, c)) {
            ans = Math.max(map[r][c + 1] + map[r][c - 1] + map[r - 1][c] + map[r][c], ans);
        }
        if (check(r - 1, c) && check(r + 1, c) && check(r, c + 1)) {
            ans = Math.max(map[r - 1][c] + map[r + 1][c] + map[r][c + 1] + map[r][c], ans);
        }
        if (check(r, c + 1) && check(r, c - 1) && check(r + 1, c)) {
            ans = Math.max(map[r][c + 1] + map[r][c - 1] + map[r + 1][c] + map[r][c], ans);
        }
        if (check(r - 1, c) && check(r + 1, c) && check(r, c - 1)) {
            ans = Math.max(map[r - 1][c] + map[r + 1][c] + map[r][c - 1] + map[r][c], ans);
        }
    }

    private static void dfs(int r, int c, int cnt, int sum, boolean[][] visited) {
        if (cnt == 4) {
            ans = Math.max(ans, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int tr = r + dr[i];
            int tc = c + dc[i];

            if (check(tr, tc) && !visited[tr][tc]) {
                visited[tr][tc] = true;
                dfs(tr, tc, cnt + 1, sum + map[tr][tc], visited);
                visited[tr][tc] = false;
            }
        }
    }

    private static boolean check(int r, int c) {
        return !(r < 0 || c < 0 || r > n - 1 || c > m - 1);
    }
}

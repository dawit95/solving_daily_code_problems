package com.baekjoon.sol1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-05
 * Description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        while (testCase-->0){
            String[] input = br.readLine().trim().split(" ");
            int c = Integer.parseInt(input[0]), r = Integer.parseInt(input[1]);
            int[][] map = new int[r][c];
            int k = Integer.parseInt(input[2]);
            for (int idx = 0; idx < k; idx++) {
                input = br.readLine().trim().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                map[y][x] = 1;
            }

            int ans = 0;
            boolean[][] visited = new boolean[r][c];
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    if(!visited[i][j] && map[i][j]==1){
                        bfs(i,j,map,visited,r,c);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    static int[] dr = {0,0,1,-1};
    static int[] dc = {1,-1,0,0};
    private static void bfs(int r, int c, int[][] map, boolean[][] visited, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.offer(new int[]{r,c});
        while (!queue.isEmpty()){
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int tr = now[0] + dr[i];
                int tc = now[1] + dc[i];
                if(tr<0||tc<0||tr>n-1||tc>m-1) continue;
                if(visited[tr][tc]) continue;
                if(map[tr][tc] == 0) continue;
                visited[tr][tc] = true;
                queue.offer(new int[]{tr,tc});
            }
        }
    }
}

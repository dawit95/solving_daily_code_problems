package com.baekjoon.sol2667;

import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-04
 * Description : BaekJoon Problem 2667
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0;
        size = sc.nextInt();
        sc.nextLine();
        int[][] map = new int[size][size];
        for (int i = 0; i < size; i++) {
            String[] row = sc.nextLine().trim().split("");
            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(row[j]);
            }
        }
        sc.close();

        ArrayList list = new ArrayList<>();
        boolean[][] visited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    list.add(bfs(i, j, map, visited, size));
                }
            }
        }
        Collections.sort(list);
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static int bfs(int r, int c, int[][] map, boolean[][] visited, int size) {
        int ans = 1;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while (!q.isEmpty()) {
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int tr = now[0] + dr[i];
                int tc = now[1] + dc[i];
                if (tr < 0 || tc < 0 || tr > size - 1 || tc > size - 1) continue;
                if (visited[tr][tc]) continue;
                visited[tr][tc] = true;
                if (map[tr][tc] == 0) continue;
                ans++;
                q.offer(new int[]{tr, tc});
            }
        }
        return ans;
    }
}

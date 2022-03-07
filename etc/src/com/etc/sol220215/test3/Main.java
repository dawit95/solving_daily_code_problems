package com.etc.sol220215.test3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 0, 2, 0, 0, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 1, 0, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 1, 0}, {0, 0, 1, 1, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 3, 0, 0, 0, 1, 0}};
        int c = 1;
        System.out.println(solution(board,c));
    }

    public static int solution(int[][] board, int c) {
        int answer = 0;
        int[] dr = { -1, 0, 1, 0 };
        int[] dc = { 0, 1, 0, -1 };
        int n = board.length, m = board[0].length;
        int nowRow=-1,nowCol=-1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(board[i][j]==2){
                    nowCol = j;
                    nowRow = i;
                    break;
                }
            }
            if(nowRow!=-1){
                break;
            }
        }

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((Comparator.comparingInt(o -> o[2])));
        pq.offer(new int[]{nowRow, nowCol, 0});
        visited[nowRow][nowCol] = 0;

        while (!pq.isEmpty()) {
            int[] now = pq.poll();

            if (board[now[0]][now[1]]==3) {
                answer = now[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int tmpR = now[0] + dr[i];
                int tmpC = now[1] + dc[i];
                // 범위
                if (tmpR < 0 || tmpR >= n || tmpC < 0 || tmpC >= m)
                    continue;
                // 방문처리
                int value = board[tmpR][tmpC]==1?c+1:1;
                if (visited[tmpR][tmpC] <= now[2]+value) {
                    continue;
                }
                visited[tmpR][tmpC] = now[2]+value;
                //queue insert
                pq.offer(new int[] {tmpR,tmpC,now[2]+value});
            }
        }

        return answer;
    }
}

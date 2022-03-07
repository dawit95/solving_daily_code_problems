package com.etc.sol220125.test2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {


    }
    int[] dr = {0,0,1,-1};
    int[] dc = {1,-1,0,0};
    int minNum;
    public int solution(int[][] board, int c) {
        minNum = Integer.MAX_VALUE;
        int rowLen = board.length, colLen = board[0].length;
        int[][] minTable = new int[rowLen][colLen];
        for (int i = 0; i < rowLen; i++) {
            Arrays.fill(minTable[i],Integer.MAX_VALUE);
        }
        //int[] row,col,nowValue
        Queue<int[]> q = new LinkedList<>();
        int row=0,col=0, nowValue=-1;
        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if(board[i][j]==2){
                    row = i;
                    col = j;
                    nowValue=0;
                    break;
                }
            }
            if(nowValue == 0)
                break;
        }
        q.offer(new int[] {row,col,nowValue});
        minTable[row][col] = 0;
        while(!q.isEmpty()){
            int[] now = q.poll();
            //ending & prun
            if(now[2]>minNum){
                continue;
            }
            if(board[now[0]][now[1]]==3){
                minNum = Math.min(minNum,now[2]);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int tr = now[0] + dr[i];
                int tc = now[1] + dc[i];
                if(tr<0||tc<0||tr>rowLen-1||tc>colLen-1) continue;
                int value = board[tr][tc]==1?c:1;
                now[2] += value;
                if(minTable[tr][tc]<=now[2]) continue;
                minTable[tr][tc] = now[2];
                q.offer(new int[] {tr,tc,now[2]});
            }

        }
        return minNum;
    }
}

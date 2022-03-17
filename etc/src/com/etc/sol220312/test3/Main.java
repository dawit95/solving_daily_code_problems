package com.etc.sol220312.test3;

import java.math.BigInteger;
import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {
//        int width = 2, height = 2;
//        int[][] diagonals = {{1,1},{2,2}};
        int width = 51, height = 37;
        int[][] diagonals = {{17,19}};

        BigInteger answer = new BigInteger("0");
        // 최단거리 가지수 배열
        BigInteger[][] value = new BigInteger[height+1][width+1];
        for (int i = 0; i <= height; i++) {
            value[i][0] = new BigInteger("1");
        }
        for (int i = 0; i <= width; i++) {
            value[0][i] = new BigInteger("1");
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                value[i][j] = value[i-1][j].add(value[i][j-1]);
            }
        }

        for (int i = 0, len = diagonals.length; i < len; i++) {
            int R = diagonals[i][1];
            int C = diagonals[i][0]-1;
            int H = height-(diagonals[i][1]-1);
            int W = width-(diagonals[i][0]);
            answer= answer.add(value[R][C].multiply(value[H][W]));
            R = diagonals[i][1]-1;
            C = diagonals[i][0];
            H = height-(diagonals[i][1]);
            W = width-(diagonals[i][0]-1);
            answer=answer.add(value[R][C].multiply(value[H][W]));
        }
        int tmp =answer.remainder(new BigInteger("10000019")).intValue();

        System.out.println(answer.intValue());
    }

    public int solution(int width, int height, int[][] diagonals) {
        int answer = 0;
        // 최단거리 가지수 배열
        int[][] value = new int[height+1][width+1];
        for (int i = 0; i <= height; i++) {
            value[i][0] = 1;
        }
        for (int i = 0; i <= width; i++) {
            value[0][i] = 1;
        }
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                value[i][j] = value[i-1][j]+value[i][j-1];
            }
        }

        for (int i = 0, len = diagonals.length; i < len; i++) {
            answer += value[diagonals[i][0]][diagonals[i][1] - 1] + value[height-(diagonals[i][0]-1)][width-diagonals[i][1]];
            answer += value[diagonals[i][0] - 1][diagonals[i][1]] + value[height-diagonals[i][0]][width-(diagonals[i][1] - 1)];
        }

        return answer;
    }


//    public int solution(int width, int height, int[][] diagonals) {
//        int answer = 0;
//
//        HashSet<int[]> set = new HashSet<>();
//        for (int i = 0, len = diagonals.length; i < len; i++) {
//            set.add(new int[]{diagonals[i][0], diagonals[i][1] - 1});
//            set.add(new int[]{diagonals[i][0] - 1, diagonals[i][1]});
//        }
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return Integer.compare(o1[3],o2[3]);
//            }
//        });
//        boolean[][] visited = new boolean[height + 1][width + 1];
//        visited[0][0] = true;
//        // row,col,chance,dist
//        pq.offer(new int[]{0, 0, 1, 0});
//
//        int[] dr = {0, 0, 1, -1};
//        int[] dc = {1, -1, 0, 0};
//        while (!pq.isEmpty()) {
//            int[] now = pq.poll();
//            //종료
//
//            //반복
//            for (int i = 0; i < 4; i++) {
//                int tr = now[0] + dr[i];
//                int tc = now[1] + dc[i];
//                if(tr<0||tc<0||tr>height||tc>width) continue;
//                if(visited[tr][tc]) continue;
//                visited[tr][tc] = true;
//                pq.offer(new int[]{tr,tc,now[2],now[3]+1});
//                if(set.contains(new int[]{tr,tc})){
//
//                }
//            }
//        }
//        return answer;
//    }
}

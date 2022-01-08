package com.etc.sol220106.test3;

public class Main {

    static String[] grid = {"B", "RRB"};

    static int[][] map;
    static int ans;
    public static void main(String[] args) {
        int ans = 0;
        //준비
        int len = grid.length;
        map = new int[len][2*len+1];
        ans = 1;

        //입력
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                // r = i , c = j+(len/2 - i)
                int r = i;
                int c = j + (len / 2 - i);
                map[r][c] = grid[i].charAt(j)=='B'?1:2;
            }
        }
        // 모든 edge 탐색
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 2 * i + 1; j++) {
                // r = i , c = j+(len/2 - i)
                int r = i;
                int c = j + (len / 2 - i);
                if(j==0||j==2*i||(i==grid.length-1&&c%2==1)){
                    find(-1,1,r,c);
                }
            }
        }
    }

    private static void find(int dir, int len, int r, int c) {
        //map을 벗어나거나 삼각형을 나오면;
        if(r<0||c<0||r>map.length-1||c>map.length-1||map[r][c]==0){
            ans = Math.max(ans, len);
        }
        switch (dir){
            case -1:
                break;
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
}

package com.etc.sol220312.test2;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {

//        int n = 6;
//        boolean clockwise =false;
//
//
//        System.out.println(answer);
    }

    static int[][] answer;

    private static void inputValue(int[] dr, int[] dc, int pivot, int len, int r, int c) {
        for (int i = 0; i < 4; i++) {
            int tmp = pivot;    //input 값
            for (int j = 0; j < len; j++) {
                answer[r][c] = tmp;
                tmp++;
                r += dr[i];
                c += dc[i];
            }
        }
        if(len == 0){
            answer[r][c] = pivot;
        }
    }

    public int[][] solution(int n, boolean clockwise) {
        answer = new int[n][n];
        int pivot = 1;
        int len = n - 1; //길이
        int[] dr,dc;
        if(clockwise){
            dr = new int[]{0, 1, 0, -1};
            dc = new int[]{1, 0, -1, 0};
        }else{
            dr = new int[]{0,1,0,-1};
            dc = new int[]{-1,0,1,0};
        }
        for (int idx = 0, limit = n / 2 + 1; idx < limit; idx++) {
            int r,c;//시작 좌표
            if(clockwise){
                r=idx; c=idx;
            }else{
                r=idx; c=n-1-idx;
            }


            //input
            inputValue(dr,dc,pivot,len, r,c);

            pivot += len;
            len -= 2;
        }
        return answer;
    }
}

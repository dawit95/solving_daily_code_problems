package com.programmers.skillcheck.level3;

import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-10
 * Description : 스킬체크 레벨 3
 */
public class Main {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};
//        String[][] strArr = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        System.out.println(solution_2(strArr));
    }

    public int solution_1(int n, int[][] results) {
        int answer = 0;
        boolean[][] game = new boolean[n][n];
        for (int[] ints : results) {
            game[ints[0] - 1][ints[1] - 1] = true;
        }

        //플로이드 워셜 알고리즘
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(game[j][i]&&game[i][k]){game[j][k]=true;}
                }
            }
        }

        for(int i=0; i<n; i++){
            int result=0;
            for(int j=0; j<n; j++){
                if(game[i][j] || game[j][i]){result++;}
            }
            if(result==n-1){answer++;}
        }
        return answer;
    }

    boolean[] visited;
    ArrayList<String> answers;
    public String[] solution_2(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        int count = 0;
        dfs(count, "ICN", new StringBuilder("ICN"),tickets);
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    public void dfs(int count, String present, StringBuilder answer, String[][]ticktes) {
        if(count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer.toString());                //answers에 추가
            return;
        }
        for(int i = 0; i < ticktes.length; i++) {
            if(!visited[i] && ticktes[i][0].equals(present)) {
                visited[i] = true;
                dfs(count+1, ticktes[i][1],answer.append(" ").append(ticktes[i][1]) , ticktes);
                visited[i] = false;
            }
        }
    }
}

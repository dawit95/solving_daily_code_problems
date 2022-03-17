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
//        int n = 5;
//        int[][] results = {{4,3},{4,2},{3,2},{1,2},{2,5}};

//        String[][] strArr = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};
//        System.out.println(solution_2(strArr));

//        int n =16;
//        int[] stations = {4,11};
//        int w =1;

//        int n = 2, s = 9;


    }

    public int solution_1(int n, int[][] results) {
        int answer = 0;
        boolean[][] game = new boolean[n][n];
        for (int[] ints : results) {
            game[ints[0] - 1][ints[1] - 1] = true;
        }

        //플로이드 워셜 알고리즘
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (game[j][i] && game[i][k]) {
                        game[j][k] = true;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int result = 0;
            for (int j = 0; j < n; j++) {
                if (game[i][j] || game[j][i]) {
                    result++;
                }
            }
            if (result == n - 1) {
                answer++;
            }
        }
        return answer;
    }

    boolean[] visited;
    ArrayList<String> answers;

    public String[] solution_2(String[][] tickets) {
        visited = new boolean[tickets.length];
        answers = new ArrayList<>();
        int count = 0;
        dfs(count, "ICN", new StringBuilder("ICN"), tickets);
        Collections.sort(answers);
        return answers.get(0).split(" ");
    }

    public void dfs(int count, String present, StringBuilder answer, String[][] ticktes) {
        if (count == ticktes.length) {            //모든 공항을 들렸다면
            answers.add(answer.toString());                //answers에 추가
            return;
        }
        for (int i = 0; i < ticktes.length; i++) {
            if (!visited[i] && ticktes[i][0].equals(present)) {
                visited[i] = true;
                dfs(count + 1, ticktes[i][1], answer.append(" ").append(ticktes[i][1]), ticktes);
                visited[i] = false;
            }
        }
    }

    public int solution_3(int n, int[] stations, int w) {
        int answer = 0;
        int stationIdx = 0, len = stations.length;
        for (int idx = 1; idx <= n; idx++) {
            if (stationIdx < len && idx >= stations[stationIdx] - w) {
                idx = stations[stationIdx] + w;
                stationIdx++;
            } else {
                answer++;
                idx += w * 2;
            }
        }
        return answer;
    }

    public int[] solution_4(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }
        int[] answer = new int[n];
        if (s % n == 0) {        //나눠지는 경우
            for (int i = 0; i < n; i++) {
                answer[i] = s / n;
            }

        } else {                //안나눠지는 경우
            int rem = s % n;
            int po = n - rem;    //1씩 더해줘야하는 인덱스 위치
            for (int i = 0; i < po; i++) {  //po까지는 원래대로 추가
                answer[i] = s / n;
            }
            for (int i = po; i < n; i++) {  //po부터 n까지는 1씩 추가
                answer[i] = s / n + 1;
            }
        }
        return answer;
    }

}

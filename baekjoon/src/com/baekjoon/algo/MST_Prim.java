package com.baekjoon.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * FileName : Prim
 * Author : David
 * Date : 2022-03-23
 * Description :
 */
public class MST_Prim {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] adjMatrix = new int[N][N];
        boolean[] visited = new boolean[N]; //손잡은 넘 고려 안하기
        int[] minEdge = new int[N];	// 각각의 제일 짧은 간선 확인용
        // 신장트리에 연결된 정점에서 자신으로의 최소간선비용

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
            minEdge[i] = Integer.MAX_VALUE;
        }

        int result = 0;
        // 0index 정점을 시작하는 정점으로 처리하기 위해 0 세팅.
        minEdge[0] = 0;

        for (int c = 0; c < N; c++) {

            int min = Integer.MAX_VALUE;
            int minVertex = 0;
            // 신장트리에 연결되지 않은 정점중 minEdge비용이 최소인 정점.
            for (int i = 0; i < N; i++) {
                //아직 신장트리에 없고 가장 최소정점을 보요하는 정점을 찾는중.
                if(!visited[i]&& min>minEdge[i]) {
                    min = minEdge[i];
                    minVertex = i;
                }
            }

            result += min;
            visited[minVertex] = true;

            for (int i = 0; i < N; i++) {
                //아직 신장에 없고 나와 연결되어있는 아이들 중에 edge의 길이가 나랑 더 짧으면 update
                if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i]>adjMatrix[minVertex][i]) {
                    minEdge[i] = adjMatrix[minVertex][i];
                }
            }
        }
        System.out.println(result);
    }
}

package com.baekjoon.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * FileName : Dijkstra
 * Author : David
 * Date : 2022-03-09
 * Description : Dijkstra algo
 */
public class Dijkstra {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine().trim());
        int start = 0; // 출발점
        int end = V - 1; // 도착점

        int[][] adjMatrix = new int[V][V]; // 인접 행렬

        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            for (int j = 0; j < V; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 정답 배열
        int[] distance = new int[V];
        // 하나씩 확인하고 다시 않하기 위해 불린
        boolean[] visited = new boolean[V];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        for (int i = 0; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int current = 0; // min 최소비용에 해당하는 정점번호.
            // step 1. : 처리하지 않은 정점중에 출발지에서 가장 가까운(최소비용) 정점 선택
            for (int j = 0; j < V; j++) {
                if (!visited[j] && min > distance[j]) {
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            if(current == end) break;

            // step 2. : 선택된 current를 경유지로 하여 아직 처리하지 않은 다른 정점으로의 최소 비용 따져본다.
            for (int j = 0; j < V; j++) {
                if (!visited[j] && adjMatrix[current][j] != 0 && distance[j] > min + adjMatrix[current][j]) {
                    distance[j] = min + adjMatrix[current][j];
                }
            }
        }
        System.out.println(distance[end]==Integer.MAX_VALUE?"INF":distance[end]);
    }
}

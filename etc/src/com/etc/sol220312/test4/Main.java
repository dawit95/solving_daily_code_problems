package com.etc.sol220312.test4;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-12
 * Description :
 */
public class Main {

    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}};

        long answer = 0;
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 3000000);
        }
        for (int l = 0; l < n - 1; l++) {
            dist[edges[l][0]][edges[l][1]] = 1;
            dist[edges[l][1]][edges[l][0]] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(i==j || j==k || i==k) continue;
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(i==j || j==k || i==k) continue;
                    if(dist[i][k] + dist[k][j] == dist[i][j]){
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public long solution(int n, int[][] edges) {
        long answer = 0;
        int dist[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], 3000000);
        }
        for (int l = 0; l < n - 1; l++) {
            dist[edges[l][0]][edges[l][1]] = 1;
            dist[edges[l][1]][edges[l][0]] = 1;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if(dist[i][k] + dist[k][j] == dist[i][j]){
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}

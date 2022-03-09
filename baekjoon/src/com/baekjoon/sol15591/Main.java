package com.baekjoon.sol15591;

import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-09
 * Description : BaekJoon Problem 15591
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int Q = sc.nextInt();
        List<int[]>[] adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            adj[i] = new ArrayList<>();

        for (int i = 1; i < N; i++) {
            int p = sc.nextInt(), q = sc.nextInt(), r = sc.nextInt();
            adj[p].add(new int[]{q, r});
            adj[q].add(new int[]{p, r});
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int k = sc.nextInt(), v = sc.nextInt();

            boolean[] visit = new boolean[N + 1];
            visit[v] = true;
            Queue<Integer> que = new LinkedList<>();
            que.offer(v);

            int ans = 0;
            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int[] tmp : adj[cur]) {
                    if (!visit[tmp[0]] && tmp[1] >= k) {
                        que.add(tmp[0]);
                        visit[tmp[0]] = true;
                        ans++;
                    }
                }
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }
}

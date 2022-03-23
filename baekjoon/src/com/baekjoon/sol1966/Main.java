package com.baekjoon.sol1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] input;
        while (testCase-- > 0) {
            input = br.readLine().trim().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            input = br.readLine().trim().split(" ");
            PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2[1], o1[1])));
            Queue<int[]> que = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                int[] arr = new int[]{i, Integer.parseInt(input[i])};
                que.offer(arr);
                priorityQueue.offer(arr);
            }
            int cnt = 0;
            while (!que.isEmpty()) {
                int[] pq = priorityQueue.peek();
                int[] q = que.poll();
                if (pq[1] == q[1]) {
                    priorityQueue.poll();
                    cnt++;
                    if(q[0] == m)
                        break;
                }else {
                    que.offer(q);
                }
            }
            System.out.println(cnt);
        }
        br.close();
    }
}

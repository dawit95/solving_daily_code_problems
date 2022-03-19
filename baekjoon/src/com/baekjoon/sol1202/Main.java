package com.baekjoon.sol1202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int n = Integer.parseInt(input[0]), k = Integer.parseInt(input[1]);
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            input = br.readLine().trim().split(" ");
            arr[i][0] = Integer.parseInt(input[0]);
            arr[i][1] = Integer.parseInt(input[1]);
        }
        int[] bags = new int[k];
        for (int i = 0; i < k; i++) {
            bags[i] = Integer.parseInt(br.readLine().trim());
        }
        br.close();

        Arrays.sort(arr, (o1, o2) -> o2[0] == o1[0]?Integer.compare(o2[1],o1[1]):Integer.compare(o1[0], o2[0]));
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < k; i++) {
            // 현재 가방의 무게보다 작거나 같은 보석을 모두 우선순위 큐에 넣음.
            while (j < n && arr[j][0] <= bags[i]) {
                pq.offer(arr[j++][1]);
            }

            // 우선순위 큐에 있는 요소를 하나 빼서 가방에 넣음.
            // 이 때, 우선순위 큐는 내림차순 정렬이 되어있으므로
            // 첫 번째 요소는 가장 큰 가격을 의미함.
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}

package com.baekjoon.sol5014;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-04
 * Description : BaekJoon Problem 5014
 */
public class Main {
    static int[] arr;
    static int F, S, G, U, D;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //F, S, G, U, D
        int F = sc.nextInt();
        int S = sc.nextInt();
        int G = sc.nextInt();
        int U = sc.nextInt();
        int D = sc.nextInt();
        sc.nextLine();
        sc.close();
        arr = new int[F + 1];

        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[S] = 0;

        if (S != G) {
            Queue<Integer> q = new LinkedList<>();
            q.offer(S);
            while (!q.isEmpty()) {
                int idx = q.poll();

                if (idx + U <= F && arr[idx + U] > arr[idx] + 1) {
                    arr[idx + U] = arr[idx] + 1;
                    q.offer(idx + U);
                }
                if (idx - D > 0 && arr[idx - D] > arr[idx] + 1) {
                    arr[idx - D] = arr[idx] + 1;
                    q.offer(idx - D);
                }
            }
            System.out.println(arr[G] == Integer.MAX_VALUE ? "use the stairs" : arr[G]);
        } else {
            System.out.println(0);
        }
    }
}

package com.baekjoon.sol11724;

import java.util.HashSet;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-06
 * Description :
 */
public class Main {
    static int[] parents;
    static int n,m;

    static void make() { // 크기가 1인 단위 집합을 만든다.
        parents = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            parents[i] = i;
        }
    }

    static int findSet(int a) {
        if (parents[a] == a)
            return a;
//		return findSet(parents[a]);	// path compression 전
        return parents[a] = findSet(parents[a]); // path compression 후
    }

    // 합쳐졌는지 확인하기 위한 리턴값
    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);

        if (aRoot == bRoot) {
            return false;
        }

        // bRoot의 부모를 aRoot로 만들어 한 조직으로 연합
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        make();
        int a,b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();
            union(a,b);
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            set.add(findSet(i));
        }
        System.out.println(set.size());
    }
}

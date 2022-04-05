package com.baekjoon.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * FileName : Kruskal
 * Author : David
 * Date : 2022-03-23
 * Description :
 */
public class MST_Kruskal {

    static class Edge implements Comparable<Edge>{
        int from,to,weight;

        public Edge(int from, int to, int weight) {
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
//			return this.weight, o.weight;
            return Integer.compare(this.weight, o.weight);
        }

    }

    static int V,E;
    static int[] parents;
    static Edge[] edgeList;

    static void make() { // 크기가 1인 단위 집합을 만든다.
        for (int i = 0; i < V; i++) {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine().trim(), " ");
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        parents = new int[V];
        edgeList = new Edge[E];

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine().trim(), " ");
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList[i] = new Edge(from, to, weight);
        }//간선리스트

        //1.간선리스트 가중치 기준으로 오름차순 정렬 cf_comparable정의했기때문에 걍 sort
        Arrays.sort(edgeList);

        make();
        int result = 0;	// 선택된 가중치 합.
        int count = 0;	// 선택한 간선의 수.

        for (Edge edge : edgeList) {
            //union결과가 true이면 서로 다른 집합으로 합칠수 있음.
            if(union(edge.from, edge.to)) {
                result += edge.weight;
                if(++count == V-1) break;
            }
        }

        System.out.println(result);
    }
}

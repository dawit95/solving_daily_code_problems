package com.programmers.level3;

import java.util.Arrays;
import java.util.Comparator;

/**
 * FileName : 섬연결하기
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class 섬연결하기 {


    static int[] parent;

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        //init
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt(o -> o[2]));

        for (int[] target : costs) {
            if (union(target[0], target[1])) {
                answer += target[2];
            }
        }

        return answer;
    }

    private static boolean union(int a, int b) {
        if (find(a) == find(b)) return false;
        else {
            parent[find(a)] = find(b);
            return true;
        }
    }

    public static int find(int a) {
        if (a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    //    static int[] parent ;
    public static int solution2(int n, int[][] costs) {
        int answer = 0;
        parent = new int[n];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
        for (int[] cost : costs) {
            if (find(cost[0]) != find(cost[1])) {
                parent[find(cost[0])] = find(cost[1]);
                answer += cost[2];
            }
        }
        return answer;
    }

//    public static int find(int a) {
//        if(a==parent[a]) return a;
//        parent[a] = find(parent[a]);
//        return parent[a];
//    }
}

package com.etc.sol220319.test4;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-19
 * Description :
 */
public class Main {
    public static void main(String[] args) {

    }
    static HashSet<int[]> set;
    public static int[] solution(int n, int m, int k, int[][] records) {
        int[] answer = {};
        set = new HashSet<>();

        LinkedList<Integer> list = new LinkedList<>();
        list.add(records[0][0]);
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < list.size(); j++) {
                if(list.get(j) > records[0][i]){
                    list.addFirst(records[0][i]);
                    break;
                }
                if(j == list.size()-1 && list.get(j) < records[0][i]){
                    list.add(records[0][i]);
                }
            }
        }

        // 후보찾기
        dfs(0,k,m, list, new int[k]);

        return answer;
    }

    private static void dfs(int i, int k, int m, LinkedList<Integer> list, int[] ints) {
    }

}

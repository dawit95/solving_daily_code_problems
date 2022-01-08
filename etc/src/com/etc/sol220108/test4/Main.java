package com.etc.sol220108.test4;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {

    }

    public int solution(int[][] tower, int k) {
        int answer = 0;
        ArrayList<Integer>[] lists = new ArrayList[11];
        for (int i = 1; i < 11; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < tower.length; i++) {
            lists[tower[i][1]].add(tower[i][0]);
        }
        for (int i = 1; i < 11; i++) {
            if(lists[i].size()==0) continue;
            Collections.sort(lists[i]);
            answer++;
            for (int j = 1; j < lists[i].size(); j++) {
                if (Math.abs(lists[i].get(j - 1) - lists[i].get(j)) > k) {
                    answer++;
                }
            }
        }
        return answer;
    }
}

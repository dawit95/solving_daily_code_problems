package com.etc.sol220324.test6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-24
 * Description : 리뷰
 */
public class Main {
    public static void main(String[] args) {

    }

    HashMap<Character, ArrayList<String>> combi;
    HashMap<Character, ArrayList<Character>> map;
    ArrayList<String> answer;

    public String solution(String[] prj, int n, int k) {
        answer = new ArrayList<>();
        int[][] arr = new int[26][26];
        for (int i = 0; i < prj.length; i++) {
            String target = prj[i];
            int len = target.length();
            for (int j = 0; j < len; j++) {
                for (int l = 0; l < len; l++) {
                    if (j == l) continue;
                    arr[target.charAt(j) - 'A'][target.charAt(l) - 'A'] = 1;
                }
            }
        }

        map = new HashMap<>();
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if (arr[i][j] == 1) {
                    char to = (char) (i + 'A');
                    char from = (char) (j + 'A');
                    if (map.containsKey(to)) {
                        map.get(to).add(from);
                    } else {
                        ArrayList<Character> tmp = new ArrayList<>();
                        tmp.add(from);
                        map.put(to, tmp);
                    }
                }
            }
        }

        //각 사람마다 만들수 있는 조합 모두 구하기
        combi = new HashMap<>();
        for (Character target : map.keySet()) {
            ArrayList<Character> list = map.get(target);
            combi.put(target, new ArrayList<>());
            combination(0, 0, list.size(), n, new char[list.size()], list, target);
        }

        //A부터 Z순으로 combi => candidate
        int[] tmp = new int[26];
        for (Character target : combi.keySet()) {
            tmp[target - 'A'] = 1;
        }
        ArrayList<String>[] candidate = new ArrayList[combi.size()];
        int idx = 0;
        for (int i = 0; i < 26; i++) {
            char key = (char) (i + 'A');
            if (tmp[i] == 1)
                candidate[idx++] = combi.get(key);
        }

        //순열로 각 사람마다 k번이 넘지 않는 조합 찾기
        int[] set = new int[26];
        permutation(0, set, new StringBuilder(), candidate.length, candidate, k);
        Collections.sort(answer);
        return answer.get(0);
    }

    private void permutation(int idx, int[] set, StringBuilder sb, int n, ArrayList<String>[] candidate, int k) {
        if (idx == n) {
            answer.add(sb.toString());
            return;
        }


        int[] newSet = new int[26];
        boolean flag;
        for (int i = 0; i < candidate[idx].size(); i++) {
            System.arraycopy(set, 0, newSet, 0, 26);
            String str = candidate[idx].get(i);
            flag = false;
            for (int j = 0; j < str.length(); j++) {
                newSet['A' - str.charAt(j)]++;
                if (newSet['A' - str.charAt(j)] > k) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                continue;
            }
            sb.append(str);
            permutation(idx + 1, newSet, sb, n, candidate, k);
            sb.setLength(sb.length() - str.length());
        }
    }

    private void combination(int idx, int start, int n, int m, char[] arr, ArrayList<Character> list, Character target) {
        if (idx == m) {
            StringBuilder sb = new StringBuilder();
            for (char element : arr) {
                sb.append(element);
            }
            combi.get(target).add(sb.toString());
            return;
        }

        for (int i = start; i < n; i++) {
            arr[idx] = list.get(i);
            combination(idx + 1, i + 1, n, m, arr, list, target);
        }
    }

}

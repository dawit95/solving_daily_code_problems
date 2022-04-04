package com.etc.sol220326.test3451;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-26
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        String[] sentences = {"line in line", "LINE", "in lion"};
        int n = 5;
        System.out.println(solution(sentences, n));
    }

    public static int solution(String[] sentences, int n) {
        int answer = 0, cnt = 0, targetLen = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0, len = sentences.length; i < len; i++) {
            HashSet<Character> set = new HashSet<>();
            String target = sentences[i];
            cnt = 0;
            targetLen = target.length();
            boolean flag = false, blank = false;
            String small = target.toLowerCase();
            for (int j = 0; j < targetLen; j++) {
                set.add(small.charAt(j));
                if (set.size() > n + 1) {
                    cnt = -1;
                    break;
                }
                if (target.charAt(j) < 97 && ' ' != target.charAt(j)) {
                    cnt++;
                    flag = true;
                }
                if (' ' == target.charAt(j)) blank = true;
            }

            if (flag && set.size() == n + 1) continue;
            if (cnt == -1) continue;

            // make key
            int setSize = set.size();
            char[] arr = new char[n + 1];
            int idx = 0;
            for (Character c : set) {
                arr[idx++] = c;
            }
            if (flag) {
                arr[idx++] = 'S';
            }
            if(blank){
                arr[idx++] = 'B';
            }
            Arrays.sort(arr);

//            int size = blank ? n + 1 - setSize : n - setSize;
//            combi(0, 0, size, arr, set, map, targetLen + cnt);
        }


        for (String key : map.keySet()) {

            answer = Math.max(answer, map.get(key));
        }
        return answer;
    }

    private static void combi(int idx, int start, int m, char[] arr, HashSet<Character> set, HashMap<String, Integer> map, int value) {
        if (idx == m) {
            char[] tmp = new char[arr.length];
            System.arraycopy(arr,0,tmp,0,arr.length);
            Arrays.sort(tmp);
            String key = new String(tmp);
                map.put(key, value);
//            if (map.containsKey(key)) {
//                map.put(key, map.get(key) + value);
//            } else {
//            }
            return;
        }

        for (int i = start; i < 26; i++) {
            char tmp = (char) (i + 'a');
            if (set.contains(tmp)) continue;
            arr[idx] = tmp;
            combi(idx + 1, i + 1, m, arr, set, map, value);
            if(i==25){
                arr[idx] = 'S';
                combi(idx + 1, i + 1, m, arr, set, map, value);
            }
        }
    }

}

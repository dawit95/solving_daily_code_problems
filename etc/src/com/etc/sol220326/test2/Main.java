package com.etc.sol220326.test2;

import java.util.Arrays;
import java.util.Calendar;
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
        String[] sentences = {"line in line", "LINE", "in lion", "lin in", "lin in"};
        int n = 5;
        System.out.println(solution(sentences, n));
    }

    public static int solution(String[] sentences, int n) {
        int answer = 0, cnt = 0, targetLen = 0;
        HashMap<HashSet<Character>, Integer> map = new HashMap<>();
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
            if (flag) {
                set.add('S');
            }

            if (map.containsKey(set)) {
                map.put(set, map.get(set) + targetLen + cnt);
            } else {
                map.put(set, targetLen + cnt);
            }
        }

        for (HashSet key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }
//        int flag = map.size()+1;
//        while (flag!=map.size()){
//            map = makeMap(map,n+1);
//            flag = map.size();
//        }
        map = makeMap(map, n + 1);
        for (HashSet key : map.keySet()) {
            answer = Math.max(answer, map.get(key));
        }
        return answer;
    }

    private static HashMap<HashSet<Character>, Integer> makeMap(HashMap<HashSet<Character>, Integer> map, int n) {
        HashMap<HashSet<Character>, Integer> newMap = new HashMap<>();
        for (HashSet<Character> key : map.keySet()) {
            for (HashSet<Character> target : map.keySet()) {
                if (key.equals(target)) continue;
                int overlap = 0;
                for (int i = 0; i < 26; i++) {
                    char c = (char) ('a' + i);
                    if (key.contains(c) && target.contains(c))
                        overlap++;
                }
                if (key.contains(' ') && target.contains(' ')) overlap++;
                if (key.contains('S') && target.contains('S')) overlap++;

                int size = key.size() + target.size() - overlap;
                if (n >= size) {
                    HashSet<Character> set = new HashSet<>();
                    for (Character kc : key) {
                        set.add(kc);
                    }
                    for (Character tc : target) {
                        set.add(tc);
                    }
                    newMap.put(set, map.get(key) + map.get(target));
                }
            }
        }
        return newMap;
    }


}

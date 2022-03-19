package com.baekjoon.sol1339;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int len = str.length();
            for (int j = 0; j < len; j++) {
                int value = (int) Math.pow(10,len-j-1);
                if(map.containsKey(str.charAt(j))){
                    map.put(str.charAt(j), map.get(str.charAt(j)) + value);
                }else {
                    map.put(str.charAt(j), value);
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (Character key : map.keySet()) {
            list.add(map.get(key));
        }

        list.sort(Collections.reverseOrder());

        int ans = 0;
        int num = 9;
        for (int i = 0; i < list.size(); i++) {
            ans += list.get(i) * num--;
        }
        System.out.println(ans);
    }
}

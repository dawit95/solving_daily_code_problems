package com.etc.sol220319.test1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-19
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        String[] str = {"pencil", "cilicon", "contrabase", "picturelist"};
        String[] result = solution(str);
        System.out.println(result[0]);
    }

    public static String[] solution(String[] goods) {
        int len = goods.length;
        String[] answer = new String[len];
        HashSet<String> outSet = new HashSet<>();
        for (int i = 0; i < len; i++) {
            //길이
            for (int size = 1, n = goods[i].length(); size <= n; size++) {
                StringBuilder sb = new StringBuilder();

                //size마다 확인
                for (int j = 0; j < n - size + 1; j++) {
                    String target = goods[i].substring(j, j + size);
                    if (outSet.contains(target)) continue;
                    //target이 유효한지 확인
                    boolean check = true;
                    for (int idx = 0; idx < goods.length; idx++) {
                        if (idx == i) continue;
                        if (goods[idx].contains(target)) {
                            check = false;
                            break;
                        }
                    }
                    if (check) {
                        sb.append(target).append(" ");
                    }
                    outSet.add(target);

                }

                if (sb.length() > 0) {
//                    sb.setLength(sb.length()-1);
//                    answer[i] = sb.toString();
                    String[] tmp = sb.toString().trim().split(" ");
                    Arrays.sort(tmp);
                    sb = new StringBuilder();
                    for (int j = 0; j < tmp.length; j++) {
                        sb.append(tmp[j]).append(" ");
                    }
                    sb.setLength(sb.length() - 1);
                    answer[i] = sb.toString();
                    break;
                }else{
                    answer[i] = "None";
                }
            }
        }
        return answer;
    }
}

package com.etc.sol220406.test1;

import java.util.Arrays;
import java.util.HashSet;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-06
 * Description :
 */
public class Main {
    public static void main(String[] args) {

//        int[] arr = {1,2,3,4};
//        do {
//            System.out.println(Arrays.toString(arr));
//        } while (np(arr, arr.length));

        int[][] dice = {{1, 6, 2, 5, 3, 4},{9, 9, 1, 0, 7, 8}};
        System.out.println(solution(dice));
    }


    public static int solution(int[][] dice) {
        int[] result = new int[10];
        int answer = 0;
        for (int i = 0; i < dice.length; i++) {
            int[] arr = new int[10];
            for (int j = 0; j < 6; j++) {
                if(arr[dice[i][j]] == 0){
                    arr[dice[i][j]] ++;
                }
            }
            for (int j = 0; j < 10; j++) {
                result[j] += arr[j];
            }
        }

        int ans = 0;
        boolean flag = true;
        while (ans<10000 && flag){
            ans++;
            int[] number = new int[10];
            String tmp = ans+"";
            char[] charArr = tmp.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                number[charArr[i]-'0']++;
            }

            for (int i = 0; i < 10; i++) {
                if(result[i] < number[i]){
                    flag = false;
                    break;
                }
            }
        }

        return ans;
    }







//    static boolean[] isSelected;
//    static HashSet<Integer> set;

//    public static int solution(int[][] dice) {
//        set = new HashSet<>();
//        int len = dice.length;
//        isSelected = new boolean[len];
//        subset(0,0,len,dice);
//
//        int ans = 1;
//        while (set.contains(ans)){
//            ans++;
//        }
//        return ans;
//    }

//    private static void subset(int toSelect, int total, int len, int[][] dice) {
//
//        if (toSelect == len) {
//            int[] arr = new int[total];
//            int idx = 0;
//            for (int i = 0; i < len; i++) {
//                if(isSelected[i]) {
//                    arr[idx]  = i;
//                    idx++;
//                }
//            }
//
//            StringBuilder sb = new StringBuilder();
//            do {
//                combi(0,total,arr,dice, new int[total]);
//            } while (np(arr, total));
//
//            return;
//        }
//
//        isSelected[toSelect] = true;
//        subset(toSelect + 1, total +1, len, dice);
//        isSelected[toSelect] = false;
//        subset(toSelect + 1, total, len, dice);
//    }
//
//    private static void combi(int idx, int total, int[] arr, int[][] dice, int[] result) {
//        if(idx == total){
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < total; i++) {
//                sb.append(result[i]);
//            }
//            System.out.println(sb.toString());
//            set.add(Integer.parseInt(sb.toString()));
//            return;
//        }
//
//        for (int i = 0; i < 6; i++) {
//            result[idx] = dice[arr[idx]][i];
//            combi(idx +1, total,arr,dice,result);
//        }
//    }
//
//
//    private static boolean np(int[] arr, int N) {
//        int i = N - 1;
//        while (i > 0 && arr[i - 1] >= arr[i])
//            --i;
//        if (i == 0)
//            return false;
//
//        int j = N - 1;
//        while (arr[i - 1] >= arr[j])
//            --j;
//        swap(arr, i - 1, j);
//
//        int k = N - 1;
//        while (i < k) {
//            swap(arr, i++, k--);
//        }
//        return true;
//    }
//    private static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
}

package com.etc.sol220312.test1;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        int money = 4578;
        int[] costs = {1, 4, 99, 35, 50, 1000};
        int answer = 0;
        int[] coin = {1, 5, 10, 50, 100, 500};
        int[][] arr = new int[6][6];
        for (int i = 5; i >= 0; i--) {
            int pivot = coin[i];
            for (int j = 0; j <= i; j++) {
                arr[i][j] = costs[j] * (pivot / coin[j]);
            }
        }
        // coin[i] 값, 생산값 = value;
        for (int i = 5; i >= 0; i--) {
            int value = choice(arr, i);
            answer += money / coin[i] * value;
            money %= coin[i];
        }
        System.out.println(answer);
    }

    private static int choice(int[][] arr, int pivot) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j <= pivot; j++) {
            min = Math.min(arr[pivot][j], min);
        }
        return min;
    }

    public int solution(int money, int[] costs) {
        int answer = 0;
        int[] coin = {1, 5, 10, 50, 100, 500};
        int[][] arr = new int[6][6];
        for (int i = 5; i >= 0; i--) {
            int pivot = coin[i];
            for (int j = 0; j < i; j++) {
                arr[i][j] = costs[j] * (pivot / coin[j]);
            }
        }
        return answer;
    }

//    private static void combi(int idx, int start) {
//        if (idx == m) {
//            for (int i : arr) {
//                sb.append(i).append(" ");
//            }
//            sb.append("\n");
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            arr[idx] = i + 1;
//            combi(idx + 1, i + 1);
//        }
//    }
}

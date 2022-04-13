package com.etc.sol220406.test3;

import java.util.Arrays;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-06
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        int num = 8;
//        int[] cards = {3, 5, 7};
//        int[] cards = {1, 2, 5};
        int[] cards = {1, 4, 6};
        System.out.println(solution(num, cards));
    }

    static int target;
    public static int solution(int num, int[] cards) {
        Arrays.sort(cards);

        int ans = Integer.MAX_VALUE;
        for (int i = 1,size = cards.length; i < size; i++) {
            int[] arr = new int[i];
            System.arraycopy(cards,0,arr,0,i);
            ans = Math.min(ans,set(num,arr));
        }

        return ans;
    }

    private static int set(int num, int[] cards) {
        int len = cards.length;
        int[] arr = new int[len];
        int idx = len-1;
        target = num;

        while (!find(0, idx, arr, cards)){
            for (int i = 0; i <len ; i++) {
                if(arr[i]!=0) {
                    arr[i]--;
                    target += cards[i];
                    idx = i-1;
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static boolean find(int min, int idx, int[] arr, int[] cards) {
        if (target == 0) return true;

        for (int i = idx; i >= min; i--) {
            arr[i] += target/cards[i];
            target %= cards[i];
            if(target ==0) {
                return true;
            }
        }

        return false;
    }

    private static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


//    public static int solution(int num, int[] cards) {
//        answer = Integer.MAX_VALUE;
//        for (int i = 0; i < cards.length; i++) {
//            if(cards[i] == num) return 1;
//        }
////        combi(0,0,num,cards);
//        int cnt=num/cards[cards.length-1];
//        while (answer == Integer.MAX_VALUE){
//            combi(cnt, 0,0,num,cards);
//            cnt++;
//        }
//        return answer;
//    }
//
//    private static void combi(int limit, int size, int sum, int num, int[] cards) {
//        if(limit < size) return;
//
//        if (limit == size && sum == num) {
//            answer = Math.min(answer,size);
//            return;
//        }
//        for (int i = cards.length-1; i > -1; i--) {
//            if (sum + cards[i] <= num)
//                combi(limit,size + 1, sum + cards[i], num, cards);
//        }
//    }
//
//    private static void combi(int size, int sum, int num, int[] cards) {
//        if (sum == num) {
//            answer = Math.min(answer,size);
//            return;
//        }
//        for (int i = cards.length-1; i > -1; i--) {
//            if (sum + cards[i] <= num)
//                combi(size + 1, sum + cards[i], num, cards);
//        }
//    }

}

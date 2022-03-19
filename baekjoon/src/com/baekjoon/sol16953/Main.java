package com.baekjoon.sol16953;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-17
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        sc.close();
        Queue<int[]> q = new LinkedList<>();
        HashSet<Integer> set = new HashSet<>();
        q.offer(new int[]{1,b});
        set.add(b);
        int ans = -1;
        while (!q.isEmpty()){
            int[] now = q.poll();
            if(now[1] == a){
                ans = now[0];
                break;
            }

            if(now[1]%2==0 && !set.contains(now[1]/2)){
                set.add(now[1]/2);
                q.offer(new int[]{now[0]+1,now[1]/2});
            }
            if(now[1] > 9 && now[1]%10==1 && !set.contains(now[1]/10)){
                set.add(now[1]/10);
                q.offer(new int[]{now[0]+1,now[1]/10});
            }
        }
        System.out.println(ans);
    }
}

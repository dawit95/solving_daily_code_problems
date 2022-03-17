package com.etc.sol220312.house2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.isEmpty();
        list.add(1);
        list.add(2);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));
        Queue<Integer> q = new LinkedList<>();
        q.poll();
    }
}

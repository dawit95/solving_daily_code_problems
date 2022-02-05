package com.baekjoon.sol220205;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String[] input = sc.nextLine().trim().split(" ");
            String s = input[0];
            String t = input[1];
            int idxS=0, idxT=0;
            while (idxS!=s.length() && idxT!=t.length()){
                if(s.charAt(idxS)==t.charAt(idxT)){
                    idxS++;
                    idxT++;
                }else{

                }
            }

        }
    }
}

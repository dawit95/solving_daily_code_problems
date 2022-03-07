package com.etc.sol220215.test1;

import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

    }

    public int solution(long n) {
        int answer = 0;
        String target = String.valueOf(n);
        HashSet<Long> set = new HashSet<>();
        long tmp = 0L;
        for (int i = 0; i < target.length(); i++) {
            tmp = Long.parseLong(String.valueOf(target.charAt(i)));
            if (tmp != 0 && !set.contains(tmp)) {
                if(n%tmp == 0){
                    answer++;
                }
                //add set
                set.add(tmp);
                if(set.size()==9) break;
            }
        }

        return answer;
    }
}

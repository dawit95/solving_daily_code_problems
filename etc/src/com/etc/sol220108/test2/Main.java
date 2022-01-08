package com.etc.sol220108.test2;

import java.util.*;


public class Main {
    public static void main(String[] args) {
//        String[] arr1 = {"()", "(()", ")()", "()"};
//        String[] arr2 = {")()", "()", "(()"};
        String[] arr1 = new String[100000];
        String[] arr2 = new String[100000];
        for (int i = 0; i < 100000; i++) {
            arr1[i] = "(((((((((";
            arr2[i] = ")))))))))";
        }
        System.out.println(solution(arr1, arr2));
    }

//    static boolean[] boo1, boo2;

    static HashMap<Integer, Integer> map1, map2;

    public static long solution(String[] arr1, String[] arr2) {
        long answer = 0;
        map1 = new HashMap<>();
        map2 = new HashMap<>();
        int one = 0, two = 0;
        for (int i = 0; i < arr1.length; i++) {
            if (check(1, arr1[i]))
                one++;

        }
        for (int i = 0; i < arr2.length; i++) {
            if (check(2, arr2[i]))
                two++;

        }

        answer += one * two;
        Set<Integer> keySet = map1.keySet();

        for (Integer num : keySet) {
            if (map2.containsKey(num)) {
                answer += map1.get(num) * map2.get(num);
            }
        }

        return answer;
    }

    private static boolean check(int type, String s) {
        if (s.equals("")) return true;
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else {
                if (stack.isEmpty()) {
                    int a = 0;
                    for (int j = 0; j < s.length(); j++) {
                        a += s.charAt(j) == ')' ? 1 : -1;
                    }
                    if(type==2){
                        if(a<=0) return false;
                        if (map2.containsKey(a)) {
                            map2.put(a, map2.get(a) + 1);
                        } else {
                            map2.put(a, 1);
                        }
                    }
                    return false;
                }

                stack.pop();
            }
        }
        if (stack.isEmpty())
            return true;
        else {
            if (type == 1) {
                int a = stack.size();
                if (map1.containsKey(a)) {
                    map1.put(a, map1.get(a) + 1);
                } else {
                    map1.put(a, 1);
                }
            }
            return false;
        }
    }

//    private static String arrChange(String s) {
//        if (s.equals("")) return "";
//        Stack<Character> stack = new Stack<>();
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == '(') {
//                stack.push('(');
//            } else {
//                if (stack.isEmpty() || stack.peek() != '(') {
//                    stack.push(')');
//                } else {
//                    stack.pop();
//                }
//            }
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < stack.size(); i++) {
//            sb.append(stack.pop());
//        }
//        return sb.reverse().toString();
//    }


}

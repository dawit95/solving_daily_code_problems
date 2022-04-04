package com.etc.sol220326.test1;

import java.util.regex.Pattern;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-26
 * Description :
 */
public class Main {
    public static void main(String[] args) {
//        String str = "team_name : db application_name : dbtest error_level : info message : test";
//        String[] test = str.trim().split(" ");
//        System.out.println(test.length);
//        for (int j = 0; j < 12; j+=3) {
//            System.out.println(j);
//            System.out.println(test[j]);
//        }
//        String[] logs = {"team_name : db application_name : dbtest error_level : info message : test", "team_name : test application_name : I DONT CARE error_level : error message : x", "team_name : ThisIsJustForTest application_name : TestAndTestAndTestAndTest error_level : test message : IAlwaysTestingAndIWillTestForever", "team_name : oberervability application_name : LogViewer error_level : error"};
        String[] logs = {"team_name : MyTeam application_name : YourApp error_level : info messag : IndexOutOfRange", "no such file or directory", "team_name : recommend application_name : recommend error_level : info message : RecommendSucces11", "team_name : recommend application_name : recommend error_level : info message : Success!", "   team_name : db application_name : dbtest error_level : info message : test", "team_name     : db application_name : dbtest error_level : info message : test", "team_name : TeamTest application_name : TestApplication error_level : info message : ThereIsNoError"};
        System.out.println(solution(logs));
    }

    public static int solution(String[] logs) {
        int answer = 0;
        String pattern = "^[a-zA-Z]*$";
        String[] type = {"team_name", "application_name", "error_level", "message"};
        for (int i = 0, len = logs.length; i < len; i++) {

            if (logs[i].length() > 100) {
                answer++;
                continue;
            }

            String[] check = logs[i].split(" ");
            if (check.length != 12) {
                answer++;
                continue;
            }

            int tmp = answer;
            //형식
            for (int j = 0; j < 12; j += 3) {
                if (!type[j / 3].equals(check[j])) {
                    answer++;
                    break;
                }
            }
            if (tmp != answer) continue;

            //알파벳만
            for (int j = 2; j < 12; j += 3) {
                if (!Pattern.matches(pattern, check[j])) {
                    answer++;
                    break;
                }
            }
            if (tmp != answer) continue;
        }
        return answer;
    }

}

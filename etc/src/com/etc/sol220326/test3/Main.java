package com.etc.sol220326.test3;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-26
 * Description :
 */
public class Main {
    public static void main(String[] args) {
        String[] r = {"development","marketing","hometask"};
        String[] t = {"recruitment","education","officetask"};
        String[] e = {"1 development hometask","1 recruitment marketing","2 hometask","2 development marketing hometask","3 marketing","3 officetask","3 development"};
        System.out.println(solution(3,r,t,e));
    }

    public static int[] solution(int num_teams, String[] remote_tasks, String[] office_tasks, String[] employees) {
        ArrayList<Integer> answer = new ArrayList<>();
        HashSet<String> remote = new HashSet<>();
        for (String s : remote_tasks) {
            remote.add(s);
        }
        HashSet<String> office = new HashSet<>();
        for (String s : office_tasks) {
            office.add(s);
        }

        int[][] teamUser = new int[num_teams+1][2];
        for (int i = 0,len =employees.length; i < len; i++) {
            int[] value = new int[2];
            value[0] = i+1;
            String[] target = employees[i].split(" ");
            int teamNum = Integer.parseInt(target[0]);
            for (int j = 1; j < target.length; j++) {
                if(office.contains(target[j])){
                    value[1]=1;
                    break;
                }
            }

            //최소 한명
            if(teamUser[teamNum][0] == 0){
                teamUser[teamNum] = value;
                continue;
            }else{
                //내가 재택이 불가능 && 기존에 있는 사람이 재택 가능인 경우
                if(value[1]==1 && teamUser[teamNum][1] == 0){
                    answer.add(teamUser[teamNum][0]);
                    teamUser[teamNum] = value;
                    continue;
                }
            }

            answer.add(value[0]);
        }
        
        
        int[] ans = new int[answer.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}

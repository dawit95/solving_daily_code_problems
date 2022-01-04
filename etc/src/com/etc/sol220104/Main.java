package com.etc.sol220104;

import java.util.HashSet;

public class Main {

    static int ans;
    static String[][] schedule = {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};

    public static void main(String[] args) {
        ans = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                schedule[i][j] = schedule[i][j].replace(":","");
            }
        }
        okPermu(new int[4], 0);

        System.out.println(ans);
    }

    private static void okPermu(int[] arr, int idx) {
        if (idx == 5) {
            if (check(arr)) {
                ans++;
            }
            return;
        }
        for (int i = 1; i <= 4; i++) {
            arr[idx] = i;
            okPermu(arr, idx + 1);
        }
    }

    private static boolean check(int[] arr) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            String str = schedule[i][arr[i]];
            if(str.length()>10){
                String str1 = str.substring(0,8);
                String str2 = str.substring(9,16);
                for (int j = 0; j < 3; j++) {
                    if (set.contains(str1))
                        return false;
                    set.add(str1);
                    str1 = setting(str1);
                    if (set.contains(str2))
                        return false;
                    set.add(str2);
                    str2 = setting(str2);
                }
            }else{
                for (int j = 0; j < 6; j++) {
                    if (set.contains(str))
                        return false;
                    set.add(str);
                    str = setting(str);
                }
            }
        }
        return true;
    }

    private static String setting(String str) {
        StringBuilder sb = new StringBuilder(str.substring(0,3));
        int time = Integer.parseInt(str.substring(3,7));
        sb.append(time+30);
        return sb.toString();
    }
}

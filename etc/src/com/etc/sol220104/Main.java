package com.etc.sol220104;

import java.util.HashSet;

public class Main {

    static int ans;
    static String[][] schedule = {{"MO 12:00 WE 14:30", "MO 12:00", "MO 15:00", "MO 18:00"}, {"TU 09:00", "TU 10:00", "TU 15:00", "TU 18:00"}, {"WE 09:00", "WE 12:00", "WE 15:00", "WE 18:00"}, {"TH 09:30", "TH 11:30", "TH 15:00", "TH 18:00"}, {"FR 15:00", "FR 15:00", "FR 15:00", "FR 15:00"}};

    public static void main(String[] args) {
        ans = 0;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4; j++) {
                schedule[i][j] = schedule[i][j].replace(":", "");
            }
        }
        HashSet<String> set = new HashSet<>();
        okPermu(set, new int[5], 0);

        System.out.println(ans);
    }

    private static void okPermu(HashSet<String> set, int[] arr, int idx) {
        if (idx == 5) {
            ans++;
            return;
        }
        for (int i = 0; i < 4; i++) {
            String str = schedule[idx][i];
            HashSet<String> tmpSet = new HashSet<>(set);
            boolean flag = true;
            if (str.length() > 10) {
                String str1 = str.substring(0, 7);
                String str2 = str.substring(8, 15);
                for (int j = 0; j < 3; j++) {
                    if (tmpSet.contains(str1)) {
                        flag = false;
                        break;
                    }
                    tmpSet.add(str1);
                    str1 = setting(str1);
                    if (tmpSet.contains(str2)) {
                        flag = false;
                        break;
                    }
                    tmpSet.add(str2);
                    str2 = setting(str2);
                }
            } else {
                for (int j = 0; j < 6; j++) {
                    if (tmpSet.contains(str)) {
                        flag = false;
                        break;
                    }
                    tmpSet.add(str);
                    str = setting(str);
                }
            }
            if (flag)
                okPermu(tmpSet, arr, idx + 1);
        }
    }
    private static String setting(String str) {
        StringBuilder sb = new StringBuilder(str.substring(0, 3));
        String tmp = str.substring(3, 7);
        int time = Integer.parseInt(tmp);
        time += time % 100 == 0 ? 30 : 100;
        if (time < 1000)
            sb.append(0);
        sb.append(time);
        return sb.toString();
    }
}

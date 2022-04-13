package com.etc.sol220412.codility2;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-04-12
 * Description :
 */
public class Main {
    public static void main(String[] args) {

    }

    public int solution(int N) {
        int ans = -1;
        String str = Integer.toBinaryString(N);
        char[] charArr = str.toCharArray();
        int len = charArr.length;
        int cnt = 0;
        for (int idx = 0; idx < len; idx++) {
            if (charArr[idx] == '1' && idx + 1 < len && charArr[idx + 1] == '0') {
                idx++;
                while (idx < len && charArr[idx] == '0') {
                    cnt++;
                    idx++;
                }
                if (idx < len && charArr[idx] == 1) {
                    ans = Math.max(cnt, ans);
                }
                cnt = 0;
            }
        }

        return ans;
    }
}

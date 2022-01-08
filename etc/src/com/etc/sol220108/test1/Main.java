package com.etc.sol220108.test1;

public class Main {
    public static void main(String[] args) {
        int[][] fees = {{200, 910, 93}, {400, 1600, 188}, {655, 7300, 281},{0, 15372, 435}};
        int usage = 450;
        System.out.println(solution(fees, usage));
    }

    public static int solution(int[][] fees, int usage) {
        int answer = 0;
        int len = fees.length;

        for (int i = 0; i < len; i++) {
            //a와 비교
            if (usage <= fees[i][0] || fees[i][0] == 0) {
                answer += fees[i][1];

                // 전력량 구간 전 요금 정산
                for (int j = 0; j < i; j++) {
                    answer += (j==0?fees[j][0]:fees[j][0]-fees[j-1][0]) * fees[j][2];
                }

                if(i==0){
                    answer += usage * fees[i][2];
                }else{
                    int t = usage-fees[i-1][0];
                    int sd = fees[i][2];
                    answer += (usage-fees[i-1][0]) * fees[i][2];
                }

                break;
            }

        }
        return answer;
    }
}

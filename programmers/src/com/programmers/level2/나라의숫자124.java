package com.programmers.level2;

public class 나라의숫자124 {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        int current = n;

        // 진법 변환할 숫자가 0보다 큰 경우 지속 진행
        while (current > 0) {
            // 만약 N으로 나누었는데 10보다 작다면 해당 숫자를 바로 append
            if (current % 3 < 10) {
                sb.append(current % 3);

                // 만약 N이 10보다 큰 경우, N으로 나누었는데 10 이상이면 A, B등으로 표현하므로 기존 숫자는 10진법이므로 10만큼 빼고 'A'를 더한다.
                // 왜냐면 1~9까지는 숫자로 표기하지만, 10 부터는 'A', 'B' 순서로 나타내기 때문이다.
                // 나머지가 10이라면 'A' + 10이 아니라 'A'로 나타내야 하기 때문
            } else {
                sb.append((char) (current % 3 - 10 + 'A'));
            }
            current /= 3;
        }
        sb = sb.reverse();
        boolean flag = true;
        while (flag) {
            for (int i = 0; i < sb.length(); i++) {
                if (sb.charAt(i) == '0') {
                    switch (sb.charAt(i - 1) - '0') {
                        case 1:
                            sb.replace(i - 1, i + 1, "04");
                            break;
                        case 2:
                            sb.replace(i - 1, i + 1, "14");
                            break;
                        case 4:
                            sb.replace(i - 1, i + 1, "24");
                            break;
                    }
                }
            }
            if (sb.charAt(0) == '0') sb.replace(0, 1, "");
            if(sb.indexOf("0")<0){
                flag = false;
            }
        }
        return sb.toString();
    }
    public String amazingSolution(int n){
        String[] num = {"4","1","2"};
        String answer = "";

        while(n > 0){
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        return answer;
    }
}

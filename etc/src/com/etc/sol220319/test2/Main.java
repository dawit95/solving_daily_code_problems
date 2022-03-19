package com.etc.sol220319.test2;

import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-19
 * Description :
 */
public class Main {
    public static void main(String[] args) {
//        String[] arr = {"1", "2", "4", "3", "3", "4", "1", "5"};
//        String[] processes = {"read 1 3 1 2", "read 2 6 4 7", "write 4 3 3 5 2", "read 5 2 2 5", "write 6 1 3 3 9", "read 9 1 0 7"};

        String[] arr = {"1", "1", "1", "1", "1", "1", "1"};
        String[] processes = {"write 1 12 1 5 8", "read 2 3 0 2", "read 5 5 1 2", "read 7 5 2 5", "write 13 4 0 1 3", "write 19 3 3 5 5", "read 30 4 0 6", "read 32 3 1 5"};

        String[] result = solution(arr, processes);
        System.out.println(result.length);
    }

    private static String read(String[] arr, int start, int end) {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i <= end; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private static void write(String[] arr, int start, int end, int value) {
        for (int j = start; j <= end; j++) {
            arr[j] = String.valueOf(value);
        }
    }

    public static String[] solution(String[] arr, String[] processes) {
        ArrayList<String> answer = new ArrayList<>();
        Queue<Process> que = new LinkedList<>();
        for (int i = 0; i < processes.length; i++) {
            que.offer(new Process(processes[i]));
        }
        String[] tmp = processes[0].split(" ");
        long startTime = Long.parseLong(tmp[1]);
        long pTime = startTime;
        while (!que.isEmpty()) {
            //하나 해결
            Process process = que.poll();
            if(startTime < process.t1){
                pTime += process.t1 - startTime;
                startTime = process.t1;
            }
            if (process.type.equals("read")) {
                answer.add(read(arr, process.start, process.end));
                long endTime = startTime + process.t2;
                //연속 read 해결
                while (!que.isEmpty() && que.peek().type.equals("read") && endTime > que.peek().t1) {
                    process = que.poll();
                    answer.add(read(arr, process.start, process.end));
                    if(process.t1 < startTime){
                        if(startTime + process.t2 > endTime){
                            endTime = startTime + process.t2;
                        }
                    }else{
                        if(process.t1 + process.t2 > endTime){
                            endTime = process.t1 + process.t2;
                        }
                    }
                }
                startTime = endTime;
            } else if (process.type.equals("write")) {
                write(arr, process.start, process.end, process.value);
                startTime += process.t2;
            }

            //write 입력 당기기
            pullWrite((LinkedList<Process>) que, startTime);

        }

        int size = answer.size();
        String[] ans = new String[size+1];
        for (int i = 0; i < size; i++) {
            ans[i] = answer.get(i);
        }
        ans[size] = (startTime-pTime)+"";
        return ans;
    }

    private static void pullWrite(LinkedList<Process> que, long startTime) {
        int idx = 0;
        for (int i = 0; i < que.size(); i++) {
            if(que.get(i).t1>startTime) break;
            if (que.get(i).type.equals("write") && startTime >= que.get(i).t1) {
                Process tm = que.remove(i);
                que.add(idx++,tm);
            }
        }
    }

    static class Process {
        String type;
        long t1;
        long t2;
        int start;
        int end;
        int value;

        public Process(String str) {
            String[] tmp = str.trim().split(" ");
            this.type = tmp[0];
            this.t1 = Long.parseLong(tmp[1]);
            this.t2 = Long.parseLong(tmp[2]);
            this.start = Integer.parseInt(tmp[3]);
            this.end = Integer.parseInt(tmp[4]);
            if (this.type.equals("write")) {
                this.value = Integer.parseInt(tmp[5]);
            }
        }
    }
}

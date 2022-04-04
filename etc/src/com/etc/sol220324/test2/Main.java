package com.etc.sol220324.test2;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-24
 * Description :
 */
public class Main {
    public static void main(String[] args) {

        int[] a = {1,6};
        int[] b = {3,6};
        System.out.println(solution(a,b,1,3));
    }
    public static int solution(int[] a, int[] b, int duration, int distance) {
        int availableALen = (a[1] - a[0] - duration)/2;
        int availableBLen = (b[1] - b[0] - duration)/2;

        if(availableALen + availableBLen < distance)
            return -1;

        int startTime = a[0]>b[0]?b[0]:a[0];
        availableALen += (a[1] - a[0] - duration)%2 == 1?1:0;
        availableBLen += (b[1] - b[0] - duration)%2 == 1?1:0;

        int positionA = 0;
        int positionB = distance;
        while (positionA < positionB){
            if(startTime>=a[0]){
                availableALen--;
                positionA++;
            }
            if(startTime>=b[0]){
                availableBLen--;
                positionB--;
            }
            startTime++;
        }

        if(availableALen < 0 || availableBLen < 0)
            return -1;

        int minTime = a[0]>b[0]?a[0]:b[0];
        return startTime > minTime?startTime:minTime;
    }
}

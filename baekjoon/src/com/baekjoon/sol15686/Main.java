package com.baekjoon.sol15686;

import java.util.*;

/**
 * FileName : Main
 * Author : David
 * Date : 2022-03-23
 * Description :
 */
public class Main {
    static class Point implements Comparable {
        private int r;
        private int c;

        private int value;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }

        public Point(int r, int c, int value) {
            this.r = r;
            this.c = c;
            this.value = value;
        }

        public int getR() {
            return r;
        }

        public int getC() {
            return c;
        }

        public int getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            int result = Integer.hashCode(this.r);
            result = 31 * result + Integer.hashCode(this.c);
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (obj == this) {
                return true;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Point p = (Point) obj;
            return this.r == p.getR() && this.c == p.getC();
        }

        @Override
        public int compareTo(Object o) {
            Point op = (Point) o;
            return Integer.compare(this.value, op.getValue());
        }
    }

    static int size, m, ans;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][n];
        ArrayList<Point> house = new ArrayList<>();
        ArrayList<Point> chicken = new ArrayList<>();

        HashSet<Point> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    house.add(new Point(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Point(i, j));
                    set.add(new Point(i, j));
                }
            }
        }

        arr = new int[m];
        size = chicken.size();
        int houseSize = house.size();
        ArrayList[] chickenLen = new ArrayList[houseSize];
        for (int i = 0; i < houseSize; i++) chickenLen[i] = len(house.get(i), set);


        //m개의 치킨집 선정해 길이 구하기.
        ans = Integer.MAX_VALUE;
        combi(0, 0, chicken, chickenLen);
        System.out.println(ans);
    }

    private static ArrayList len(Point point, HashSet<Point> set) {
        ArrayList<Point> list = new ArrayList<>();
        for (Point p : set) {
            int value = Math.abs(point.getR() - p.getR()) + Math.abs(point.getC() - p.getC());
            list.add(new Point(p.getR(), p.getC(), value));
        }
        Collections.sort(list);
        return list;
    }


    private static void combi(int idx, int start, ArrayList<Point> chicken, ArrayList<Point>[] chickenLen) {
        if (idx == m) {
            HashSet<Point> set = new HashSet<>();
            for (int i : arr) {
                set.add(chicken.get(i));
            }

            int len = 0;
            for (ArrayList<Point> points : chickenLen) {
                for (int j = 0; j < size; j++) {
                    Point tmp = points.get(j);
                    if (set.contains(tmp)) {
                        len += tmp.getValue();
                        break;
                    }
                }
            }
            ans = Math.min(ans, len);
            return;
        }

        for (int i = start; i < size; i++) {
            arr[idx] = i;
            combi(idx + 1, i + 1, chicken, chickenLen);
        }
    }
}

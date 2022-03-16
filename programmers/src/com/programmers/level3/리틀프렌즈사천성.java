package com.programmers.level3;


import java.util.*;

/**
 * FileName : 리틀프렌즈사천성
 * Author : David
 * Date : 2022-03-16
 * Description : 리틀 프렌즈 사천성 problem 실패
 */
class 리틀프렌즈사천성 {


    char[][] map;
    boolean[][] check;

    public String solution(int m, int n, String[] board) {
        StringBuilder answer = new StringBuilder();
        map = new char[m][n];
        HashSet<Character> set = new HashSet<>();
        check = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
                if (map[i][j] == '*' || map[i][j] == '.')
                    check[i][j] = true;
                else
                    set.add(map[i][j]);
            }
        }

        int size = set.size();
        ArrayList<Point> list = new ArrayList<>();
        while (size > 0) {
            //map 전부 탐색
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (!check[i][j]) {
                        findPoint(i, j, m, n, list);
                    }
                }
            }

            if (list.size() == 0) {
                answer = new StringBuilder("IMPOSSIBLE");
                break;
            }

            list.sort(Comparator.comparing(o -> o.word));
            //list에 추가된 point 전부 삭제 및 answer update
            if (!list.isEmpty()) {
                Point point = list.get(0);
                answer.append(point.word);
                map[point.sr][point.sc] = '.';
                map[point.er][point.ec] = '.';
                size--;
                list.remove(0);
            }
        }

        return answer.toString();
    }

    private void findPoint(int i, int j, int m, int n, ArrayList<Point> list) {
        Point point = new Point(i, j, map[i][j] + "");

        bfs(i, j, point, m, n);

        //마무리
        if (point.er != -1 && point.ec != -1) {
            check[i][j] = true;
            check[point.er][point.ec] = true;
            list.add(point);
        }
    }

    int[] dr = {0, -1, 0, 1, 0};
    int[] dc = {0, 0, 1, 0, -1};

    private void bfs(int r, int c, Point point, int m, int n) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{r, c, 0, 0});
        boolean[][] visited = new boolean[m][n];
        visited[r][c] = true;
        char end = point.word.charAt(0);
        while (!que.isEmpty()) {
            int[] now = que.poll();

            if (end == map[now[0]][now[1]] && !(now[0] == point.sr && now[1] == point.sc)) {
                point.er = now[0];
                point.ec = now[1];
                return;
            }

            for (int i = 1; i <= 4; i++) {
                int tr = now[0] + dr[i];
                int tc = now[1] + dc[i];
                if (tr < 0 || tc < 0 || tr > m - 1 || tc > n - 1) continue;
                if (visited[tr][tc]) continue;
                if (map[tr][tc] != end && map[tr][tc] != '.') continue;
                if (now[2] == 0) {
                    visited[tr][tc] = true;
                    que.offer(new int[]{tr, tc, i, 0});
                } else if (now[3] == 0) {
                    visited[tr][tc] = true;
                    que.offer(new int[]{tr, tc, now[2], now[2] == i ? 0 : i});
                } else {
                    if (now[3] == i) {
                        visited[tr][tc] = true;
                        que.offer(new int[]{tr, tc, now[2], now[3]});
                    }
                }
            }
        }
    }

    class Point {
        int sr, sc, er, ec;
        String word;

        Point(int sr, int sc, String word) {
            this.sr = sr;
            this.sc = sc;
            this.er = -1;
            this.ec = -1;
            this.word = word;
        }
    }
}

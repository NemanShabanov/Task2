package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[][] A = new int[7][3];
        A[0][0] = 5;
        A[0][1] = 4;
        A[0][2] = 4;
        A[1][0] = 4;
        A[1][1] = 3;
        A[1][2] = 4;
        A[2][0] = 3;
        A[2][1] = 2;
        A[2][2] = 4;
        A[3][0] = 2;
        A[3][1] = 2;
        A[3][2] = 2;
        A[4][0] = 3;
        A[4][1] = 3;
        A[4][2] = 4;
        A[5][0] = 1;
        A[5][1] = 4;
        A[5][2] = 4;
        A[6][0] = 4;
        A[6][1] = 1;
        A[6][2] = 1;

        int answer = Solution.solution(A);
        System.out.println(answer);
    }

}

class Solution {


    public static int solution(int[][] A) {
        Map<Integer, HashSet<Integer>> visited = new HashMap<>();
        int rows = A.length;
        int columns = A[0].length;
        int countries = 0;

        for (int i = 0; i < rows; i++) {
            visited.put(i, new HashSet<>());
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                if (visited.get(r).contains(c)) {
                    continue;
                } else {
                    countries += 1;
                    int country = A[r][c];
                    check_neighbors(r, c, visited, A, country);
                }
            }
        }

        return countries;

    }


    private static void check_neighbors(int x, int y, Map<Integer, HashSet<Integer>> visited, int[][] land, int country) {
        int rows = land.length;
        int columns = land[0].length;
        if (x < 0 || y < 0 || x == rows || y == columns || visited.get(x).contains(y) || land[x][y] != country) {
            return;
        }
        visited.get(x).add(y);

        check_neighbors(x + 1, y, visited, land, country);
        check_neighbors(x - 1, y, visited, land, country);
        check_neighbors(x, y + 1, visited, land, country);
        check_neighbors(x, y - 1, visited, land, country);
    }

}


import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author I353540
 */
 //左上角起点，雅典娜在右下角，只能向下和向右走，每格血量要大于等于1，每格是损失的血量，求最小的血量。
class Main {

    public static void main(String[] args) {

//        int[][] map = new int[][]{
//            new int[]{-2, -3, 3},
//            new int[]{-5, 10, 1},
//            new int[]{0, 30, -5}};
int[][] map = new int[][]{
            new int[]{-1, -3, -4},
            new int[]{2, -4, -2},
            new int[]{-10, 0, 0}};
        int res = find(map, 0, 0, 0, 0);
        if (res >= 1) {
            res = 1;
        } else {
            res = -res + 1;
        }
        System.out.println(res);
    }

    public static int find(int[][] map, int x, int y, int min, int sum) {
        if (x == map.length || y == map[0].length) {
            return -100000;
        }
        if (x == map.length - 1 && y == map.length - 1) {
            return Math.min(min, sum += map[x][y]);
        }
        sum += map[x][y];
        min = Math.min(min, sum);
        min = Math.max(find(map, x, y + 1, min, sum), find(map, x + 1, y, min, sum));
//        min = Math.max(min, );
        return min;
    }
}
/*
4 5
1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
 */

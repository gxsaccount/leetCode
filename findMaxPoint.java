/**
P为给定的二维平面整数点集。定义 P 中某点x，如果x满足 P 中任意点都不在 x 的右上方区域内（横纵坐标都大于x），则称其为“最大的”。求出所有“最大的”点的集合。（所有点的横坐标和纵坐标都不重复, 坐标轴范围在[0, 1e9) 内）
输入描述:
第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
对于 50%的数据,  1 <= N <= 10000;
对于 100%的数据, 1 <= N <= 500000;


输出描述:
输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。

输入例子1:
5
1 2
5 3
4 6
7 5
9 0

输出例子1:
4 6
7 5
9 0
*/

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author I353540
 */
class Main1{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        PriorityQueue<Tuple> queue=new PriorityQueue<>();
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++) {
            String[] nodeStr = in.nextLine().trim().split(" ");
            int x=Integer.parseInt(nodeStr[0]);
            int y=Integer.parseInt(nodeStr[1]);
            queue.add(new Tuple(x, y));
        }
        List<Tuple> tuples = new ArrayList<>();
        tuples.add(queue.poll());
        int preX = tuples.get(0).x;
        int preY = tuples.get(0).y;
        while(!queue.isEmpty()){
            Tuple tuple = queue.poll();
            if(tuple.y>preY){
                preY = tuple.y;
                tuples.add(tuple);
            }
        }
        for(int i= tuples.size()-1;i>=0;i--){
            System.out.println(tuples.get(i).x+" "+tuples.get(i).y);
        }
    }
}
class Tuple implements Comparable<Tuple>{
    int x;
    int y;

    public Tuple(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Tuple o) {
        if(this.x<o.x){
            return 1;
        }
        
        return -1;
    }

    @Override
    public String toString() {
        return "Tuple{" + "x=" + x + ", y=" + y + '}';
    }
    
}



import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author I353540
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(in.nextLine());
        for (int i = 0; i < N; i++) {
            String[] nodeStr = in.nextLine().trim().split(" ");
            int x = Integer.parseInt(nodeStr[0]);
            int y = Integer.parseInt(nodeStr[1]);
            if (!map.containsKey(x)) {
                map.put(x, y);
            } else if (y > map.get(x)) {
                map.put(x, y);
            }
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        int maxY = -1;
        ArrayList<String> re = new ArrayList<>();
        for (Integer key : list) {
            if (maxY < map.get(key)) {
                maxY = map.get(key);
                re.add(key + " " + maxY );
            }
        }
        for (int i = list.size()-1; i >= 0; i--) {
            System.out.println(re.get(i));
        }
    }
}




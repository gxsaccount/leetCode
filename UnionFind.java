
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*
10
0
5 3 0
8 4 0
9 0
9 0
3 0
0
7 9 0
0 
9 7 0
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<Integer>();
        int n = sc.nextInt();
        //初始时每个元素代表一个集合，该元素本身就是树根。
        int[] father = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            father[i] = i;
        }
        int m = 1;
        while (m <= n) {
            int a = sc.nextInt();
            if (a == 0) {
                m++;
                continue;
            }
            int x = Find_Set(a, father);
            int y = Find_Set(m, father);
            Union(x, y, father);

        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (father[i] == i) {
                count++;
            }
        }
        System.out.println(count);

    }
    //Union操作就是将两个不相交的子集合合并成一个大集合。
    //简单的Union操作是非常容易实现的，因为只需要把一棵子树的根结点指向另一棵子树即可完成合并。
    public static void Union(int x, int y, int[] father) {
        int f1 = Find_Set(x, father);
        int f2 = Find_Set(y, father);
        if (f1 != f2) {
            father[f1] = f2;
        }

    }
    //Find操作需要找到该子集合的代表元素，而代表元素是树根
    public static int Find_Set(int x, int[] father) {
        if (x != father[x]) {
            father[x] = Find_Set(father[x], father);
        }
        return father[x];
    }

}

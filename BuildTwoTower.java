/*
Mr. F有N块水晶，每块水晶有一个高度，他想用这N块水晶搭建两座有同样高度的塔，使他们成为一座双塔，Mr. F可以从这N块水晶中任取M（1≤M≤N）块来搭建。
但是他不知道能否使两座塔有同样的高度，也不知道如果能搭建成一座双塔，这座双塔的最大高度是多少。所以他来请你帮忙。

给定水晶的数量N（1≤N≤100）和每块水晶的高度Hi（N块水晶高度的总和不超过2000），你的任务是判断Mr. F能否用这些水晶搭建成一座双塔（两座塔有同样的高度）
，如果能，则输出所能搭建的双塔的最大高度，否则输出“Impossible”。

1 3 4 5 2  ==>  7
*/
public class BuildTwoTower {
    public static void main(String[] args) {
        System.out.println(findMax0(0, 0, 0, new int[]{1,3,4,5,2}));
    }
    public static int findMax0(int t1,int t2,int index,int [] nums){
        if(nums.length==index) return t1==t2?t1:0;
        int max =0;
        if(t1==t2){
            max = t1;
        }
        max=Math.max(max, findMax0(t1+nums[index], t2,index+1, nums));
        max=Math.max(max, findMax0(t1, t2,index+1, nums));
        max=Math.max(max, findMax0(t1, t2+nums[index],index+1, nums));
        
        return max;
    }
}

//https://leetcode.com/problems/n-queens/description/
class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> resluts = new ArrayList<>();
        if (n <= 0) return resluts;
        int[] queen =new int[n];//每个位置i代表q在 i,queen[i]上立足
        for(int i=0;i<n;i++) queen[i]=i;
        solveNQueens(resluts,queen,0);
        return resluts;
    }
    public void solveNQueens(List<List<String>> resluts,int[]reslut,int start){
        int n=reslut.length;
        if(start==n-1){
            if(check(reslut)) resluts.add(generStr(reslut));
            return;
        }
        for(int i=start;i<n;i++){
            int temp = reslut[start];
            reslut[start] = reslut[i];
            reslut[i] = temp;
            solveNQueens(resluts, reslut,start + 1);
            temp = reslut[start];
            reslut[start] = reslut[i];
            reslut[i] = temp;
            
        }
        
    }
    public boolean check(int[] reslut) {
        for (int i = 0; i < reslut.length; i++) {
            for (int j = i+1; j < reslut.length; j++) {
                if ((i - j == reslut[i] - reslut[j])||(j-i   == reslut[i] - reslut[j])) {
                    return false;
                }
            }
        }
        return true;
    } 
    public List<String> generStr(int[] reslut) {
        List<String> resStr = new ArrayList<>();
        for (int i = 0; i < reslut.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < reslut.length; j++) {
                if (reslut[i] != j) {
                    sb.append(".");
                } else {
                    sb.append("Q");
                }
            }
            resStr.add(sb.toString());
        }
        return resStr;
    }
}

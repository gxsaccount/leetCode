/*剪绳子，各段乘积最大值*/
class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProductAfterCutting(8));
    }

    public int maxProductAfterCutting(int length){
        if(length<=0) return 0;
        if(length==1) return 0;
        if(length==2) return 1;
        if(length==3) return 2;
        int[] products=new int[length+1];
        products[0]=0;
        products[1]=1;
        products[2]=2;
        products[3]=3;
        for (int i = 4; i <= length; i++) {
            products[i]=0;
            for (int j = 0; j <= i/2; j++) {
                products[i]=Math.max(products[j]*products[i-j],products[i]);
            }
        }
        return products[length];
    }
}
